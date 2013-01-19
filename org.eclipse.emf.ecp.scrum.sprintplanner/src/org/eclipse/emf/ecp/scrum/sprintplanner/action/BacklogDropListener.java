package org.eclipse.emf.ecp.scrum.sprintplanner.action;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.Scrum.Backlog;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.impl.SprintImpl;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.part.EditorInputTransfer;


public class BacklogDropListener extends ViewerDropAdapter {

  private final TableViewer viewer;

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
    //call method to get BacklogItems from specific Backlog
	if (data instanceof BacklogItem){
		BacklogItem backlog = ((BacklogItem) data);
		viewer.add(backlog);
		return true;
		
	}
//	if (data instanceof Backlog){
//		Backlog backlog = ((Backlog) data);
//		for(int i=0; i<backlog.getBacklogItems().size(); i++)
//		{
////			backlog.getBacklogItems().get(i).eAdapters().add(adapter);
//			viewer.setInput(backlog);
//		}
//	}
    return false;
  }

  @Override
  public boolean validateDrop(Object target, int operation,
      TransferData transferType) {
    return BacklogItemTransfer.getInstance().isSupportedType(transferType);
    
  }

  

} 