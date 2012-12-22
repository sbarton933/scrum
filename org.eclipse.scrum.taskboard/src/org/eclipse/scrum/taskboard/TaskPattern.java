package org.eclipse.scrum.taskboard;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.emf.ecp.Scrum.Task;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
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

public class TaskPattern extends AbstractPattern implements IPattern {
	
		private static final IColorConstant E_CLASS_TEXT_FOREGROUND =
		    IColorConstant.BLACK;
		 
		private static final IColorConstant E_CLASS_FOREGROUND =
		    new ColorConstant(98, 131, 167);

		private static final IColorConstant E_CLASS_BACKGROUND =
		    new ColorConstant(187, 218, 247);
		
		private static final String TITLE = "Create Task";
		 
	    private static final String USER_QUESTION = "Enter new task name";
	    
	    private static final int MIN_HEIGHT = 30;
	    
	    private static final int MIN_WIDTH = 50;

	   public TaskPattern() {
	      super(null);
	   }

	   public String getCreateName() {
	      return "Task";
	   }

	   public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
	      return mainBusinessObject instanceof Task;
	   }

	   protected boolean isPatternControlled(PictogramElement pictogramElement) {
	      Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	      return isMainBusinessObjectApplicable(domainObject);
	   }

	   protected boolean isPatternRoot(PictogramElement pictogramElement) {
	      Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	      return isMainBusinessObjectApplicable(domainObject);
	   }
	   
		@Override
		public boolean canAdd(IAddContext context) {
			// check if user wants to add a EClass
	        if (context.getNewObject() instanceof Task) {
	            // check if user wants to add to a diagram
	            if (context.getTargetContainer() instanceof Diagram) {
	                return true;
	            }
	        }
	        return false;
	    }
		
		@Override
		public PictogramElement add(IAddContext context) {
			final Task addedClass = (Task) context.getNewObject();
	        final Diagram targetDiagram = (Diagram) context.getTargetContainer();
	        
	        
	        addedClass.eAdapters().add(new MyContentAdapter());
	 
	        // CONTAINER SHAPE WITH ROUNDED RECTANGLE
	        final IPeCreateService peCreateService = Graphiti.getPeCreateService();
	        final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
	 
	        // define a default size for the shape
	        final int width = context.getWidth() <= 0 ? 100: context.getWidth();
	        final int height = context.getHeight() <= 0 ? 50: context.getHeight();
	        IGaService gaService = Graphiti.getGaService();
	        RoundedRectangle roundedRectangle; // need to access it later
	 
	        {
	            // create and set graphics algorithm
	            roundedRectangle =
	                gaService.createRoundedRectangle(containerShape, 5,5);
	            roundedRectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
	            roundedRectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
	            roundedRectangle.setLineWidth(2);
	            gaService.setLocationAndSize(roundedRectangle,
	                context.getX(), context.getY(), width, height);
	 
	            // if added Class has no resource we add it to the resource
	            // of the diagram
	            // in a real scenario the business model would have its own resource
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
	            polyline.setForeground(manageColor(E_CLASS_FOREGROUND));
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
	        
	        return containerShape;
	    }

		@Override
		public boolean canCreate(ICreateContext context) {
	        return context.getTargetContainer() instanceof Diagram;
		}

		@Override
		public Object[] create(ICreateContext context) {
			// ask user for EClass name
	        String newClassName = ExampleUtil.askString(TITLE, USER_QUESTION, "");
	        if (newClassName == null || newClassName.trim().length() == 0) {
	            return EMPTY;
	        }
	 
			// create EClass
	        Task newClass = ScrumFactory.eINSTANCE.createTask();
	        
	        // Add model element to resource.
	        // We add the model element to the resource of the diagram for
	        // simplicity's sake. Normally, a customer would use its own
	        // model persistence layer for storing the business model separately.
	        getDiagram().eResource().getContents().add(newClass);
	        newClass.setName(newClassName);
	 
	        // do the add
	        addGraphicalRepresentation(context, newClass);
	 
	        // return newly created business object(s)
	        return new Object[] { newClass };
	    }
		
		public int getEditingType() {
		    // there are several possible editor-types supported:
		    // text-field, checkbox, color-chooser, combobox, ...
		    return TYPE_TEXT;
		}

		@Override
		public boolean canDirectEdit(IDirectEditingContext context) {
		    PictogramElement pe = context.getPictogramElement();
		    Object bo = getBusinessObjectForPictogramElement(pe);
		    GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		    // support direct editing, if it is a EClass, and the user clicked
		    // directly on the text and not somewhere else in the rectangle
		    if (bo instanceof Task && ga instanceof Text) {
		        return true;
		    }
		    // direct editing not supported in all other cases
		    return false;
		}

		public String getInitialValue(IDirectEditingContext context) {
		    // return the current name of the EClass
		    PictogramElement pe = context.getPictogramElement();
		    Task eClass = (Task) getBusinessObjectForPictogramElement(pe);
		    return eClass.getName();
		}

		@Override
		public String checkValueValid(String value, IDirectEditingContext context) {
		    if (value.length() < 1)
		        return "Please enter any text as class name.";
		    if (value.contains(" "))
		        return "Spaces are not allowed in class names.";
		    if (value.contains("\n"))
		        return "Line breakes are not allowed in class names.";

		    // null means, that the value is valid
		    return null;
		}

		public void setValue(String value, IDirectEditingContext context) {
		    // set the new name for the EClass
		    PictogramElement pe = context.getPictogramElement();
		    Task eClass = (Task) getBusinessObjectForPictogramElement(pe);
		    eClass.setName(value);

		    // Explicitly update the shape to display the new value in the diagram
		    // Note, that this might not be necessary in future versions of Graphiti
		    // (currently in discussion)

		    // we know, that pe is the Shape of the Text, so its container is the
		    // main shape of the EClass
		    updatePictogramElement(((Shape) pe).getContainer());
		}

	    public boolean canLayout(ILayoutContext context) {
	        // return true, if pictogram element is linked to an EClass
	        PictogramElement pe = context.getPictogramElement();
	        if (!(pe instanceof ContainerShape))
	            return false;
	        EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
	        return businessObjects.size() == 1
	               && businessObjects.get(0) instanceof Task;
	     }
	  
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
	     
	     public boolean canUpdate(IUpdateContext context) {
	         // return true, if linked business object is a EClass
	         Object bo =
	             getBusinessObjectForPictogramElement(context.getPictogramElement());
	         return (bo instanceof Task);
	     }
	  
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
	         if (bo instanceof Task) {
	             Task eClass = (Task) bo;
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
	  
	     public boolean update(IUpdateContext context) {
	         // retrieve name from business model
	         String businessName = null;
	         PictogramElement pictogramElement = context.getPictogramElement();
	         Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	         if (bo instanceof Task) {
	             Task eClass = (Task) bo;
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
		
	} 