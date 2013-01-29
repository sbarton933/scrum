package org.eclipse.emf.ecp.scrum.sprintplanner.view;

import java.text.Collator;
import java.util.HashMap;

import javax.xml.bind.helpers.DefaultValidationEventHandler;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.Scrum.Sprint;

import org.eclipse.emf.ecp.Scrum.impl.SprintImpl;
import org.eclipse.emf.ecp.Scrum.impl.TaskImpl;
import org.eclipse.emf.ecp.scrum.sprintplanner.action.ColumnView;
import org.eclipse.emf.ecp.scrum.sprintplanner.dnd.BacklogItemTransfer;
import org.eclipse.emf.ecp.scrum.sprintplanner.dnd.SprintDragListener;
import org.eclipse.emf.ecp.scrum.sprintplanner.dnd.SprintDropListener;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.part.EditorInputTransfer;
import org.eclipse.ui.part.ViewPart;

public class SprintViewer extends ViewPart{
	
	protected TableViewer viewerSprint;
	protected TableViewer viewerDefault;
	private Sprint sprint;
	SprintViewer sprintViewer;
	IWorkbenchPartSite site;
	private ColumnView col = new ColumnView();
	
	private AdapterFactoryContentProvider adapterFactoryContentProvider;
	private ComposedAdapterFactory composedAdapterFactory;
	
	HashMap<String, String> tableColumnDirection = null;
	
	public SprintViewer(Composite parent, IWorkbenchPartSite site){
		this.site = site;
//		createPartControl(parent);
	}

	@Override
	public void createPartControl(Composite parent) {
		sprintViewer = this;
		
		GridLayout layout = new GridLayout(2,false);
	    parent.setLayout(layout);
	    createSprintViewer(parent);
		createDefaultViewer(parent);
		
		setSprintDropListler(viewerSprint);
	}

	private void setSprintDropListler(TableViewer viewerSprint2) {		
	    int operations = DND.DROP_COPY| DND.DROP_MOVE;
	    Transfer[] transferTypes = new Transfer[]{BacklogItemTransfer.getInstance()};
	    viewerSprint.addDropSupport(operations, transferTypes, new SprintDropListener(viewerSprint, viewerDefault));
	}

	private void createDefaultViewer(Composite parent) {
		viewerDefault = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    //createColumns(parent, viewer);
		AdapterFactory adapterFactory = getAdapterFactory();
	    col.createTableViewerColumns(parent, viewerDefault, adapterFactory);
	    final Table table = viewerDefault.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewerDefault.setContentProvider(new ArrayContentProvider());
	    
	    int operations = DND.DROP_COPY| DND.DROP_MOVE;
	    Transfer[] transferTypes = new Transfer[]{BacklogItemTransfer.getInstance()};
	    viewerDefault.addDragSupport(operations, transferTypes, new SprintDragListener(viewerDefault));
	    // Make the selection available to other views
	    site.setSelectionProvider(viewerDefault);
	    // Set the sorter for the table

	    // Layout the viewer
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewerDefault.getControl().setLayoutData(gridData);
	}

	private void createSprintViewer(Composite parent) {
		viewerSprint = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    //createColumns(parent, viewer);
		AdapterFactory adapterFactory = getAdapterFactory();
	    col.createTableViewerColumns(parent, viewerSprint, adapterFactory);
	    final Table table = viewerSprint.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewerSprint.setContentProvider(new ArrayContentProvider());
	    
	    int operations = DND.DROP_COPY| DND.DROP_MOVE;
	    Transfer[] transferTypes = new Transfer[]{BacklogItemTransfer.getInstance()};
	    viewerSprint.addDragSupport(operations, transferTypes, new SprintDragListener(viewerSprint));
	    //viewerSprint.addDropSupport(operations, transferTypes, new SprintDropListener(viewerSprint));
	    if(getSprint()!=null)
	    {
	    	viewerSprint.setInput(getSprint().getBacklogItems());
	    }
	    // Make the selection available to other views
	    site.setSelectionProvider(viewerSprint);
	    
	    // Set the sorter for the table

	    // Layout the viewer
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewerSprint.getControl().setLayoutData(gridData);
		
	}

	@Override
	public void setFocus() {
		viewerSprint.getControl().setFocus();	
		
	}
	
	public Sprint getSprint(){
		return this.sprint;
	}
	
	public void loadContent(Sprint sprint) {
		setSprint(sprint);		
	}
	
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
	EContentAdapter adapter = new EContentAdapter() {
	      public void notifyChanged(Notification notification) {
	    	  	
	    	    //notification.
	    	    try
	    	    {
			        super.notifyChanged(notification);
		
			        SprintImpl tImpl = (SprintImpl) notification.getNotifier();
//			        getSprint().getBacklogItems().add((BacklogItem) tImpl);
			        viewerSprint.setInput(getSprint().getBacklogItems());
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
	    
		public void setSprintContent()
		{
			if(getSprint()!=null)
		    {					
				for(int i=0; i<getSprint().getBacklogItems().size(); i++)
				{
					getSprint().getBacklogItems().get(i).eAdapters().add(adapter);
				}
				viewerSprint.setInput(getSprint().getBacklogItems());
		    }
		}
		
		protected AdapterFactory getAdapterFactory() {
			if (composedAdapterFactory == null) {
				composedAdapterFactory = new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			}
			return composedAdapterFactory;
		}
		
}
