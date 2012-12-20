package org.eclipse.scrum.taskboard;

import org.eclipse.emf.ecp.Scrum.Bugreport;
import org.eclipse.emf.ecp.Scrum.Task;
import org.eclipse.emf.ecp.Scrum.UserStory;


import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;
import org.eclipse.scrum.taskboard.addfeature.AddBugreportFeature;
import org.eclipse.scrum.taskboard.addfeature.AddTaskFeature;
import org.eclipse.scrum.taskboard.addfeature.AddUserStoryFeature;
import org.eclipse.scrum.taskboard.createfeature.CreateBugreportFeature;
import org.eclipse.scrum.taskboard.createfeature.CreateTaskFeature;
import org.eclipse.scrum.taskboard.createfeature.CreateUserStoryFeature;
import org.eclipse.scrum.taskboard.directediting.DirectEditingTaskFeature;
import org.eclipse.scrum.taskboard.layoutfeature.LayoutBugreportFeature;
import org.eclipse.scrum.taskboard.layoutfeature.LayoutTaskFeature;
import org.eclipse.scrum.taskboard.layoutfeature.LayoutUserStoryFeature;
import org.eclipse.scrum.updatefeature.UpdateBugreportFeature;
import org.eclipse.scrum.updatefeature.UpdateTaskFeature;
import org.eclipse.scrum.updatefeature.UpdateUserStoryFeature;

public class FeatureProvider extends DefaultFeatureProvider {
	public FeatureProvider (IDiagramTypeProvider dtp){
		super(dtp);
	}
	
    @Override
    public IAddFeature getAddFeature(IAddContext context) {
    //is object for add request a EClass?
    if (context.getNewObject() instanceof Task) {
    	return new AddTaskFeature(this);	
    }
    if (context.getNewObject() instanceof Bugreport){
    	return new AddBugreportFeature(this);
    }
    if (context.getNewObject() instanceof UserStory){
    	return new AddUserStoryFeature(this);
    }
    return super.getAddFeature(context);
    }  
    
    @Override
    public ICreateFeature[] getCreateFeatures() {
       return new ICreateFeature[] { new CreateTaskFeature(this), 
    		   new CreateBugreportFeature(this),
    		   new CreateUserStoryFeature(this)};
  
    } 
    
    @Override
    public IUpdateFeature getUpdateFeature(IUpdateContext context) {
       PictogramElement pictogramElement = context.getPictogramElement();
       if (pictogramElement instanceof ContainerShape) {
           Object bo = getBusinessObjectForPictogramElement(pictogramElement);
           if (bo instanceof Task) {
               return new UpdateTaskFeature(this);
           }
           if (bo instanceof Bugreport){
        	   return new UpdateBugreportFeature(this);
           }
           if (bo instanceof UserStory){
        	   return new UpdateUserStoryFeature(this);
           }
       }
       return super.getUpdateFeature(context);
    } 
    
    @Override
    public ILayoutFeature getLayoutFeature(ILayoutContext context) {
        PictogramElement pictogramElement = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pictogramElement);
        if (bo instanceof Bugreport) {
            return new LayoutBugreportFeature(this);
        }
        if (bo instanceof UserStory){
        	return new LayoutUserStoryFeature(this);
        }
        if (bo instanceof Task){
        	return new LayoutTaskFeature(this);
        }
        return super.getLayoutFeature(context);
    } 
    
    @Override
    public IDirectEditingFeature getDirectEditingFeature(
        IDirectEditingContext context) {
        PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        if (bo instanceof Task) {
            return new DirectEditingTaskFeature(this);
        }
        return super.getDirectEditingFeature(context);
    } 
    
}
