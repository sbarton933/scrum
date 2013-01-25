package org.eclipse.emf.ecp.scrum.sprintplanner.dnd;

import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.scrum.sprintplanner.view.SprintPlannerView;
import org.eclipse.emf.ecp.scrum.sprintplanner.view.SprintViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public class SprintDragListener implements DragSourceListener {

	  private final TableViewer viewer;

	  public SprintDragListener(TableViewer viewer) {
	    this.viewer = viewer;
	  }

	  @Override
	  public void dragFinished(DragSourceEvent event) {
	    System.out.println("Finshed Drag");
	  }

	  @Override
	  public void dragSetData(DragSourceEvent event) {
	    // Here you do the convertion to the type which is expected.
	    IStructuredSelection selection = (IStructuredSelection) viewer
	    .getSelection();
	    BacklogItem firstElement = (BacklogItem) selection.getFirstElement();
	    
	    if (BacklogItemTransfer.getInstance().isSupportedType(event.dataType)) {
	      event.data = firstElement;
	      viewer.remove(event.data);
	      Sprint sprint = getSprint();
	      sprint.getBacklogItems().remove(firstElement);
	      
	    }

	  }

	  @Override
	  public void dragStart(DragSourceEvent event) {
	    System.out.println("Start Drag");
	  }
	  
	  private Sprint getSprint(){
		  IViewPart viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView");
		  if (viewer instanceof SprintPlannerView){
			  return ((SprintPlannerView) viewer).getSprint();
		  }
		  return null;
	  }

	} 