package org.eclipse.emf.ecp.scrum.sprintplanner.action;

import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.ui.part.IDropActionDelegate;

public class BacklogDropAction implements IDropActionDelegate {

	@Override
	public boolean run(Object source, Object target) {
//		if (target instanceof SprintPlannerView) {
//			BacklogItem transfer = BacklogItem.getInstance();
////			Gadget[] gadgets = transfer.fromByteArray((byte[])source);
////			IContainer parent = (IContainer)target;
////			for (int i = 0; i < gadgets.length; i++) {
////				writeGadgetFile(parent, gadgets[i]);
////			}
//			return true;
//		}
		 //drop was not successful so return false
		return true;
	}

}
