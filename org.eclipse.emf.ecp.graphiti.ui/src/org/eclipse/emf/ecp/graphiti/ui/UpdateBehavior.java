package org.eclipse.emf.ecp.graphiti.ui;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.tools.AbstractTool.Input;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.services.GraphitiUi;

public class UpdateBehavior extends DefaultUpdateBehavior {
	
	TransactionalEditingDomain editingDomain;
	Diagram diagram;

	public UpdateBehavior(DiagramEditor diagramEditor) {
		super(diagramEditor);
	}
	
	@Override
	protected void createEditingDomain() {
		
		editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(diagram);
		initializeEditingDomain(editingDomain);
	}
	
	//domain is needed to reopen the diagram -> do not call super.
	@Override
	protected void disposeEditingDomain() {
		return;
	}
	
	public void setDiagram(Diagram diagram){
		this.diagram = diagram;
	}

}
