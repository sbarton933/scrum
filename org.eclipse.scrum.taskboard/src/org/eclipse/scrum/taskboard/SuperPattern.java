package org.eclipse.scrum.taskboard;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.Bugreport;
import org.eclipse.emf.ecp.Scrum.Status;
import org.eclipse.emf.ecp.Scrum.Task;
import org.eclipse.emf.ecp.Scrum.UserStory;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.scrum.taskboard.dummy.PropertyUtil;

public class SuperPattern extends AbstractPattern implements IPattern {
	
    private static final int MIN_HEIGHT = 30;
    
    private static final int MIN_WIDTH = 50;
    
	private static final IColorConstant TASK_FOREGROUND =
		    new ColorConstant(98, 131, 167);

	private static final IColorConstant TASK_BACKGROUND =
		    new ColorConstant(187, 218, 247);
		
	private static final IColorConstant BUGREPORT_FOREGROUND =
			new ColorConstant(84,139,84);

	private static final IColorConstant BUGREPORT_BACKGROUND =
			new ColorConstant(152,251,152);
	
	private static final IColorConstant USERSTORY_FOREGROUND =
		    new ColorConstant(205,190,112);

	private static final IColorConstant USERSTORY_BACKGROUND =
		    new ColorConstant(238,221,130);
	
	private static final IColorConstant E_CLASS_TEXT_FOREGROUND =
		    IColorConstant.BLACK;
	
	
	/**
	 * Creates a new SuperPattern.
	 */
	public SuperPattern(){
		super(null);
	}
	
