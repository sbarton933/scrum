package org.eclipse.scrum.tasklist.popup.actions;

import java.io.IOException;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractDialog extends Dialog {

	protected Label numberOfMatchups;

	protected AbstractDialog(Shell parentShell) {
		super(parentShell);
	}

	private ComposedAdapterFactory composedAdapterFactory;

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite root = (Composite) super.createDialogArea(parent);
		root.setLayout(new FillLayout(SWT.VERTICAL));
		Composite labelComposite = new Composite(root, SWT.None);
		labelComposite.setLayout(new GridLayout(2, false));
		Label text = new Label(labelComposite, SWT.None);
		text.setText("Number of Matchups: ");
		numberOfMatchups = new Label(labelComposite, SWT.None);
		TreeViewer treeViewer = new TreeViewer(root, SWT.SINGLE | SWT.H_SCROLL
				| SWT.V_SCROLL);
		//initializeTreeviewer(treeViewer);
		//initializeListener();
		//updateNumberOfMatchups();
		root.layout();
		parent.pack();
		return parent;
	}

	//protected abstract void initializeListener();

	//protected abstract void loadContent(IFile file) throws IOException;

	//protected abstract void initializeTreeviewer(TreeViewer treeViewer);

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
	}

	/*@Override
	protected void okPressed() {
		try {
			save();
		} catch (IOException e) {
			Status status = new Status(IStatus.ERROR,
					"org.eclipse.scrum.tasklist", 0, e.getMessage(),
					null);
			ErrorDialog.openError(this.getShell(), "Error on save",
					"Something went wrong on save", status);
		}
		super.okPressed();
	}*/

	protected abstract void save() throws IOException;


	/**
	 * Return an ComposedAdapterFactory for all registered modesl
	 * 
	 * @return a ComposedAdapterFactory
	 */
	protected AdapterFactory getAdapterFactory() {
		if (composedAdapterFactory == null) {
			composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return composedAdapterFactory;
	}

}
