package org.eclipse.scrum.taskboard;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;



public class FeatureProvider extends DefaultFeatureProviderWithPatterns {

	/**
	 * Creates a new instance of {@link FeatureProvider}.
	 * Adds a new Pattern to this FeatureProvider.
	 * This is done from the DiagramTypeProvider.
	 * 
	 * @param dtp
	 *            The diagram type provider associated with this feature
	 *            provider.
	 */
	   public FeatureProvider(IDiagramTypeProvider dtp) {
	      super(dtp);
	      addPattern(new SuperPattern());
	   }
    
}