	/**
	 * Checks if the passed object is an instance of the domain object for the pattern.
	 */
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
	    return mainBusinessObject instanceof BacklogItem;
	}

    protected boolean isPatternControlled(PictogramElement pictogramElement) {
    	Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
    	return isMainBusinessObjectApplicable(domainObject);
   }

   protected boolean isPatternRoot(PictogramElement pictogramElement) {
	   Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	   return isMainBusinessObjectApplicable(domainObject);
   }
   
	/**
	 * Checks if the object can be added.
	 */
   @Override
	public boolean canAdd(IAddContext context) {
      if (context.getNewObject() instanceof Bugreport) {
          return true;
      }
      if (context.getNewObject() instanceof Task){
    	  return true;
      }
      if (context.getNewObject() instanceof UserStory){
    	  return true;
      }
      return false;
  }
   
	/**
	 * Adds a new PictogramElement to the diagram.
	 */
   @Override
	public PictogramElement add(IAddContext context) {
	   BacklogItem addedClass = (BacklogItem) context.getNewObject();
	   
	   if (context.getNewObject() instanceof Task){
		   addedClass = (Task) addedClass;
	   }
	   if (context.getNewObject() instanceof Bugreport){
		   addedClass = (Bugreport) addedClass;
	   }
	   if (context.getNewObject() instanceof UserStory){
		   addedClass = (UserStory) addedClass;
	   }
       ContainerShape container =  context.getTargetContainer();
       
       
       addedClass.eAdapters().add(new MyContentAdapter());

    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
       IPeCreateService peCreateService = Graphiti.getPeCreateService();

       ContainerShape containerShape =

           peCreateService.createContainerShape(container, true);

    // define a default size for the shape
    final int width = context.getWidth() <= 0 ? 100: context.getWidth();
    final int height = context.getHeight() <= 0 ? 50: context.getHeight();
    IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle; // need to access it later

    {
        // create and set graphics algorithm
        roundedRectangle =
            gaService.createRoundedRectangle(containerShape, 5,5);
        if (addedClass instanceof Task){
        	roundedRectangle.setForeground(manageColor(TASK_FOREGROUND));
        	roundedRectangle.setBackground(manageColor(TASK_BACKGROUND));
        }
        if (addedClass instanceof Bugreport){
        	roundedRectangle.setForeground(manageColor(BUGREPORT_FOREGROUND));
        	roundedRectangle.setBackground(manageColor(BUGREPORT_BACKGROUND));
        }
        if (addedClass instanceof UserStory){
        	roundedRectangle.setForeground(manageColor(USERSTORY_FOREGROUND));
        	roundedRectangle.setBackground(manageColor(USERSTORY_BACKGROUND));
        }
        roundedRectangle.setLineWidth(2);
        gaService.setLocationAndSize(roundedRectangle,
            context.getX(), context.getY(), width, height);
        if (addedClass.eResource() == null) {
                 getDiagram().eResource().getContents().add(addedClass);
        }
        // create link and wire it
        link(containerShape, addedClass);
    }

    // SHAPE WITH LINE
    {
        // create shape for line
        Shape shape = peCreateService.createShape(containerShape, false);

        // create and set graphics algorithm
        Polyline polyline =
            gaService.createPolyline(shape, new int[] { 0, 20, width, 20 });
        if (addedClass instanceof Task){
        	polyline.setForeground(manageColor(TASK_FOREGROUND));
        }
        if (addedClass instanceof Bugreport){
        	polyline.setForeground(manageColor(BUGREPORT_FOREGROUND));
        }
        if (addedClass instanceof UserStory){
        	polyline.setForeground(manageColor(USERSTORY_FOREGROUND));
        }
        
        polyline.setLineWidth(2);
    }

    // SHAPE WITH TEXT
    {
        // create shape for text
        Shape shape = peCreateService.createShape(containerShape, false);

        // create and set text graphics algorithm
        Text text = gaService.createText(shape, addedClass.getName());
        text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
        text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER );
        // vertical alignment has as default value "center"
        text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
        gaService.setLocationAndSize(text, 0, 0, width, 20);

        // create link and wire it
        link(shape, addedClass);
    }
    
    // Add StoryPoints and Priority
    
    {
        // create shape for text
        Shape shape = peCreateService.createShape(containerShape, false);

        // create and set text graphics algorithm
        Text text = gaService.createText(shape, "SP: "+addedClass.getStoryPoints()
        		+"\n"+"P: "+addedClass.getPriority());
        text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
        text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER );
        // vertical alignment has as default value "center"
        text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
        gaService.setLocationAndSize(text, 0, 0, width, 70);

        // create link and wire it
        link(shape, addedClass);
    }
    
    return containerShape;
}

	/**
	 * Checks if object can be created.
	 */
   @Override
	public boolean canCreate(ICreateContext context) {
       return context.getTargetContainer() instanceof Diagram;
	}
   
	/**
	 * Checks if object can be layouted.
	 */
   @Override
   public boolean canLayout(ILayoutContext context) {
       PictogramElement pe = context.getPictogramElement();
       if (!(pe instanceof ContainerShape))
           return false;
       EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
       return businessObjects.size() == 1
              && businessObjects.get(0) instanceof Bugreport;
    }
   
	/**
	 * Gives the object a new layout.
	 */
   @Override
   public boolean layout(ILayoutContext context) {
       boolean anythingChanged = false;
       ContainerShape containerShape =
           (ContainerShape) context.getPictogramElement();
       GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();

       // height
       if (containerGa.getHeight() < MIN_HEIGHT) {
           containerGa.setHeight(MIN_HEIGHT);
           anythingChanged = true;
       }

       // width
       if (containerGa.getWidth() < MIN_WIDTH) {
           containerGa.setWidth(MIN_WIDTH);
           anythingChanged = true;
       }

       int containerWidth = containerGa.getWidth();
      
       for (Shape shape : containerShape.getChildren()){
           GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
           IGaService gaService = Graphiti.getGaService();
           IDimension size =
                gaService.calculateSize(graphicsAlgorithm);
           if (containerWidth != size.getWidth()) {
               if (graphicsAlgorithm instanceof Polyline) {
                   Polyline polyline = (Polyline) graphicsAlgorithm;
                   Point secondPoint = polyline.getPoints().get(1);
                   Point newSecondPoint =
                       gaService.createPoint(containerWidth, secondPoint.getY());
                   polyline.getPoints().set(1, newSecondPoint);
                   anythingChanged = true;
               } else {
                   gaService.setWidth(graphicsAlgorithm,
                       containerWidth);
                   anythingChanged = true;
               }
           }
       }
       return anythingChanged;
   }
   
	/**
	 * Checks if the object can be updated
	 * @return true, if linked business object is a BacklogItem
	 */
   @Override
   public boolean canUpdate(IUpdateContext context) {
       Object bo =
           getBusinessObjectForPictogramElement(context.getPictogramElement());
       return (bo instanceof BacklogItem);
   }
   
	/**
	 * Checks if an update is needed.
	 */
   @Override
   public IReason updateNeeded(IUpdateContext context) {
       // retrieve name from pictogram model
       String pictogramName = null;
       PictogramElement pictogramElement = context.getPictogramElement();
       if (pictogramElement instanceof ContainerShape) {
           ContainerShape cs = (ContainerShape) pictogramElement;
           for (Shape shape : cs.getChildren()) {
               if (shape.getGraphicsAlgorithm() instanceof Text) {
                   Text text = (Text) shape.getGraphicsAlgorithm();
                   pictogramName = text.getValue();
               }
           }
       }

       // retrieve name from business model
       String businessName = null;
       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
       if (bo instanceof BacklogItem) {
           BacklogItem eClass = (BacklogItem) bo;
           businessName = eClass.getName();
       }

       // update needed, if names are different
       boolean updateNameNeeded =
           ((pictogramName == null && businessName != null) ||
               (pictogramName != null && !pictogramName.equals(businessName)));
       if (updateNameNeeded) {
           return Reason.createTrueReason("Name is out of date");
       } else {
           return Reason.createFalseReason();
       }
   }
   
	/**
	 * Updates the object.
	 */
   @Override
   public boolean update(IUpdateContext context) {
       // retrieve name from business model
       String businessName = null;
       PictogramElement pictogramElement = context.getPictogramElement();
       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
       if (bo instanceof BacklogItem) {
           BacklogItem eClass = (BacklogItem) bo;
           businessName = eClass.getName();
       }

       // Set name in pictogram model
       if (pictogramElement instanceof ContainerShape) {
           ContainerShape cs = (ContainerShape) pictogramElement;
           for (Shape shape : cs.getChildren()) {
               if (shape.getGraphicsAlgorithm() instanceof Text) {
                   Text text = (Text) shape.getGraphicsAlgorithm();
                   text.setValue(businessName);
                   return true;
               }
           }
       }

       return false;
   }
   
	/**
	 * Checks if the object can be moved.
	 * @return always true
	 */
   @Override
	public boolean canMoveShape(IMoveShapeContext context) {
		return true;
	}
   
	/**
	 * Moves the object and updates the Status.
	 */
   @Override
   public void moveShape(IMoveShapeContext context) {
   	super.moveShape(context);
       PictogramElement pictogramElement = context.getPictogramElement();
       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
   	ContainerShape container = context.getTargetContainer();
       if (bo instanceof BacklogItem) {
           BacklogItem element = (BacklogItem) bo;
       	if (PropertyUtil.isOpenShape(container)){
       		element.setStatus(Status.OPEN);
       	}
       	if (PropertyUtil.isInWorkShape(container)){
       		element.setStatus(Status.IN_PROGRESS);
       	}
       	if (PropertyUtil.isFinishedShape(container)){
       		element.setStatus(Status.FINISHED);
       	}
       }
   	
   }


}
