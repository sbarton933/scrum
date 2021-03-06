package org.eclipse.emf.ecp.scrum.sprintplanner.dnd;

import org.eclipse.emf.ecp.Scrum.Backlog;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.impl.BacklogImpl;
import org.eclipse.emf.ecp.scrum.sprintplanner.view.SprintPlannerView;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;


public class BacklogDropListener extends ViewerDropAdapter {

  private final TableViewer viewer;
  private Backlog backlog;

  public BacklogDropListener(TableViewer viewer) {
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
	//perform drop of BacklogItem
	if (data instanceof BacklogItem){
		if (backlog != null){
		BacklogItem backlogitem = ((BacklogItem) data);
			viewer.add(backlogitem);
			for (int i =0; i< backlog.getBacklogItems().size(); i++){
				if (backlog.getBacklogItems().get(i).equals(backlogitem)){
					return true;
				}
			}
			this.backlog.getBacklogItems().add(backlogitem);
			return true;
		}
		return false;
	
	}
	//perform drop of Backlog
	if (data instanceof TreeSelection && backlog == null){
		TreeSelection ts = ((TreeSelection)data);
		if (ts.getFirstElement() instanceof BacklogImpl){
			Backlog backlog = ((Backlog)ts.getFirstElement());
			setBacklog(backlog);
			for(int i=0; i<backlog.getBacklogItems().size(); i++)
			{
				viewer.add(backlog.getBacklogItems().get(i));
			}
			return true;
		}
	}
    return false;
  }

  @Override
  public boolean validateDrop(Object target, int operation,
      TransferData transferType) {
	  if (LocalTransfer.getInstance().isSupportedType(transferType)){ //&& backlog != null){
		  return true;
	  }
    return false;
  }
  
  private void setBacklog(Backlog backlog){
		this.backlog = backlog;
		IViewPart viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView");
		  if (viewer instanceof SprintPlannerView){
			  ((SprintPlannerView) viewer).setBacklog(backlog);
		  }
  } 

} 