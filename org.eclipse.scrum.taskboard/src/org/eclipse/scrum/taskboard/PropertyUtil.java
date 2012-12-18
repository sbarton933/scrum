package org.eclipse.scrum.taskboard;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil {
	 

    public static final String SHAPE_KEY = "shape-id";

 

    public static final String SHAPE_VALUE_E_CLASS = "e-class";

 

    public static final void setEClassShape(PictogramElement pe) {

        Graphiti.getPeService().setPropertyValue(pe, SHAPE_KEY,
            SHAPE_VALUE_E_CLASS);

    }

 

    public static boolean isEClassShape(PictogramElement pe) {

        return SHAPE_VALUE_E_CLASS.equals(Graphiti.getPeService()
           .getPropertyValue(pe, SHAPE_KEY));

    }

}