package org.eclipse.scrum.tasklist.popup.actions;

import java.net.URL;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.emf.ecp.Scrum.ScrumPackage;
import org.eclipse.emf.ecp.Scrum.Task;
import org.eclipse.emf.ecp.Scrum.User;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.ecp.Scrum.Status;
import org.eclipse.emf.ecp.Scrum.impl.BacklogImpl;
import org.eclipse.emf.ecp.Scrum.impl.ScrumFactoryImpl;
import org.eclipse.emf.ecp.Scrum.impl.TaskImpl;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.events.PaintEvent;  
import org.eclipse.swt.events.PaintListener;  
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;  
import org.eclipse.swt.widgets.Canvas;  
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;


public class TaskListView extends ViewPart {
	public static final String ID = "org.eclipse.scrum.tasklist.view";
	
	private TableViewer viewer;
	private User user;
	
	public Status status;
	ComboBoxViewerCellEditor cellEditor = null;
	
	private static final Image TASK_IMAGE = getImage("task.png");
	
	private AdapterFactoryContentProvider adapterFactoryContentProvider;
	private ComposedAdapterFactory composedAdapterFactory;
	
	TaskListView thisTaskListView;
	
	HashMap<String, String> tableColumnDirection = null;
	
	
	
	@Override
	public void createPartControl(Composite parent) {
		
		thisTaskListView = this;
				
		GridLayout layout = new GridLayout(2, false);
	    parent.setLayout(layout);
	    createViewer(parent);
		
	}

	private void createViewer(Composite parent) {	
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    //createColumns(parent, viewer);
		AdapterFactory adapterFactory = getAdapterFactory();
	    createTableViewerColumns(parent, viewer, adapterFactory);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewer.setContentProvider(new ArrayContentProvider());
	    //viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
	    // Get the content for the viewer, setInput will call getElements in the
	    // contentProvider
	    //viewer.setInput(ModelProvider.INSTANCE.getTasks());
	    if(getUser()!=null)
	    {
	    	viewer.setInput(getUser().getBacklogItems());
	    }
	    // Make the selection available to other views
	    getSite().setSelectionProvider(viewer);
	    // Set the sorter for the table

	    // Layout the viewer
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	}
		
