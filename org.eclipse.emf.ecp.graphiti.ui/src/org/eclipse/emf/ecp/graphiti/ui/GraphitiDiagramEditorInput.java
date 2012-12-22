package org.eclipse.emf.ecp.graphiti.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class GraphitiDiagramEditorInput implements IDiagramEditorInput,IEditorInput{
	
	private Diagram eObject;
	
	public GraphitiDiagramEditorInput(EObject eObject) {
		this.eObject = (Diagram) eObject;
	}

	
	
	public Diagram getDiagram(){
		return eObject;
	}
	
	@Override
	public String getUriString() {
		return null;
	}

	@Override
	public URI getUri() {
		return null;
	}

	@Override
	public String getProviderId() {
		return GraphitiUi.getExtensionManager().getDiagramTypeProviderId(eObject.getDiagramTypeId());
	}

	@Override
	public void setProviderId(String providerId) {
		
	}

	@Override
	public void updateUri(URI newURI) {
		
	}


	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}



	@Override
	public boolean exists() {
		return false;
	}



	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}



	@Override
	public String getName() {
		return null;
	}



	@Override
	public IPersistableElement getPersistable() {
		return null;
	}



	@Override
	public String getToolTipText() {
		return null;
	}

}
