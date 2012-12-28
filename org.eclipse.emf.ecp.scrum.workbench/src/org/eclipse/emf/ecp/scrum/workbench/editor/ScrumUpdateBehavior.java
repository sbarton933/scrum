package org.eclipse.emf.ecp.scrum.workbench.editor;

import org.eclipse.emf.ecp.graphiti.ui.UpdateBehavior;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class ScrumUpdateBehavior extends UpdateBehavior {

	private TransactionalEditingDomain editingDomain;

	public ScrumUpdateBehavior(DiagramEditor diagramEditor) {
		super(diagramEditor);
	}
	@Override
	protected void createEditingDomain() {
		initializeEditingDomain(editingDomain);
	}
	
	public void setEditingDomain(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

}
