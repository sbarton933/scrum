package org.eclipse.scrum.taskboard.dummy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateDummyFeature extends AbstractCreateFeature{

	public CreateDummyFeature(IFeatureProvider fp) {
        super(fp, "Dummy", "Create Dummy");
	}

	//private static final String TITLE = "Create Bugreport";
	 
    //private static final String USER_QUESTION = "Enter new bugreport name";
    
	@Override
	public boolean canCreate(ICreateContext context) {
        return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		// ask user for EClass name
        //String newClassName = ExampleUtil.askString(TITLE, USER_QUESTION, "");
        //if (newClassName == null || newClassName.trim().length() == 0) {
        //    return EMPTY;
        //}
        //String newClassSP = ExampleUtil.askString(STORY_POINTS, USER_QUESTION2, "");
		// create EClass
        EClass newClass = EcoreFactory.eINSTANCE.createEClass();

        
        // Add model element to resource.
        // We add the model element to the resource of the diagram for
        // simplicity's sake. Normally, a customer would use its own
        // model persistence layer for storing the business model separately.
        getDiagram().eResource().getContents().add(newClass);
        
        //newClass.setName(newClassName);
        //newClass.setStoryPoints(2);
        // do the add
        addGraphicalRepresentation(context, newClass);
       
        // return newly created business object(s)
        return new Object[] { newClass };
    }
}
