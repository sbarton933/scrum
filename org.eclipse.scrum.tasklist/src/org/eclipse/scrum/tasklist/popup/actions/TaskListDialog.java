package org.eclipse.scrum.tasklist.popup.actions;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.Shell;


public class TaskListDialog extends AbstractDialog {

	private Resource resource;
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	private AdapterFactoryContentProvider adapterFactoryContentProvider;

	/*@Override
	protected void loadContent(IFile file) throws IOException {
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(
				getAdapterFactory(), new BasicCommandStack());
		resource = editingDomain.createResource(file.getFullPath().toString());
		resource.load(null);
		EObject eObject = resource.getContents().get(0);
		setTournament((Tournament) eObject);
	}*/

	@Override
	protected void save() throws IOException {
		resource.save(null);
	}

	/*@Override
	protected void initializeListener() {
		numberofMatchupListener = new NumberofMatchupListener();
		getTournament().eAdapters().add(numberofMatchupListener);
	}*/

	/*private final class NumberofMatchupListener extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature().equals(
					BowlingPackage.eINSTANCE.getTournament_Matchups())) {
				updateNumberOfMatchups();
			}
			super.notifyChanged(msg);
		}
	}*/
	
	/*@Override
	protected void initializeTreeviewer(TreeViewer treeViewer) {
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				getAdapterFactory());
		treeViewer.setLabelProvider(adapterFactoryLabelProvider);
		adapterFactoryContentProvider = new AdapterFactoryContentProvider(
				getAdapterFactory());
		treeViewer.setContentProvider(adapterFactoryContentProvider);
		treeViewer.setInput(getTournament());
	}*/

	@Override
	public boolean close() {
		//adapterFactoryLabelProvider.dispose();
		//adapterFactoryContentProvider.dispose();
		return super.close();
	}

	protected TaskListDialog(Shell parentShell) {
		super(parentShell);
	}

}
