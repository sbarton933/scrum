package org.eclipse.emf.ecp.scrum.sprintplanner.action;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.Scrum.User;
import org.eclipse.emf.ecp.Scrum.impl.TaskImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

public class SprintPlannerView extends ViewPart {

	public static final String ID = "org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView";
	
	protected TableViewer viewer;
	private Sprint sprint;
	SprintPlannerView sprintView;
	SprintViewer sprintViewer;
	BacklogViewer backlogViewer;
	
	private AdapterFactoryContentProvider adapterFactoryContentProvider;
	private ComposedAdapterFactory composedAdapterFactory;
	
	@Override
	public void createPartControl(Composite parent) {
		sprintView = this;
		
		GridLayout layout = new GridLayout(2, false);
	    parent.setLayout(layout);
	    createSprintViewer(parent);
		createBacklogViewer(parent);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();	
		
	}
	
	private void createBacklogViewer(Composite parent){
		backlogViewer = new BacklogViewer(parent);
	}
	
	private void createSprintViewer(Composite parent) {
		sprintViewer = new SprintViewer(parent);
//		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
//	    //createColumns(parent, viewer);
//		AdapterFactory adapterFactory = getAdapterFactory();
//	    //createTableViewerColumns(parent, viewer, adapterFactory);
//	    final Table table = viewer.getTable();
//	    table.setHeaderVisible(true);
//	    table.setLinesVisible(true);
//	    
//	    GridLayout layout = new GridLayout();
//	    table.setLayout(layout);
//
//	    viewer.setContentProvider(new ArrayContentProvider());
//	    //viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
//	    // Get the content for the viewer, setInput will call getElements in the
//	    // contentProvider
//	    //viewer.setInput(ModelProvider.INSTANCE.getTasks());
//	    if(getSprint()!=null)
//	    {
//	    	viewer.setInput(getSprint().getBacklogItems());
//	    }
//	    // Make the selection available to other views
//	    getSite().setSelectionProvider(viewer);
//	    // Set the sorter for the table
//
//	    // Layout the viewer
//	    GridData gridData = new GridData();
//	    gridData.verticalAlignment = GridData.FILL;
//	    gridData.horizontalSpan = 2;
//	    gridData.grabExcessHorizontalSpace = true;
//	    gridData.grabExcessVerticalSpace = true;
//	    gridData.horizontalAlignment = GridData.FILL;
//	    viewer.getControl().setLayoutData(gridData);
	}
	
	protected AdapterFactory getAdapterFactory() {
		if (composedAdapterFactory == null) {
			composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return composedAdapterFactory;
	}
		
//	EContentAdapter adapter = new EContentAdapter() {
//	      public void notifyChanged(Notification notification) {
//	    	  	
//	    	    //notification.
//	    	    try
//	    	    {
//			        super.notifyChanged(notification);
//		
//			        TaskImpl tImpl = (TaskImpl) notification.getNotifier();
//			        getSprint().getBacklogItems().add(tImpl);
//			        viewer.setInput(getSprint().getBacklogItems());
//		      	    /*System.out.println("Event Type : " + notification.getEventType());
//		            if(notification.getEventType() == Notification.SET)
//		            {  
//		                System.out.println("Story Point : " + tImpl.getStoryPoints());
//		            }*/
//	    	    }
//	    	    catch(Exception e)
//	    	    {
//	    	    	
//	    	    }
//	      }
//	    };
//	
//	public void setContent()
//	{
//		if(getSprint()!=null)
//	    {	
//			//User user = getUser();
//			//user.eAdapters().add(adapter);
//			
//			for(int i=0; i<getSprint().getBacklogItems().size(); i++)
//			{
//				getSprint().getBacklogItems().get(i).eAdapters().add(adapter);
//			}
//	    	viewer.setInput(getSprint().getBacklogItems());
//	    }
//	}
//	
//	private Sprint getSprint(){
//		return this.sprint;
//	}
//	
//	public void loadContent(Sprint sprint) {
//		setSprint(sprint);		
//	}
//	
//	private void setSprint(Sprint sprint) {
//		this.sprint = sprint;
//	}
	
	public SprintViewer getSprintViewer(){
		return this.sprintViewer;
	}

}
