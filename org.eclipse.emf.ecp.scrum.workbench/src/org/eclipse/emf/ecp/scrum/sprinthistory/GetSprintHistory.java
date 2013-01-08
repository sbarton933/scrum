package org.eclipse.emf.ecp.scrum.sprinthistory;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.ModelElementQuery;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.Versions;
import org.eclipse.emf.emfstore.server.model.versioning.util.HistoryQueryBuilder;

public class GetSprintHistory {

	public PrimaryVersionSpec[] versions = { Versions.createPRIMARY("trunk", 0)};

	private List<HistoryInfo> historyInfo;
	private Usersession usersession;

	public  GetSprintHistory()
	{

	}

	/**
	 * @param element
	 */
	/**
	 * @param element
	 * @throws EmfStoreException 
	 * @throws AccessControlException 
	 */
	public void getHistory(EObject element) throws AccessControlException, EmfStoreException
	{
		// EObject element = ScrumPackage.eINSTANCE.getSprint();
		ProjectSpace ps= 	WorkspaceManager.getProjectSpace(element);
		ModelElementId id = ps.getProject().getModelElementId(element);
		usersession = ps.getUsersession();
		ModelElementQuery query=HistoryQueryBuilder.modelelementQuery(versions[0], id, 10, 10, true, true);
		try {
			historyInfo =ps.getHistoryInfo(query);

		} catch (EmfStoreException e) {

			e.printStackTrace();
		}
		
		for (HistoryInfo info : historyInfo) {
			
			PrimaryVersionSpec sourceversion = (PrimaryVersionSpec)ModelUtil.clone(info.getPrimerySpec());
		//ProjectSpace	projectspace= WorkspaceManager.getInstance().getCurrentWorkspace().;
			
			
			//ChangePackage changePackage = info.getChangePackage();
			
			//changePackage.reverse();
			//changePackage.apply(ps.getProject());
//			clone the project
//			roll the project back to the first day
//			get the storypoints
//			roll the project to the next day
//			loop
//			ps.get
//			changePackage.apply(arg0)
		//	Changes change=		ps.getChanges(arg0, arg1);
			ChangePackage localChangePackage = ps.getLocalChangePackage();

			//ChangePackage localChangePackage = ps.getc();
			for (ModelElementId elementId : localChangePackage.getAllInvolvedModelElements()) {
				EObject element1 = ps.getProject().getModelElement(elementId);
				
				//Sprint sprint = (Sprint)element1;
				if(element1 instanceof Sprint)
				{
					Sprint sprint = (Sprint)element1;
					System.out.println(sprint.getPlannedStoryPoints());
				}

			}
			
			
			
			sourceversion.setIdentifier(sourceversion.getIdentifier()-1);
			//ps.getBaseVersion();
	//		List<ChangePackage> changes= ps.getChanges(sourceversion, info.getPrimerySpec());
			
			
			
			Date date= info.getLogMessage().getDate();
//			info.getChangePackage().getVersionProperties().get(0).getName();
		//	ChangePackage changePackage1= changes.get(0);
			
			localChangePackage.reverse();
		//	changePackage1.apply(ps.getProject(),true);
			localChangePackage.apply(ps.getProject());
			//ps.getLocalChangePackage().reverse().apply(ps.getProject());

			
			
		}
		//iterator for the history info list
		
		
		//Iterator<HistoryInfo> iter = historyInfo.iterator();

		//while (iter.hasNext()) {
			
			
		//}
	}








}
