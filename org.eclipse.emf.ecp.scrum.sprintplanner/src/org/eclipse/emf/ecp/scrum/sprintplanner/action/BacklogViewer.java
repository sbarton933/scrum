package org.eclipse.emf.ecp.scrum.sprintplanner.action;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class BacklogViewer {
	
	SprintPlannerView sprintView;
	
	public BacklogViewer(Composite parent){
		sprintView.viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    //createColumns(parent, viewer);
//		AdapterFactory adapterFactory = getAdapterFactory();
	    //createTableViewerColumns(parent, viewer, adapterFactory);
	    final Table table = sprintView.viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	}

}
