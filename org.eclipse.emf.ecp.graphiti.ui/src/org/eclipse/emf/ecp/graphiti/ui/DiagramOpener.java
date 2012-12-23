package org.eclipse.emf.ecp.graphiti.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class DiagramOpener {

	public void open(EObject eObject){
		try {
			if(eObject instanceof Diagram){
			((Diagram) eObject).setDiagramTypeId("righttype");
			}
			//Needs IEditorInput (GraphitiDiagramEditorInput) for "openEditor"
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new GraphitiDiagramEditorInput(eObject), GraphitiDiagramEditor.ID);
			
		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
                    e.getMessage(), e.getStatus());
		}
	}

}
