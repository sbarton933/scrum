package org.eclipse.scrum.tasklist.popup.actions;

import java.net.URL;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.ScrumFactory;
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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.ecp.Scrum.Status;
import org.eclipse.emf.ecp.Scrum.impl.TaskImpl;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;


public class TaskListView extends ViewPart {
	public static final String ID = "org.eclipse.scrum.tasklist.view";
	
	private TableViewer viewer;
	private User user;
	
	public Status status;
	ComboBoxViewerCellEditor cellEditor = null;
	
	private static final Image TASK_IMAGE = getImage("application_view_tile.png");
	
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
		AdapterFactory adapterFactory = getAdapterFactory();
	    createTableViewerColumns(parent, viewer, adapterFactory);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewer.setContentProvider(new ArrayContentProvider());
	    if(getUser()!=null)
	    {
	    	viewer.setInput(getUsertaskBacklogItem());
	    }
	    
	    // Make the selection available to other views
	    getSite().setSelectionProvider(viewer);

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
			            // only set new value if it differs from old one 
			            if (!t.getStatus().getName().equals(newStatus)) {
			                t.setStatus(newStatus);
			            }
			        }
					
					viewer.setInput(getUsertaskBacklogItem());
				}
				
				@Override
				protected Object getValue(Object arg0) {
					if (arg0 instanceof Task) {
						Task t = (Task)arg0;
			            return t.getStatus();
			        }
			        return null;
				}
				
				@Override
				protected CellEditor getCellEditor(Object arg0) {
					return cellEditor;
				}
				
				@Override
				protected boolean canEdit(Object arg0) {
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

		BacklogItem[] items = (BacklogItem[]) getUser().getBacklogItems().toArray();
		BacklogItem[] oldItems = (BacklogItem[]) getUser().getBacklogItems().toArray();
		EList<BacklogItem> newBacklogItem = getUser().getBacklogItems();//new BasicEList<BacklogItem>();
		
        Collator collator = Collator.getInstance(Locale.getDefault());
        for (int i = 0; i < items.length-1; i++) {
          String value1 = getItem(items[i], columnName);
          int currSelectedindex = i;
          for (int j = i+1; j < items.length; j++) {
            String value2 = getItem(items[j], columnName);
            if(!isAsc)
            {
	            if (collator.compare(value1, value2) > 0) {
	            	value1 = getItem(items[currSelectedindex], columnName);
	            }
	            else {
	            	value1 = getItem(items[j], columnName);
	            	currSelectedindex = j;
	            }
            }
            else
            {
            	if (collator.compare(value1, value2) <= 0) {
	            	value1 = getItem(items[currSelectedindex], columnName);
	            }
	            else {
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
        
        viewer.setInput(getUsertaskBacklogItem());
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
		
		return columnValue == null ? "" : columnValue;
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
	    	     	    
	    viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {
	    @Override
  	    public String getColumnText(Object element, int columnIndex) {
    	  	String result = "";
    	  	
    	  	try
    	  	{
	    	  	Task t = (Task) element;
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
    	  	}
    	  	catch(Exception ex){}
    	  	
  	    	return result;
      	}

  	    @Override
		public Image getColumnImage(Object object, int columnIndex) {
			if(columnIndex == 0)
				return super.getColumnImage(object, columnIndex);
			else
				return null;
		}
  	    
  	    });
	}
	
	// Helper Method to load the images
	private static Image getImage(String file) {
	  Bundle bundle = FrameworkUtil.getBundle(TaskListView.class);
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
		if(this.user != null)			
			getUsertaskBacklogItem();
		
		return this.user;
	}
	
	private List<BacklogItem> getUsertaskBacklogItem(){
		
		List<BacklogItem> tempList = new ArrayList<BacklogItem>();
		EList<BacklogItem> backlogItemList = this.user.getBacklogItems();
		
		for(int i=0; i<backlogItemList.size(); i++)
		{
			if(backlogItemList.get(i).getClass().getName().equals(TaskImpl.class.getName()) && !(backlogItemList.get(i).getStatus().equals(Status.FINISHED)))
			{
				tempList.add(backlogItemList.get(i));
			}
		}
				
		return tempList;
	}

	EContentAdapter adapter = new EContentAdapter() {
      public void notifyChanged(Notification notification) {
    	  	
    	    //notification.
    	    try
    	    {
		        super.notifyChanged(notification);
	
		        TaskImpl tImpl = (TaskImpl) notification.getNotifier();
		        getUser().getBacklogItems().add(tImpl);
		        viewer.setInput(getUsertaskBacklogItem());
	      	    
    	    }
    	    catch(Exception e)
    	    {
    	    	
    	    }
      }
    };

	public void setContent()
	{
		if(getUser()!=null)
	    {				
			for(int i=0; i<getUser().getBacklogItems().size(); i++)
			{
				getUser().getBacklogItems().get(i).eAdapters().add(adapter);
			}
	    	viewer.setInput(getUsertaskBacklogItem());
	    }
	}

}