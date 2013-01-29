package org.eclipse.emf.ecp.scrum.sprintplanner.dnd;

import org.eclipse.emf.ecp.Scrum.Backlog;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.scrum.sprintplanner.view.SprintPlannerView;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;


public class SprintDropListener extends ViewerDropAdapter {


  private final TableViewer viewer;
  private final TableViewer defaultViewer;

  public SprintDropListener(TableViewer viewer) {
    super(viewer);
    this.viewer = viewer;
    this.defaultViewer = null;
  }
  
  public SprintDropListener(TableViewer sprintViewer, TableViewer defaultViewer) {
    super(sprintViewer);
    this.viewer = sprintViewer;
    this.defaultViewer = defaultViewer;
  }

  @Override
  public void drop(DropTargetEvent event) {
    super.drop(event);
  }

  // This method performs the actual drop
  @Override
  public boolean performDrop(Object data) {
		if (data instanceof BacklogItem){
			final BacklogItem backlogItem = ((BacklogItem) data);
			final Sprint sprint = getSprint();
			int h = sprint.getTotalStoryPoints() + backlogItem.getStoryPoints();
			if (h <= sprint.getPlannedStoryPoints()){
				viewer.add(backlogItem);
				sprint.getBacklogItems().add(backlogItem);
			} else {
				defaultViewer.add(backlogItem);
				getBacklog().getBacklogItems().add(backlogItem);
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
  
  private Backlog getBacklog(){
	  IViewPart viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView");
	  if (viewer instanceof SprintPlannerView){
		  return ((SprintPlannerView) viewer).getBacklog();
	  }
	  return null;
	  
  }
    

} 