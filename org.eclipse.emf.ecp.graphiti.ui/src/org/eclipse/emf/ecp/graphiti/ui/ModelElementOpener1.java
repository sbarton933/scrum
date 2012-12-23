package org.eclipse.emf.ecp.graphiti.ui;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecp.core.ECPProject;

import org.eclipse.emf.ecp.ui.util.ModelElementOpener;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class ModelElementOpener1 implements ModelElementOpener {


	public ModelElementOpener1() {
	}

	@Override
	public int canOpen(EObject modelElement) {
		if (modelElement instanceof Diagram){
			return 3;
		}
		return DONOTOPEN;
	}

	@Override
	public void openModelElement(EObject modelElement, ECPProject ecpProject) {
		GraphitiDiagramEditorInput input = new GraphitiDiagramEditorInput(modelElement);  
		try {
			  //Needs IEditorInput (GraphitiDiagramEditorInput) for "openEditor"
		  PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
		    .openEditor(input, "org.eclipse.emf.ecp.graphiti.ui.editor1", true);
		  } catch (PartInitException e) {
			  System.out.println("Error");
			  
		  }
	}
}
