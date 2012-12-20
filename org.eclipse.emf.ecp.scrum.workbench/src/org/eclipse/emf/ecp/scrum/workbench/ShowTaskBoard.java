package org.eclipse.emf.ecp.scrum.workbench;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.UIPlugin;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
//import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.graphiti.ui.*;
import org.eclipse.emf.transaction.impl.TransactionChangeRecorder;

public class ShowTaskBoard extends AbstractHandler {
	/*private Diagram diagram;
	private DiagramOpener opener = new DiagramOpener();
	private GraphitiDiagramEditor editor = new GraphitiDiagramEditor();
	private ModelElementOpener1 eOpener = new ModelElementOpener1();*/

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		@SuppressWarnings("unused")
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		Diagram createDiagram = Graphiti.getPeCreateService().createDiagram("org.eclipse.scrum.taskboard.diagramType","newDiagram" , true);
		
		//GraphitiDiagramEditorInput input = new GraphitiDiagramEditorInput(diagram);
		//IEditorInput input = (IEditorInput) diagram;
		
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new GraphitiDiagramEditorInput(createDiagram), "org.eclipse.emf.ecp.graphiti.ui.editor1");
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//GraphitiDiagramEditor editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findEditor(input);
		
		
			return null;
	}

	

}
