package org.eclipse.scrum.taskboard;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class DiagramTypeProvider extends AbstractDiagramTypeProvider {

	/**
	 * Creates a new DiagramTypeProvider.
	 * Sets the FeatureProvider of the TypeProvider.
	 */
	   public DiagramTypeProvider() {
	      super();
	      setFeatureProvider(new FeatureProvider(this));
	   }
	}