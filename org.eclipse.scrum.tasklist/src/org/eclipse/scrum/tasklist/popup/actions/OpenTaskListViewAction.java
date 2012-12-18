package org.eclipse.scrum.tasklist.popup.actions;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecp.Scrum.User;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class OpenTaskListViewAction implements IObjectActionDelegate {

	private Shell shell;
	private IWorkbenchPart part;

	/**
	 * Constructor for Action1.
	 */
	public OpenTaskListViewAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
		part = targetPart;
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		// Define the TableViewer
		TaskListView viewer = new TaskListView();
		ISelection sel = part.getSite().getSelectionProvider().getSelection();
		if (sel instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) sel;
			Object firstElement = treeSelection.getFirstElement();
			if (firstElement instanceof User) {
				try {
					viewer.loadContent((User) firstElement);
				} catch (RuntimeException e){
					Status status = new Status(IStatus.ERROR, "org.eclipse.scrum.tasklist", 0,
				            e.getMessage(), null);
					ErrorDialog.openError(shell, "Error on load", "", status);
				}
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.scrum.tasklist.view");
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
