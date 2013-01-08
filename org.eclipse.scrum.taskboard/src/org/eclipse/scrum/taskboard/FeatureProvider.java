package org.eclipse.scrum.taskboard;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;



public class FeatureProvider extends DefaultFeatureProviderWithPatterns {

	   public FeatureProvider(IDiagramTypeProvider dtp) {
	      super(dtp);
	      addPattern(new SuperPattern());
	   }
    
}
