package org.eclipse.scrum.tasklist.popup.actions;

import org.eclipse.emf.ecp.Scrum.Task;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.scrum.tasklist.Activator;
import org.eclipse.scrum.tasklist.model.ModelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;


public class TaskListView extends ViewPart {
	public static final String ID = "org.eclipse.scrum.tasklist.view";
	
	private TableViewer viewer;
    // We use icons
	
	@Override
	public void createPartControl(Composite parent) {
		//GridLayout layout = new GridLayout(2, false);
	    //parent.setLayout(layout);
	    //createViewer(parent);
		
		GridLayout layout = new GridLayout(2, false);
	    parent.setLayout(layout);
	    //Label searchLabel = new Label(parent, SWT.NONE);
	    //searchLabel.setText("Search: ");
	    //final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
	    //searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
	    createViewer(parent);
	}

	private void createViewer(Composite parent) {
	    /*viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    //createColumns(parent, viewer);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewer.setContentProvider(new ArrayContentProvider());
	    // Get the content for the viewer, setInput will call getElements in the
	    // contentProvider
	    //viewer.setInput(ModelProvider.INSTANCE.getPersons());
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
	    viewer.getControl().setLayoutData(gridData);*/
		
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    createColumns(parent, viewer);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewer.setContentProvider(new ArrayContentProvider());
	    // Get the content for the viewer, setInput will call getElements in the
	    // contentProvider
	    viewer.setInput(ModelProvider.INSTANCE.getTasks());
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

	  // This will create the columns for the table
	  private void createColumns(final Composite parent, final TableViewer viewer) {
	    String[] titles = { "ID", "Name", "Description", "Priority" };
	    int[] bounds = { 100, 100, 100, 100 };

	    // First column is for the ID
	    TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  Task t = (Task) element;
	    	  return Integer.toString(t.getID());
	      }
	    });

	    // Second column is for the Name
	    col = createTableViewerColumn(titles[1], bounds[1], 1);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  Task t = (Task) element;
	    	  return t.getName();
	      }
	    });

	    // Now the Description
	    col = createTableViewerColumn(titles[2], bounds[2], 2);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  Task t = (Task) element;
	    	  return t.getDescription();
	      }
	    });

	    // // Now the Priority
	    col = createTableViewerColumn(titles[3], bounds[3], 3);
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	  Task t = (Task) element;
	    	  return Integer.toString(t.getPriority());
	      }
	      
	      /*
	      @Override
	      public Image getImage(Object element) {
	        if (((Task) element).getPriority() == 1) {
	          return CHECKED;
	        } else {
	          return UNCHECKED;
	        }
	      }
	      */
	      
	    });

	  }

	  private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
      final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
      final TableColumn column = viewerColumn.getColumn();
      column.setText(title);
      column.setWidth(bound);
      column.setResizable(true);
      column.setMoveable(true);
      return viewerColumn;
    }
	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();		
	}
}
