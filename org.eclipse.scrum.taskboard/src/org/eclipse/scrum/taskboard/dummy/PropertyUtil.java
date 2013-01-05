package org.eclipse.scrum.taskboard.dummy;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil {
	
	public static final String SHAPE_KEY = "shape-id";
	 
	public static final String SHAPE_VALUE_FINISHED = "finished";

	private static final String SHAPE_VALUE_INWORK = "in_work";
	
	private static final String SHAPE_VALUE_OPEN = "open";
 
    public static final void setFinishedShape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, SHAPE_KEY,
            SHAPE_VALUE_FINISHED);
    }
    
    public static final void setOpenShape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, SHAPE_KEY,
            SHAPE_VALUE_OPEN);
    }
    
    public static final void setInWorkShape(PictogramElement pe) {
        Graphiti.getPeService().setPropertyValue(pe, SHAPE_KEY,
            SHAPE_VALUE_INWORK);
    }
 
    public static boolean isFinishedShape(PictogramElement pe) {
        return SHAPE_VALUE_FINISHED.equals(Graphiti.getPeService()
           .getPropertyValue(pe, SHAPE_KEY));
    }
    
    public static boolean isInWorkShape(PictogramElement pe){
    	return SHAPE_VALUE_INWORK.equals(Graphiti.getPeService()
    	           .getPropertyValue(pe, SHAPE_KEY));
    }
    
    public static boolean isOpenShape(PictogramElement pe){
    	return SHAPE_VALUE_OPEN.equals(Graphiti.getPeService()
    	           .getPropertyValue(pe, SHAPE_KEY));
    }
    
    
}