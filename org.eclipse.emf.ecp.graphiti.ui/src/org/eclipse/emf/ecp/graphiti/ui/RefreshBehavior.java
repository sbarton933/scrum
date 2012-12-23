package org.eclipse.emf.ecp.graphiti.ui;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class RefreshBehavior extends DefaultRefreshBehavior {

	public RefreshBehavior(DiagramEditor diagramEditor) {
		super(diagramEditor);
	}

}