	private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		
	    TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);	    
	    viewerColumn.setLabelProvider(new ColumnLabelProvider() {
		      
		      @Override
		      public Image getImage(Object element) {
		        
		          return TASK_IMAGE;
		      }
		      
	    });
	    final TableColumn column = viewerColumn.getColumn();
	    column.setText(title);
	    column.setWidth(bound);
	    column.setResizable(true);
	    column.setMoveable(true);
	    column.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				
				tableSortHandler(arg0);
				
			}
		});
		    
	    if(colNumber == 5)
		{		
			cellEditor = new ComboBoxViewerCellEditor((Composite) viewer.getControl(), SWT.READ_ONLY);
			cellEditor.setLabelProvider(new LabelProvider());
	        cellEditor.setContenProvider(new ArrayContentProvider());
	        cellEditor.setInput(Status.values());
			
			viewerColumn.setEditingSupport(new EditingSupport(viewer) {
				
				@Override
				protected void setValue(Object arg0, Object arg1) {
					if (arg0 instanceof Task && arg1 instanceof Status) {
						Task t = (Task) arg0;
						Status newStatus = (Status) arg1;
			            /* only set new value if it differs from old one */
			            if (!t.getStatus().getName().equals(newStatus)) {
			                t.setStatus(newStatus);
			            }
			        }
					
					viewer.setInput(getUser().getBacklogItems());
				}
				
				@Override
				protected Object getValue(Object arg0) {
					// TODO Auto-generated method stub
					if (arg0 instanceof Task) {
						Task t = (Task)arg0;
			            return t.getStatus();
			        }
			        return null;
				}
				
				@Override
				protected CellEditor getCellEditor(Object arg0) {
					// TODO Auto-generated method stub
					return cellEditor;
				}
				
				@Override
				protected boolean canEdit(Object arg0) {
					// TODO Auto-generated method stub
					return true;
				}
			});
		}
		
	    return viewerColumn;
	}	
	
	private void tableSortHandler(Event e)
	{		
		TableColumn tc = (TableColumn) e.widget;				
		String columnName = tc.getText();
		
		boolean isAsc = tableColumnDirection.get(columnName).toString().equals("asc");

		//BacklogItem[] oldItems = (BacklogItem[])((EList<BacklogItem>)viewer.getInput()).toArray(new BacklogItem[((EList<BacklogItem>)viewer.getInput()).size()]);
		
		BacklogItem[] items = (BacklogItem[]) getUser().getBacklogItems().toArray();
		BacklogItem[] oldItems = (BacklogItem[]) getUser().getBacklogItems().toArray();
		EList<BacklogItem> newBacklogItem = getUser().getBacklogItems();//new BasicEList<BacklogItem>();
		//BacklogItem tempBacklogItem = null;
		
        Collator collator = Collator.getInstance(Locale.getDefault());
        for (int i = 0; i < items.length-1; i++) {
    	  //tempBacklogItem = null;
          String value1 = getItem(items[i], columnName);
          int currSelectedindex = i;
          for (int j = i+1; j < items.length; j++) {
            String value2 = getItem(items[j], columnName);
            if(!isAsc)
            {
	            if (collator.compare(value1, value2) > 0) {
	            	//tempBacklogItem = items[currSelectedindex];
	            	value1 = getItem(items[currSelectedindex], columnName);
	            }
	            else {
	            	//tempBacklogItem = items[j];
	            	value1 = getItem(items[j], columnName);
	            	currSelectedindex = j;
	            }
            }
            else
            {
            	if (collator.compare(value1, value2) <= 0) {
	            	//tempBacklogItem = items[currSelectedindex];
	            	value1 = getItem(items[currSelectedindex], columnName);
	            }
	            else {
	            	//tempBacklogItem = items[j];
	            	value1 = getItem(items[j], columnName);
	            	currSelectedindex = j;
	            }
            }
          }
          
          BacklogItem tempBacklogItem1 = items[i]; 
          BacklogItem tempBacklogItem2 = items[currSelectedindex]; 
          
          newBacklogItem.set(i, ScrumFactory.eINSTANCE.createTask());              
          newBacklogItem.set(currSelectedindex, tempBacklogItem1); 
          newBacklogItem.set(i, tempBacklogItem2);  
          
          items[i] = tempBacklogItem2;
          items[currSelectedindex] = tempBacklogItem1;
        }
        
        //Collections.re
        
        if(isAsc)
        {
        	if(!isPreOrdered(items, oldItems, columnName))
        	{
        		tableColumnDirection.put(columnName, "desc"); 
        	}
        	else
        	{
        		newBacklogItem = reverse(newBacklogItem);
        		tableColumnDirection.put(columnName, "asc"); 
        	}
        }
        else
        {
        	if(!isPreOrdered(items, oldItems, columnName))
        	{
        		tableColumnDirection.put(columnName, "asc");
        	}
        	else
        	{
        		newBacklogItem = reverse(newBacklogItem);
        		tableColumnDirection.put(columnName, "desc"); 
        	}
        	 
        }
        
        //o = newBacklogItem.toArray();
        //o = newBacklogItem.toArray(new BacklogItem[newBacklogItem.size()]);
        
        //EList<BacklogItem> convBacklogItem = (EList<BacklogItem>) Arrays.asList(newBacklogItem.toArray(new BacklogItem[newBacklogItem.size()]));
        viewer.setInput(newBacklogItem);
	}
	
	private EList<BacklogItem> reverse(EList<BacklogItem> backlogItems)
	{
		EList<BacklogItem> revBacklogItems = new BasicEList<BacklogItem>();
		
		for (int i=backlogItems.size()-1; i>=0; i--) {
			revBacklogItems.add(backlogItems.get(i));
			backlogItems.set(i, ScrumFactory.eINSTANCE.createTask());
		}
		
		for (int i=0; i<revBacklogItems.size(); i++) {
			backlogItems.set(i, (BacklogItem)revBacklogItems.get(i));
		}
		
		return backlogItems;
	}

	private boolean isPreOrdered(BacklogItem[] items, BacklogItem[] oldItems, String columnName)
	{
		boolean preOrdered = true;
		
		for(int i=0; i<items.length; i++ )
		{
			if(!getItem(items[i], columnName).equals(getItem(oldItems[i], columnName)))
			{
				preOrdered = false;
				break;
			}
		}
		
		return preOrdered;
	}
	
	private String getItem(BacklogItem item, String columnName)
	{
		String columnValue = "";
		
		if(columnName.equals("Name"))
			columnValue = item.getName();
		else if(columnName.equals("ID"))
			columnValue = Integer.toString(item.getID());
		else if(columnName.equals("Description"))
			columnValue = item.getDescription();
		else if(columnName.equals("Priority"))
			columnValue = Integer.toString(item.getPriority());
		else if(columnName.equals("Story Point"))
			columnValue = Integer.toString(item.getStoryPoints());
		else if(columnName.equals("Status"))
		{
			String status = item.getStatus().getName();				    	  
			columnValue = status;
		}
		else
			columnValue = "";
		
		return columnValue;
	}
	
	private void createTableViewerColumns(final Composite parent, final TableViewer viewer, final AdapterFactory adapterFactory)
	{
		String[] titles = { "Name", "ID", "Description", "Priority", "Story Point", "Status" };
	    int[] bounds = { 200, 100, 450, 100, 100, 100 };
		
	    if(tableColumnDirection == null)
	    {
	    	tableColumnDirection = new HashMap<String, String>();
	    	tableColumnDirection.put("Name", "asc"); 
	    	tableColumnDirection.put("ID", "asc"); 
	    	tableColumnDirection.put("Description", "asc"); 
	    	tableColumnDirection.put("Priority", "asc"); 
	    	tableColumnDirection.put("Story Point", "asc");
	    	tableColumnDirection.put("Status", "asc");
	    }

	    createTableViewerColumn(titles[0], bounds[0], 0); 
	    createTableViewerColumn(titles[1], bounds[1], 1);
	    createTableViewerColumn(titles[2], bounds[2], 2);
	    createTableViewerColumn(titles[3], bounds[3], 3);
	    createTableViewerColumn(titles[4], bounds[4], 4);
	    createTableViewerColumn(titles[5], bounds[5], 5);
	    	    
        //viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {  	    
	    viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {
	    @Override
  	      public String getColumnText(Object element, int columnIndex) {
    	  	Task t = (Task) element;
    	  	String result = "";
    	  
  	    	switch(columnIndex){
				case 0:
					result = t.getName();
					break;
				case 1:
					result = Integer.toString(t.getID());
					break;
				case 2:
					result = t.getDescription();
					break;
				case 3:
					result = Integer.toString(t.getPriority());
					break;
				case 4:
					result = Integer.toString(t.getStoryPoints());
					break;
				case 5:
					String status = t.getStatus().getName();				    	  
					result = status;
					break;
				default:
					result = "";
  	    	}
    	  
  	    	return result;
      	}

  	    @Override
		public Image getColumnImage(Object object, int columnIndex) {
			if(columnIndex == 0)
				return super.getColumnImage(object, columnIndex);
			else
				return null;
		}

		/*@Override
		protected Image getImageFromObject(Object object) {
			// TODO Auto-generated method stub
			return TASK_IMAGE;
		}*/
  	    
  	    });
	}
	
	// Helper Method to load the images
	private static Image getImage(String file) {
	  Bundle bundle = FrameworkUtil.getBundle(View.class);
	  URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
	  ImageDescriptor image = ImageDescriptor.createFromURL(url);
	  return image.createImage();

	} 
	
	protected AdapterFactory getAdapterFactory() {
		if (composedAdapterFactory == null) {
			composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return composedAdapterFactory;
	}
		
	public void setTitleIconImage()
	{
		thisTaskListView.setTitleImage(TASK_IMAGE);
	}
	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();		
	}

	public void loadContent(User user) {
		setUser(user);		
	}

	private void setUser(User user) {
		this.user = user;
	}
	
	private User getUser(){
		return this.user;
	}

	EContentAdapter adapter = new EContentAdapter() {
      public void notifyChanged(Notification notification) {
    	  	
    	    //notification.
    	    try
    	    {
		        super.notifyChanged(notification);
	
		        TaskImpl tImpl = (TaskImpl) notification.getNotifier();
		        getUser().getBacklogItems().add(tImpl);
		        viewer.setInput(getUser().getBacklogItems());
	      	    /*System.out.println("Event Type : " + notification.getEventType());
	            if(notification.getEventType() == Notification.SET)
	            {  
	                System.out.println("Story Point : " + tImpl.getStoryPoints());
	            }*/
    	    }
    	    catch(Exception e)
    	    {
    	    	
    	    }
      }
    };
    
    Adapter adapterSecond = new AdapterImpl() {
        public void notifyChanged(Notification notification) {
        	
          //notification.
          Object o = notification.getNewValue();	
          ENotificationImpl eImpl = (ENotificationImpl) notification;	
          TaskImpl tImpl = (TaskImpl) notification.getNotifier();
          
      	  System.out.println("Event Type : " + notification.getEventType());
          if(notification.getEventType() == Notification.SET)
          {  
              System.out.println("Story Point : " + tImpl.getStoryPoints());
          }
        }
    };

	public void setContent()
	{
		if(getUser()!=null)
	    {	
			//User user = getUser();
			//user.eAdapters().add(adapter);
			
			for(int i=0; i<getUser().getBacklogItems().size(); i++)
			{
				getUser().getBacklogItems().get(i).eAdapters().add(adapter);
			}
	    	viewer.setInput(getUser().getBacklogItems());
	    }
	}

}