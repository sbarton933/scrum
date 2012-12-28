package org.eclipse.emf.ecp.scrum.workbench.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.graphiti.ui.GraphitiDiagramEditorInput;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class ScrumGraphitiInput extends GraphitiDiagramEditorInput {

	private final EObject businessObject;

	public ScrumGraphitiInput(Diagram diagram,EObject businessObject) {
		super(diagram);
		this.businessObject = businessObject;
	}

	public EObject getBusinessObject() {
		return businessObject;
	}

}
