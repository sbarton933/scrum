package org.eclipse.emf.ecp.scrum.sprintplanner.action;

import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;

public class BacklogDragListener implements DragSourceListener {

  private final TableViewer viewer;

  public BacklogDragListener(TableViewer viewer) {
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
    
    if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
      event.data = firstElement; 
    }

  }

  @Override
  public void dragStart(DragSourceEvent event) {
    System.out.println("Start Drag");
  }

} 