package org.eclipse.emf.ecp.scrum.sprintplanner.dnd;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.Scrum.Backlog;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.scrum.sprintplanner.view.SprintPlannerView;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

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
    final BacklogItem firstElement = (BacklogItem) selection.getFirstElement();
    
    if (LocalTransfer.getInstance().isSupportedType(event.dataType)) {
    	Object selObject = selection.getFirstElement();
		if (EObject.class.isInstance(selObject)){
		  TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain
					.getEditingDomainFor((EObject) selObject);
	      event.data = firstElement;
		  editingDomain.getCommandStack().execute(
					new ChangeCommand(firstElement) {
						
						@Override
						protected void doExecute() {
						      viewer.remove(firstElement);
						      getBacklog().getBacklogItems().remove(firstElement);
						}
					});
		}

    }

  }

  @Override
  public void dragStart(DragSourceEvent event) {
    System.out.println("Start Drag");
  }
  
  private Backlog getBacklog(){
	  IViewPart viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.emf.ecp.scrum.sprintplanner.action.SprintPlannerView");
	  if (viewer instanceof SprintPlannerView){
		  return ((SprintPlannerView) viewer).getBacklog();
	  }
	  return null;
  }

} 