package org.eclipse.scrum.taskboard;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.context.IAddContext;

import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.scrum.taskboard.dummy.AddDummyFeature;


public class FeatureProvider extends DefaultFeatureProviderWithPatterns {

	   public FeatureProvider(IDiagramTypeProvider dtp) {
	      super(dtp);
	      addPattern(new TaskPattern());
	      addPattern(new BugreportPattern());
	      addPattern(new UserStoryPattern());

	   }
    
}
