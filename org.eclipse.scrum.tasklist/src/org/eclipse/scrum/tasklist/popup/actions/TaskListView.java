package org.eclipse.scrum.tasklist.popup.actions;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecp.Scrum.User;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;


public class TaskListView extends ViewPart {
	public static final String ID = "org.eclipse.scrum.tasklist.view";
	
	private TableViewer viewer;
	private User user;
	
	private AdapterFactoryContentProvider adapterFactoryContentProvider;
	private ComposedAdapterFactory composedAdapterFactory;
	
	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(2, false);
	    parent.setLayout(layout);
	    createViewer(parent);
	}

	private void createViewer(Composite parent) {
	    viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    //createColumns(parent, viewer);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    adapterFactoryContentProvider = new AdapterFactoryContentProvider(
				getAdapterFactory());
	    viewer.setContentProvider(adapterFactoryContentProvider);
	    viewer.setInput(getUser());

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
	
	protected AdapterFactory getAdapterFactory() {
		if (composedAdapterFactory == null) {
			composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return composedAdapterFactory;
	}

	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
		
	}

	public void loadContent(User user) {
		//AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(
				//getAdapterFactory(), new BasicCommandStack());
		//resource = editingDomain.createResource(user.getFullPath().toString());
		//resource.load(null);
		//EObject eObject = resource.getContents().get(0);
		setUser(user);
		
	}

	private void setUser(User user) {
		this.user = user;
	}
	
	private User getUser(){
		return this.user;
	}



}
