package org.eclipse.emf.ecp.scrum.sprintplanner.dnd;

import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;


public class SprintDropListener extends ViewerDropAdapter {

  private final TableViewer viewer;

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
			viewer.add(backlog);
			return true;
			
		}
		return false;
  }

  @Override
  public boolean validateDrop(Object target, int operation,
      TransferData transferType) {
    return true;
    
  }

  

} 