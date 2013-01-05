package org.eclipse.scrum.taskboard.dummy;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.Bugreport;
import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.Scrum.Task;
import org.eclipse.emf.ecp.Scrum.User;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.func.IProposalSupport;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.AbstractPattern;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.scrum.taskboard.DiagramTypeProvider;
import org.eclipse.scrum.taskboard.FeatureProvider;
import org.eclipse.scrum.taskboard.MyContentAdapter;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class AddDummyFeature extends AbstractAddShapeFeature{

	public AddDummyFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return true;
    }

	@Override
	public PictogramElement add(IAddContext context) {
        Diagram createDiagram = (Diagram) context.getTargetContainer();
        
        final IGaService gaService = Graphiti.getGaService();
        IPeCreateService peCreateService = Graphiti.getPeCreateService();

        //First Shape
        IColorConstant COLOR1 =
    		    new ColorConstant(209,209,209);
        
        ContainerShape shapeDiagram1 = Graphiti
				.getPeCreateService().createContainerShape(
						createDiagram, true);
		Rectangle rectOpen = gaService
				.createRectangle(shapeDiagram1);
		rectOpen.setFilled(true);
		rectOpen.setBackground(gaService.manageColor(
				createDiagram, COLOR1));
//		PropertyUtil.setEClassShape(shapeDiagram1);
		PropertyUtil.setOpenShape(shapeDiagram1);

	       // SHAPE WITH LINE
	       {
	           // create shape for line
	           Shape shape = peCreateService.createShape(shapeDiagram1, false);

	           // create and set graphics algorithm
	           Polyline polyline =
	               gaService.createPolyline(shape, new int[] { 0, 20, 300, 20 });
	           polyline.setForeground(manageColor(IColorConstant.BLACK));
	           polyline.setLineWidth(2);
	       }
		
        // SHAPE WITH TEXT
        {
            // create shape for text
            Shape shape = peCreateService.createShape(shapeDiagram1, false);
 
            // create and set text graphics algorithm
            Text text = gaService.createText(shape, "OPEN");
            text.setForeground(manageColor(IColorConstant.BLACK));
            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER );
            // vertical alignment has as default value "center"
            text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
            gaService.setLocationAndSize(text, 0, 0, 300, 20);
 
        }
		
		//Second Shape
		IColorConstant COLOR2 =
    		    new ColorConstant(252,252,252);
		ContainerShape shapeDiagram2 = Graphiti
				.getPeCreateService().createContainerShape(
						createDiagram, true);
		Rectangle rectInWork = gaService
				.createRectangle(shapeDiagram2);
		rectInWork.setFilled(true);
		rectInWork.setBackground(gaService.manageColor(
				createDiagram, COLOR2));
		PropertyUtil.setInWorkShape(shapeDiagram2);
	    // SHAPE WITH LINE
	       {
	           // create shape for line
	           Shape shape = peCreateService.createShape(shapeDiagram2, false);

	           // create and set graphics algorithm
	           Polyline polyline =
	               gaService.createPolyline(shape, new int[] { 0, 20, 300, 20 });
	           polyline.setForeground(manageColor(IColorConstant.BLACK));
	           polyline.setLineWidth(2);
	       }
		
     // SHAPE WITH TEXT
     {
         // create shape for text
         Shape shape = peCreateService.createShape(shapeDiagram2, false);

         // create and set text graphics algorithm
         Text text = gaService.createText(shape, "IN WORK");
         text.setForeground(manageColor(IColorConstant.BLACK));
         text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER );
         // vertical alignment has as default value "center"
         text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
         gaService.setLocationAndSize(text, 0, 0, 300, 20);

     }
		
     
     //Third Shape
		IColorConstant COLOR3 =
    		    new ColorConstant(245,255,250);
		

		ContainerShape shapeDiagram3 = Graphiti
				.getPeCreateService().createContainerShape(
						createDiagram, true);
		Rectangle rectFinished = gaService
				.createRectangle(shapeDiagram3);
		rectFinished.setFilled(true);
		rectFinished.setBackground(gaService.manageColor(
				createDiagram, COLOR3));
		PropertyUtil.setFinishedShape(shapeDiagram3);

	    // SHAPE WITH LINE
	       {
	           // create shape for line
	           Shape shape = peCreateService.createShape(shapeDiagram3, false);

	           // create and set graphics algorithm
	           Polyline polyline =
	               gaService.createPolyline(shape, new int[] { 0, 20, 300, 20 });
	           polyline.setForeground(manageColor(IColorConstant.BLACK));
	           polyline.setLineWidth(2);
	       }
		
     // SHAPE WITH TEXT
     {
         // create shape for text
         Shape shape = peCreateService.createShape(shapeDiagram3, false);

         // create and set text graphics algorithm
         Text text = gaService.createText(shape, "FINISHED");
         text.setForeground(manageColor(IColorConstant.BLACK));
         text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER );
         // vertical alignment has as default value "center"
         text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
         gaService.setLocationAndSize(text, 0, 0, 300, 20);

     }

		gaService.setLocationAndSize(rectOpen, 0, 0, 300, 800);
		gaService.setLocationAndSize(rectInWork, 300, 0, 300,
				800);
		gaService.setLocationAndSize(rectFinished, 600, 0, 300,
				800);
   
        layoutPictogramElement(shapeDiagram1);
        
        addBacklogItems(createDiagram, shapeDiagram1, shapeDiagram2, shapeDiagram3);
        
        return shapeDiagram1;
	}
	
	private void addBacklogItems(Diagram createDiagram,ContainerShape shapeDiagram1,
			ContainerShape shapeDiagram2, ContainerShape shapeDiagram3 ){
		IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart();
		
        ISelection sel = part.getSite().getSelectionProvider().getSelection();
        
		if (sel instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) sel;
			Sprint sprint = (Sprint)treeSelection.getFirstElement();
			
			String providerId = GraphitiUi.getExtensionManager()
					.getDiagramTypeProviderId(createDiagram.getDiagramTypeId());
			final IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager()
					.createDiagramTypeProvider(createDiagram, providerId);
			FeatureProvider fp = new FeatureProvider(dtp);
			
			int i = 0;
			int s1 = 1;
			int s2 = 1;
			int s3 = 1;
			for (BacklogItem backlogItem : sprint.getBacklogItems()){
				AddContext addContext = new AddContext();
				addContext.setNewObject(backlogItem);
				i = backlogItem.getStatus();
				switch (i % 3) {
				case 0:
					addContext.setX(10 * s1);
					addContext.setY(55 * s1);
					s1++;
					addContext.setTargetContainer(shapeDiagram1);
					fp.addIfPossible(addContext);
					break;
				case 1:
					addContext.setX(10 * s2);
					addContext.setY(55 * s2);
					s2++;
					addContext.setTargetContainer(shapeDiagram2);
					fp.addIfPossible(addContext);
					break;
				case 2:
					addContext.setX(10 * s3);
					addContext.setY(55 * s3);
					s3++;
					addContext.setTargetContainer(shapeDiagram3);
					fp.addIfPossible(addContext);
					break;
				default:
					addContext.setTargetContainer(createDiagram);
					fp.addIfPossible(addContext);
				}
			}
		}
	}
}

