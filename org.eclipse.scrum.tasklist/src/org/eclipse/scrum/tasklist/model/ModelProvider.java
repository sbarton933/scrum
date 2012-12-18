package org.eclipse.scrum.tasklist.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.emf.ecp.Scrum.Task;

public enum ModelProvider {
  INSTANCE;

  private ModelProvider() {	
	  tasks = new ArrayList<Task>();
	  
	  Task task = ScrumFactory.eINSTANCE.createTask();
	  task.setID(0);
	  task.setName("Create User");
	  task.setDescription("Need to Create User");
	  task.setPriority(0);
	  tasks.add(task);
	  
	  task = ScrumFactory.eINSTANCE.createTask();
	  task.setID(1);
	  task.setName("Create Task");
	  task.setDescription("Need to Create Task");
	  task.setPriority(1);
	  tasks.add(task);
  }
  
  private List<Task> tasks;

  public List<Task> getTasks() {
    return tasks;
  }

} 