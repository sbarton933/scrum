package org.eclipse.emf.ecp.scrum.sprintplanner.view;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.Scrum.Backlog;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.scrum.sprintplanner.action.ColumnView;
import org.eclipse.emf.ecp.scrum.sprintplanner.dnd.BacklogDragListener;
import org.eclipse.emf.ecp.scrum.sprintplanner.dnd.BacklogDropListener;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

public class SprintPlannerView extends ViewPart {

	public static final String ID = "org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView";
	
	protected TableViewer viewer;
	private Sprint sprint;
	SprintPlannerView sprintView;
	SprintViewer sprintViewer;
	private ColumnView col = new ColumnView();
	private Backlog backlog;
	
	private ComposedAdapterFactory composedAdapterFactory;
	
	@Override
	public void createPartControl(Composite parent) {
		sprintView = this;
		
		FillLayout layout = new FillLayout();
	    parent.setLayout(layout);
	    
		createBacklogViewer(parent);
	    createSuperViewer(parent);

	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();	
		
	}
	
	private void createBacklogViewer(Composite parent){
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    //createColumns(parent, viewer);
		
	    int operations = DND.DROP_COPY| DND.DROP_MOVE;
	    Transfer[] transferTypes = new Transfer[]{LocalTransfer.getInstance()};
	    viewer.addDropSupport(operations, transferTypes, new BacklogDropListener(viewer));
	    viewer.addDragSupport(operations, transferTypes, new BacklogDragListener(viewer));
		
		AdapterFactory adapterFactory = getAdapterFactory();
	    col.createTableViewerColumns(parent, viewer, adapterFactory);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    
	    viewer.setContentProvider(new ArrayContentProvider());

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
	
	private void createSuperViewer(Composite parent) {		

		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL 
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

	    final Table table = viewer.getTable();

	    viewer.setContentProvider(new ArrayContentProvider());

	    sprintViewer = new SprintViewer(table, getSite());
	    sprintViewer.loadContent(getSprint());
	    sprintViewer.createPartControl(table);
	}
	
	protected AdapterFactory getAdapterFactory() {
		if (composedAdapterFactory == null) {
			composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return composedAdapterFactory;
	}
		
	EContentAdapter adapter = new EContentAdapter() {
	      public void notifyChanged(Notification notification) {
	    	  	
	    	    //notification.
	    	    try
	    	    {
			        super.notifyChanged(notification);
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
			sprintViewer.setSprintContent();
	    }
	}
	
	public Sprint getSprint(){
		return this.sprint;
	}
	
	public void loadContent(Sprint sprint) {
		setSprint(sprint);
		sprintViewer.setSprint(sprint);
	}
	
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
	public void setBacklog(Backlog backlog){
		this.backlog = backlog;
	}
	
	public Backlog getBacklog(){
		return this.backlog;
	}
}
