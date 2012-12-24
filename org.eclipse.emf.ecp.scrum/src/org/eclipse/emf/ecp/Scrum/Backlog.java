/**
 */
package org.eclipse.emf.ecp.Scrum;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Backlog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.Backlog#getBacklogItems <em>Backlog Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklog()
 * @model
 * @generated
 */
public interface Backlog extends Composite {

	/**
	 * Returns the value of the '<em><b>Backlog Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecp.Scrum.BacklogItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backlog Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backlog Items</em>' containment reference list.
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklog_BacklogItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<BacklogItem> getBacklogItems();
} // Backlog
