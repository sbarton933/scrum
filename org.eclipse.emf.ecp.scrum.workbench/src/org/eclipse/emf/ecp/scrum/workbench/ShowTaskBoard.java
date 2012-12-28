package org.eclipse.emf.ecp.scrum.workbench;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.scrum.workbench.editor.ScrumGraphitiInput;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
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

		if (resource.getContents().size() == 0) {
			createDiagram = Graphiti.getPeCreateService().createDiagram(
					"org.eclipse.scrum.taskboard.diagramType", "newDiagram",
					true);
			editingDomain.getCommandStack().execute(
					new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {
							resource.getContents().add(createDiagram);
						}
					});
		} else {
			createDiagram = (Diagram) resource.getContents().get(0);
		}

		String providerId = GraphitiUi.getExtensionManager()
				.getDiagramTypeProviderId(createDiagram.getDiagramTypeId());
		final IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager()
				.createDiagramTypeProvider(createDiagram, providerId);
		final IGaService gaService = Graphiti.getGaService();

		editingDomain.getCommandStack().execute(
				new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						// "open", "in work", "finished"
						ContainerShape shapeDiagram1 = Graphiti
								.getPeCreateService().createContainerShape(
										createDiagram, true);
						Rectangle rectOpen = gaService
								.createRectangle(shapeDiagram1);
						rectOpen.setFilled(true);
						rectOpen.setBackground(gaService.manageColor(
								createDiagram, IColorConstant.BLUE));

						ContainerShape shapeDiagram2 = Graphiti
								.getPeCreateService().createContainerShape(
										createDiagram, true);
						Rectangle rectInWork = gaService
								.createRectangle(shapeDiagram2);
						rectInWork.setFilled(true);
						rectInWork.setBackground(gaService.manageColor(
								createDiagram, IColorConstant.RED));

						ContainerShape shapeDiagram3 = Graphiti
								.getPeCreateService().createContainerShape(
										createDiagram, true);
						Rectangle rectFinished = gaService
								.createRectangle(shapeDiagram3);
						rectFinished.setFilled(true);
						rectFinished.setBackground(gaService.manageColor(
								createDiagram, IColorConstant.GREEN));

						gaService.setLocationAndSize(rectOpen, 0, 0, 300, 800);
						gaService.setLocationAndSize(rectInWork, 300, 0, 300,
								800);
						gaService.setLocationAndSize(rectFinished, 600, 0, 300,
								800);

						int i = 0;
						for (BacklogItem backlogItem : sprint.getBacklogItems()) {
							AddContext addContext = new AddContext();
							addContext.setNewObject(backlogItem);
							switch (i % 3) {
							case 0:
								addContext.setTargetContainer(shapeDiagram1);
								break;
							case 1:
								addContext.setTargetContainer(shapeDiagram2);
								break;
							case 2:
								addContext.setTargetContainer(shapeDiagram3);
								break;
							default:
								addContext.setTargetContainer(createDiagram);
							}
							addContext.setX(10 * i);
							addContext.setY(10 * i);
							i++;
							dtp.getFeatureProvider().addIfPossible(addContext);
						}
					}
				});

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
