package org.eclipse.scrum.taskboard;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

public class MyContentAdapter extends EContentAdapter{
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
	}
}

