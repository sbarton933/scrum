package org.eclipse.scrum.tasklist.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

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
		TaskListDialog dialog = new TaskListDialog(shell);
		/*ISelection sel = part.getSite().getSelectionProvider().getSelection();
		if (sel instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) sel;
			Object firstElement = treeSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				try {
					dialog.loadContent((IFile) firstElement);
				} catch (IOException e) {
					Status status = new Status(IStatus.ERROR, "org.eclipse.example.bowling.tutorial", 0,
				            e.getMessage(), null);
					ErrorDialog.openError(shell, "Error on load", "File could not be loaded", status); 
				}
				catch (RuntimeException e){
					Status status = new Status(IStatus.ERROR, "org.eclipse.example.bowling.tutorial", 0,
				            e.getMessage(), null);
					ErrorDialog.openError(shell, "Error on load", "Probably there is no Tournament contained in the ressource", status);
				}
				dialog.open();
			}
		}*/
		dialog.open();

	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
