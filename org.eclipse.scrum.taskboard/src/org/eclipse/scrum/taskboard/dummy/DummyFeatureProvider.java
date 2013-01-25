package org.eclipse.scrum.taskboard.dummy;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

public class DummyFeatureProvider extends DefaultFeatureProvider{
	
	/**
	 * Creates a new instance of {@link DummyFeatureProvider}.
	 * 
	 * @param dtp
	 *            The diagram type provider associated with this feature
	 *            provider.
	 */
	   public DummyFeatureProvider(IDiagramTypeProvider dtp) {
		      super(dtp);
	   }
	   
		/**
		 * Provides the class {@link AddDummyFeature}.
		 */
	   @Override
	   public IAddFeature getAddFeature(IAddContext context) {
		   return new AddDummyFeature(this);
	   }

}
