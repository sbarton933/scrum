package org.eclipse.scrum.taskboard;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;

public class DiagramTypeProvider extends AbstractDiagramTypeProvider implements
		IDiagramTypeProvider {

	public DiagramTypeProvider(){
		super();
		setFeatureProvider(new FeatureProvider(this));
	}
}
