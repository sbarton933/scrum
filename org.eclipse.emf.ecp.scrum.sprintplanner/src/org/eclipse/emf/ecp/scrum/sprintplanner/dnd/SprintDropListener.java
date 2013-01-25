package org.eclipse.emf.ecp.scrum.sprintplanner.dnd;

import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.scrum.sprintplanner.view.SprintPlannerView;
import org.eclipse.emf.ecp.scrum.sprintplanner.view.SprintViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public class SprintDropListener extends ViewerDropAdapter {


  private final TableViewer viewer;
//  private final SprintViewer sv;

  public SprintDropListener(TableViewer viewer) {
    super(viewer);
    this.viewer = viewer;
  }

  @Override
  public void drop(DropTargetEvent event) {
    super.drop(event);
  }

  // This method performs the actual drop
  @Override
  public boolean performDrop(Object data) {
		if (data instanceof BacklogItem){
			BacklogItem backlog = ((BacklogItem) data);
			Sprint sprint = getSprint();
			int h = sprint.getTotalStoryPoints() + backlog.getStoryPoints();
			if (h <= sprint.getPlannedStoryPoints()){
				viewer.add(backlog);
				sprint.getBacklogItems().add(backlog);
			} else {
//				viewer.getTable().get
			}
			return true;
			
		}
		return false;
  }

  @Override
  public boolean validateDrop(Object target, int operation,
      TransferData transferType) {
    return true;
    
  }
  
  private Sprint getSprint(){
	  IViewPart viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView");
	  if (viewer instanceof SprintPlannerView){
		  return ((SprintPlannerView) viewer).getSprint();
	  }
	  return null;
  }
    

} 