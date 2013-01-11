package org.eclipse.emf.ecp.scrum.workbench;

import java.security.AccessControlException;

import javax.swing.text.View;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.scrum.sprinthistory.GetSprintHistory;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class ShowStoryPointsHistory extends AbstractHandler {

	GetSprintHistory sprintHistory;

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil
				.getCurrentSelection(event);


/*

		Object selObject = selection.getFirstElement();

		if (!EObject.class.isInstance(selObject))
			return null;
		
		
		final Sprint sprint = (Sprint) selObject;


		
				
				 sprintHistory= new GetSprintHistory();
				 try {
					sprintHistory.getHistory(sprint);
				} catch (AccessControlException e) {
					
					e.printStackTrace();
				} catch (EmfStoreException e) {
					
					e.printStackTrace();
				}
		*/
		Object selObject = selection.getFirstElement();

		if (!EObject.class.isInstance(selObject))
			return null;
		
		
		final Sprint sprint = (Sprint) selObject;


		
				
				 sprintHistory= new GetSprintHistory();
				 
				 
				 
				 try {
					sprintHistory.getHistory(sprint);
					
					
					
					/* shakti code
					 * 
					 */
					
					
					try {
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.scrum.tasklist.reportview");			
						
						//viewer
					
					} catch (PartInitException e) {
						e.printStackTrace();
					}
					
					IViewPart viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.scrum.tasklist.reportview");
					
					if(viewer instanceof View)
					{
						try {										
							//((View)viewer).loadContent((User) firstElement);
							//((View)viewer).setContent();						
							
						} catch (RuntimeException e){
							Status status = new Status(IStatus.ERROR, "org.eclipse.scrum.tasklist", 0,
						            e.getMessage(), null);
							ErrorDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Error on load", "", status);
						}
					}
					
				} catch (AccessControlException e) {
					
					e.printStackTrace();
				} catch (EmfStoreException e) {
					
					e.printStackTrace();
				}
		

		
	
		return null;
	}





}
