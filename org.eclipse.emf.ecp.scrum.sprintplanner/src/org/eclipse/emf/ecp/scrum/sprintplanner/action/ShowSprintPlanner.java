package org.eclipse.emf.ecp.scrum.sprintplanner.action;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


public class ShowSprintPlanner implements IObjectActionDelegate {

	private Shell shell;
	private IWorkbenchPart part;
	
	public ShowSprintPlanner() {
		super();
	}
	
	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		ISelection sel = part.getSite().getSelectionProvider().getSelection();
		if (sel instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) sel;
			Object firstElement = treeSelection.getFirstElement();
			if (firstElement instanceof Sprint) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView");			
									
				} catch (PartInitException e) {
					e.printStackTrace();
				}
				
				IViewPart viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView");
								
				if(viewer instanceof SprintPlannerView)
				{
					try {										
						((SprintPlannerView)viewer).loadContent((Sprint) firstElement);
						((SprintPlannerView)viewer).setContent();
						//((SprintPlannerView)viewer).setTitleIconImage();
					} catch (RuntimeException e){
						Status status = new Status(IStatus.ERROR, "org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView", 0,
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
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
		part = targetPart;
	}

	
	

}
