package org.eclipse.emf.ecp.scrum.sprintplanner.action;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.Scrum.impl.TaskImpl;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

public class SprintViewer extends ViewPart{
	
	
	private Sprint sprint;
	SprintPlannerView sprintView;
	
	public SprintViewer(Composite parent){
		sprintView.viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    //createColumns(parent, viewer);
		AdapterFactory adapterFactory = sprintView.getAdapterFactory();
	    //createTableViewerColumns(parent, viewer, adapterFactory);
	    final Table table = sprintView.viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    sprintView.viewer.setContentProvider(new ArrayContentProvider());
	    //viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
	    // Get the content for the viewer, setInput will call getElements in the
	    // contentProvider
	    //viewer.setInput(ModelProvider.INSTANCE.getTasks());
	    if(getSprint()!=null)
	    {
	    	sprintView.viewer.setInput(getSprint().getBacklogItems());
	    }
	    // Make the selection available to other views
	    getSite().setSelectionProvider(sprintView.viewer);
	    // Set the sorter for the table

	    // Layout the viewer
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    sprintView.viewer.getControl().setLayoutData(gridData);
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
	private Sprint getSprint(){
		return this.sprint;
	}
	
	public void loadContent(Sprint sprint) {
		setSprint(sprint);		
	}
	
	private void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
	EContentAdapter adapter = new EContentAdapter() {
	      public void notifyChanged(Notification notification) {
	    	  	
	    	    //notification.
	    	    try
	    	    {
			        super.notifyChanged(notification);
		
			        TaskImpl tImpl = (TaskImpl) notification.getNotifier();
			        getSprint().getBacklogItems().add(tImpl);
			        sprintView.viewer.setInput(getSprint().getBacklogItems());
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
	    
		public void setContent()
		{
			if(getSprint()!=null)
		    {	
				//User user = getUser();
				//user.eAdapters().add(adapter);
				
				for(int i=0; i<getSprint().getBacklogItems().size(); i++)
				{
					getSprint().getBacklogItems().get(i).eAdapters().add(adapter);
				}
		    	sprintView.viewer.setInput(getSprint().getBacklogItems());
		    }
		}

}
