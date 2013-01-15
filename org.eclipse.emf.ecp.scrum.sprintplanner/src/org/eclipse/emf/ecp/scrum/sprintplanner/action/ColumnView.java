package org.eclipse.emf.ecp.scrum.sprintplanner.action;

import java.util.HashMap;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;

public class ColumnView {
	HashMap<String, String> tableColumnDirection = null;
	
	private TableViewer viewer;
	
	public void setTableViewer(TableViewer viewer){
		this.viewer = viewer;
	}
	
	private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		
	    TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);	    
	    viewerColumn.setLabelProvider(new ColumnLabelProvider() {
		      
		      
	    });
	    final TableColumn column = viewerColumn.getColumn();
	    column.setText(title);
	    column.setWidth(bound);
	    column.setResizable(true);
	    column.setMoveable(true);
	    column.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				
			}
		});	
	    return viewerColumn;
	}
	
	public void createTableViewerColumns(final Composite parent, final TableViewer viewer, final AdapterFactory adapterFactory)
	{
		String[] titles = { "Name", "Priority", "Story Point", "Status" };
	    int[] bounds = { 150, 50, 70, 70 };
		
	    if(tableColumnDirection == null)
	    {
	    	tableColumnDirection = new HashMap<String, String>();
	    	tableColumnDirection.put("Name", "asc"); 
	    	tableColumnDirection.put("Priority", "asc"); 
	    	tableColumnDirection.put("Story Point", "asc");
	    	tableColumnDirection.put("Status", "asc");
	    }
	    
	    setTableViewer(viewer);
	    createTableViewerColumn(titles[0], bounds[0], 0); 
	    createTableViewerColumn(titles[1], bounds[1], 1);
	    createTableViewerColumn(titles[2], bounds[2], 2);
	    createTableViewerColumn(titles[3], bounds[3], 3);
	    	    
        //viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {  	    
	    viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {
	    @Override
  	      public String getColumnText(Object element, int columnIndex) {
    	  	BacklogItem t = (BacklogItem) element;
    	  	String result = "";
    	  
  	    	switch(columnIndex){
				case 0:
					result = t.getName();
					break;
				case 1:
					result = Integer.toString(t.getPriority());
					break;

				case 2:
					result = Integer.toString(t.getStoryPoints());
					break;
				case 3:
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
	    
	    });
}
}
