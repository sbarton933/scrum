package org.eclipse.scrum.taskboard.dummy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

public class DummyFeatureProvider extends DefaultFeatureProvider{
	
	   public DummyFeatureProvider(IDiagramTypeProvider dtp) {
		      super(dtp);
	   }
	   
	   @Override
	   public IAddFeature getAddFeature(IAddContext context) {
	       // is object for add request a EClass?
		   return new AddDummyFeature(this);
	   }

}
