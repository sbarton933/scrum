package org.eclipse.scrum.taskboard;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.scrum.taskboard.dummy.AddDummyFeature;
import org.eclipse.scrum.taskboard.dummy.CreateDummyFeature;

public class DiagramTypeProvider extends AbstractDiagramTypeProvider {

	   public DiagramTypeProvider() {
	      super();
	      setFeatureProvider(new FeatureProvider(this));
	   }
	}