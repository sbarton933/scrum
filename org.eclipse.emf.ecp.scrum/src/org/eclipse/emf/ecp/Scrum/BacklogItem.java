/**
 */
package org.eclipse.emf.ecp.Scrum;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Backlog Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getID <em>ID</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getStoryPoints <em>Story Points</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklogItem()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface BacklogItem extends EObject {
	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(int)
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklogItem_ID()
	 * @model
	 * @generated
	 */
	int getID();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(int value);

	/**
	 * Returns the value of the '<em><b>Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Story Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Story Points</em>' attribute.
	 * @see #setStoryPoints(int)
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklogItem_StoryPoints()
	 * @model
	 * @generated
	 */
	int getStoryPoints();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getStoryPoints <em>Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Story Points</em>' attribute.
	 * @see #getStoryPoints()
	 * @generated
	 */
	void setStoryPoints(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklogItem_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(int)
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklogItem_Status()
	 * @model
	 * @generated
	 */
	int getStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(int value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklogItem_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(Enumerator)
	 * @see org.eclipse.emf.ecp.Scrum.ScrumPackage#getBacklogItem_Priority()
	 * @model transient="true"
	 * @generated
	 */
	Enumerator getPriority();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Enumerator value);

} // BacklogItem
