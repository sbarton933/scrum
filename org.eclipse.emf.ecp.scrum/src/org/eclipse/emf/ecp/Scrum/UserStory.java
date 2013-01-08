/**
 */
package org.eclipse.emf.ecp.Scrum;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Story</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.UserStory#getTasks <em>Tasks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getUserStory()
 * @model
 * @generated
 */
public interface UserStory extends BacklogItem {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecp.Scrum.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' reference list.
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getUserStory_Tasks()
	 * @model annotation="org.eclipse.emf.ecp.editor position='bottom'"
	 * @generated
	 */
	EList<Task> getTasks();

} // UserStory
