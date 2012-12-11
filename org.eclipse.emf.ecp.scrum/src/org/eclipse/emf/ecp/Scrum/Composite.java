/**
 */
package org.eclipse.emf.ecp.Scrum;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.Composite#getTotalStoryPoints <em>Total Story Points</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.Composite#getBacklogItems <em>Backlog Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getComposite()
 * @model abstract="true"
 * @generated
 */
public interface Composite extends EObject {
	/**
	 * Returns the value of the '<em><b>Total Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Story Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Story Points</em>' attribute.
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getComposite_TotalStoryPoints()
	 * @model changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getTotalStoryPoints();

	/**
	 * Returns the value of the '<em><b>Backlog Items</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecp.Scrum.BacklogItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backlog Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backlog Items</em>' reference list.
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getComposite_BacklogItems()
	 * @model
	 * @generated
	 */
	EList<BacklogItem> getBacklogItems();

} // Composite
