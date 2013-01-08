package org.eclipse.emf.ecp.scrum.workbench;

import org.eclipse.core.commands.AbstractHandler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecp.Scrum.Sprint;

import org.eclipse.emf.ecp.scrum.workbench.editor.ScrumGraphitiEditor;
import org.eclipse.emf.ecp.scrum.workbench.editor.ScrumGraphitiInput;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;

import org.eclipse.graphiti.features.context.impl.AddContext;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.scrum.taskboard.dummy.*;
//import org.eclipse.emf.ecp.core.ECPProject;

public class ShowTaskBoard extends AbstractHandler {
	/*
	 * private Diagram diagram; private DiagramOpener opener = new
	 * DiagramOpener(); private GraphitiDiagramEditor editor = new
	 * GraphitiDiagramEditor(); private ModelElementOpener1 eOpener = new
	 * ModelElementOpener1();
	 */

	private Diagram createDiagram;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil
				.getCurrentSelection(event);

		Object selObject = selection.getFirstElement();
		if (!EObject.class.isInstance(selObject))
			return null;

		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain
				.getEditingDomainFor((EObject) selObject);
		

		ResourceSet resourceSet = editingDomain.getResourceSet();
		final Sprint sprint = (Sprint) selObject;
		//create temporal resource
		final Resource resource = resourceSet.createResource(URI.createURI(
				"VIRTUAL_URI", false));

		
			createDiagram = Graphiti.getPeCreateService().createDiagram(
					"org.eclipse.scrum.taskboard.diagramType", "newDiagram",
					true);
			createDiagram.setName(sprint.getName());
			//add the diagram to the resource
			editingDomain.getCommandStack().execute(
					new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {
							resource.getContents().add(createDiagram);
						}
					});
			
			
			String providerId = GraphitiUi.getExtensionManager()
					.getDiagramTypeProviderId(createDiagram.getDiagramTypeId());
			final IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager()
					.createDiagramTypeProvider(createDiagram, providerId);
			
			//TODO this is the wrong place to do it, this is just an example

		final IGaService gaService = Graphiti.getGaService();

		
		editingDomain.getCommandStack().execute(
				new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						AddContext context = new AddContext();
						context.setTargetContainer(createDiagram);
						DummyFeatureProvider fp = new DummyFeatureProvider(dtp);
						ScrumGraphitiEditor editor = new ScrumGraphitiEditor();
						editor.executeFeature(new AddDummyFeature(fp), context);
//						fp.addIfPossible(context);
					}
				}
	);

		ScrumGraphitiInput input = new ScrumGraphitiInput(createDiagram,
				(EObject) selObject);
		try {
			// Needs IEditorInput (GraphitiDiagramEditorInput) for "openEditor"
			PlatformUI
					.getWorkbench()
					.getActiveWorkbenchWindow()
					.getActivePage()
					.openEditor(input,
							"org.eclipse.emf.ecp.scrum.graphiti.editor", true);
		} catch (PartInitException e) {
			System.out.println("Error");

		}

		

		return null;
	}

}
