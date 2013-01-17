package org.eclipse.emf.ecp.scrum.sprinthistory;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SprintStoryPoints  {
	
	 int perSprintStoryPoints;
	
	 Date dateEnteredForSprint;
	
	private SprintStoryPoints sprint;
	
	public SprintStoryPoints()
	{
		
	}
	
	public SprintStoryPoints setSprintStoryPoints(int perSprintStoryPoints, Date dateEnteredForSprint) {
		
		this.perSprintStoryPoints = perSprintStoryPoints;
		this.dateEnteredForSprint = dateEnteredForSprint;
		
		return this;
		 
	}
	
	
	public List<SprintStoryPoints> getSprintStoryPoints()
	{
		return null;
		
	}


	public int getPerSprintStoryPoints() {
		return perSprintStoryPoints;
	}


	public Date getDateEnteredForSprint() {
		return dateEnteredForSprint;
	}


	public void setPerSprintStoryPoints(int perSprintStoryPoints) {
		this.perSprintStoryPoints = perSprintStoryPoints;
	}


	public void setDateEnteredForSprint(Date dateEnteredForSprint) {
		this.dateEnteredForSprint = dateEnteredForSprint;
	}


	


	
	
	

}
