package org.eclipse.emf.ecp.scrum.workbench;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.UIPlugin;

public class ShowTaskBoard extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		@SuppressWarnings("unused")
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		
		//A few standard message dialogs
		MessageDialog.openConfirm(UIPlugin.getDefault().getWorkbench().getDisplay().getActiveShell(), "Confirm", "Please confirm");
		


		return null;
	}

	

}
