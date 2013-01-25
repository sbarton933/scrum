package org.eclipse.emf.ecp.scrum.workbench.editor;

import org.eclipse.emf.ecp.graphiti.ui.GraphitiDiagramEditor;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.scrum.taskboard.dummy.AddDummyFeature;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

public class ScrumGraphitiEditor extends GraphitiDiagramEditor {
	public static final String MY_ID = "org.eclipse.emf.ecp.scrum.graphiti.editor";
	private ScrumGraphitiInput scrumInput;

	public ScrumGraphitiEditor() {
		super();
	}

	@Override
	public void editingDomainInitialized() {
		super.editingDomainInitialized();

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		if (input instanceof ScrumGraphitiInput) {
			
			scrumInput = (ScrumGraphitiInput) input;
			((ScrumUpdateBehavior)getUpdateBehavior()).setEditingDomain((TransactionalEditingDomain) AdapterFactoryEditingDomain
						.getEditingDomainFor(scrumInput.getBusinessObject()));
			super.init(site, input);
		}

	}

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new ScrumUpdateBehavior(this);
	}

	@Override
	protected void configureGraphicalViewer() {
		// TODO Auto-generated method stub
		super.configureGraphicalViewer();
		getEditingDomain().getCommandStack().execute(
				new RecordingCommand(getEditingDomain()) {

					@Override
					protected void doExecute() {
						getDiagramTypeProvider().getFeatureProvider().link(
								getDiagramTypeProvider().getDiagram(),
								scrumInput.getBusinessObject());
					}
				});
	}
	
	@Override
	public boolean isDirty() {
		return false;
	}
	
	@Override
	public Object executeFeature(IFeature feature, IContext context) {
		
		if (feature instanceof AddDummyFeature){
			((AddDummyFeature) feature).add((AddContext)context);
		}
		return null;
	}

}
