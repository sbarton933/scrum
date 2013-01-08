package org.eclipse.emf.ecp.scrum.workbench;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.scrum.sprinthistory.GetSprintHistory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
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
		
		return null;
	}





}
