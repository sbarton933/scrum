package org.eclipse.emf.ecp.scrum.sprinthistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.ModelElementQuery;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.Versions;
import org.eclipse.emf.emfstore.server.model.versioning.util.HistoryQueryBuilder;

public class GetSprintHistory {

	public PrimaryVersionSpec[] versions = { Versions.createPRIMARY("trunk", 0) };

	private List<HistoryInfo> historyInfo;
	private Usersession usersession;

	public static List<Integer> dataSetForBurnDownChart;
	
	public static ArrayList<SprintStoryPoints> tempSprintStoryPoints;
	
	public SprintStoryPoints sprintStoryPoints;
	
	public static GetSprintHistory instance;


	public GetSprintHistory() {
		
		
		
	}
	
	public static GetSprintHistory getInstance()
	{
		if(instance == null)
		{
			instance= new GetSprintHistory();
			
			dataSetForBurnDownChart = new ArrayList<Integer>();
			
			tempSprintStoryPoints= new ArrayList<SprintStoryPoints>();
			
		}else
		{
			return instance;
		}
		return null;
		
	}

	
	
	/**
	 * @param element
	 */
	/**
	 * @param element
	 * @throws EmfStoreException
	 * @throws AccessControlException
	 */
	public void getHistory(EObject element) throws AccessControlException,
			EmfStoreException {
		
		ProjectSpace ps = WorkspaceManager.getProjectSpace(element);
		ModelElementId id = ps.getProject().getModelElementId(element);
		usersession = ps.getUsersession();
		ModelElementQuery query = HistoryQueryBuilder.modelelementQuery(
				versions[0], id, 20, 0, true, true);

		// HistoryQuery query1 = getQuery(1);
		// query=HistoryQueryBuilder.
		try {
			historyInfo = ps.getHistoryInfo(query);

		} catch (EmfStoreException e) {

			e.printStackTrace();
		}

		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		versionSpec.setIdentifier(0);
		List<ChangePackage> changes = ps.getChanges(ps.getBaseVersion(),
				versionSpec);

		Project originalProject = ModelUtil.clone(ps.getProject());

		for (ChangePackage changePackage : changes) {

			//EObject copyChangePackage = ModelUtil.clone(changePackage);

			ChangePackage change = changePackage.reverse();

			change.apply(ps.getProject());
			Sprint sprint1 = null;

			for (ModelElementId elementId : change
					.getAllInvolvedModelElements()) {

				EObject element1 = ps.getProject().getModelElement(elementId);
				
				//object creation
				sprintStoryPoints= new SprintStoryPoints();

				if (element1 instanceof Sprint) {
					
					Sprint sprint = (Sprint) element1;

				//	dataSetForBurnDownChart.add(sprint.getTotalStoryPoints());
					
					tempSprintStoryPoints.add(sprintStoryPoints.setSprintStoryPoints(sprint.getTotalStoryPoints(), changePackage.getLogMessage().getDate()));
					System.out.println(sprint.getTotalStoryPoints());
				}

				else if (element1.eContainer() instanceof Sprint) {
					
					sprint1 = (Sprint) element1.eContainer();

				//	dataSetForBurnDownChart.add(sprint1.getTotalStoryPoints());

					tempSprintStoryPoints.add(sprintStoryPoints.setSprintStoryPoints(sprint1.getTotalStoryPoints(), changePackage.getLogMessage().getDate()));
					//System.out.println(sprint1.getTotalStoryPoints());
					break; // break is required so that sprint story points are calculated only once
				}
				ps.getLocalChangePackage().reverse().apply(ps.getProject());

			}
			change.apply(originalProject);

			// ps.getLocalChangePackage().reverse().apply(ps.getProject());

		}
		
		
		//sorts the collection of story points at the end of function execution.
		Collections.sort(tempSprintStoryPoints,new Comparator<SprintStoryPoints> (){

			@Override
			public int compare(SprintStoryPoints arg0, SprintStoryPoints arg1) {
				return arg0.getDateEnteredForSprint().compareTo(arg1.getDateEnteredForSprint());
				
				
			}
	
		});

		
	}

	/*
	 * interface to get dataset for burn down chart
	 */

	public List<SprintStoryPoints> getDataSetForBurnDownChart() {
		return tempSprintStoryPoints;
	}

	

}
