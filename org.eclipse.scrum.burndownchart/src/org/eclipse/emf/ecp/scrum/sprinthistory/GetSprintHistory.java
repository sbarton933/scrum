package org.eclipse.emf.ecp.scrum.sprinthistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
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

	public static GetSprintHistory getInstance() {
		if (instance == null) {
			instance = new GetSprintHistory();
		}

		return instance;
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

		Project clonedProjects = ModelUtil.clone(ps.getProject());

		// reseting list everytime execute function calls to populate burn down
		// chart
		dataSetForBurnDownChart = new ArrayList<Integer>();

		tempSprintStoryPoints = new ArrayList<SprintStoryPoints>();

		for (ChangePackage changePackage : changes) {


			ChangePackage change = changePackage.reverse();


			change.apply(clonedProjects);
			
			Sprint sprint1 = null;

			sprintStoryPoints = new SprintStoryPoints();
			Sprint sprint = null;

			for (ModelElementId elementId : change
					.getAllInvolvedModelElements()) {

				EObject element1 = clonedProjects.getModelElement(elementId);

				// object creation
				if (element1 != null) {

					if (element1 instanceof Sprint) {

						sprint = (Sprint) element1;
						SprintStoryPoints sprintStoryPoints1 = new SprintStoryPoints();

						if (sprint.equals(sprint1)) {
							continue;
						}

						System.out.println(sprint.getTotalStoryPoints());

						tempSprintStoryPoints
						.add(sprintStoryPoints1.setSprintStoryPoints(
								sprint.getTotalStoryPoints(),
								changePackage.getLogMessage().getDate()));
						break;
					}

					else if (element1.eContainer() instanceof Sprint) {

						sprint1 = (Sprint) element1.eContainer();

						EList<BacklogItem> sprintItems = sprint1
								.getBacklogItems();

						int storypoints = sprint1.getTotalStoryPoints();
						int finalstroypoints = 0;
						int m = storypoints;
						for (BacklogItem backlogItem : sprintItems) {

							finalstroypoints = sprint1.getTotalStoryPoints();

							if (backlogItem.getStatus().getName()
									.equalsIgnoreCase("finished")) {

								finalstroypoints = m
										- backlogItem.getStoryPoints();
								
								m = finalstroypoints;

							

							}

						}

						tempSprintStoryPoints.add(sprintStoryPoints
								.setSprintStoryPoints(m, changePackage
										.getLogMessage().getDate()));

						continue;
					}

				}
			}

		}

		// sorts the collection of story points at the end of function
		// execution.
		Collections.sort(tempSprintStoryPoints,
				new Comparator<SprintStoryPoints>() {

			@Override
			public int compare(SprintStoryPoints arg0,
					SprintStoryPoints arg1) {
				return arg0.getDateEnteredForSprint().compareTo(
						arg1.getDateEnteredForSprint());

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
