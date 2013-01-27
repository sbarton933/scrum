package org.eclipse.scrum.burndownchart.views;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.Scrum.Task;
import org.eclipse.emf.ecp.Scrum.User;
import org.eclipse.emf.ecp.scrum.sprinthistory.GetSprintHistory;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class OpenBurnDownChartViewAction implements IObjectActionDelegate {

	private Shell shell;
	private IWorkbenchPart part;

	/**
	 * Constructor for Action1.
	 */
	public OpenBurnDownChartViewAction() {
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
		
		
		
		ISelection sel = part.getSite().getSelectionProvider().getSelection();
		if (sel instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) sel;
			Object firstElement = treeSelection.getFirstElement();
			if (firstElement instanceof Sprint) {
				final Sprint sprint = (Sprint) firstElement;
				try {
					GetSprintHistory.getInstance().getHistory(sprint);
				} catch (AccessControlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
//	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.scrum.burndownchart.reportview");	
				
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				
				String viewIdToClose = "org.eclipse.scrum.burndownchart.reportview";
				
				IViewReference viewToClose = activePage.findViewReference(viewIdToClose);
				
				activePage.hideView(viewToClose);
						
				try {
					//String viewIdToOpen = OtherView.ID;
					activePage.showView(viewIdToClose);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
				
				IViewPart viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.scrum.burndownchart.reportview");
				
				if(viewer instanceof View)
				{
					try {										
						//((View)viewer).loadContent((User) firstElement);
						//((View)viewer).setContent();		
						
						
					} catch (RuntimeException e){
						Status status = new Status(IStatus.ERROR, "org.eclipse.scrum.tasklist", 0,
					            e.getMessage(), null);
						ErrorDialog.openError(shell, "Error on load", "", status);
					}
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
