package org.eclipse.emf.ecp.scrum.sprintplanner.action;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;


public class SprintDropListener extends ViewerDropAdapter {

  private final Viewer viewer;

  public SprintDropListener(Viewer viewer) {
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
    //Yet to implement in the viewer: viewer.addTask(data), sth like that
    return false;
  }

  @Override
  public boolean validateDrop(Object target, int operation,
      TransferData transferType) {
    return true;
    
  }

  

} 