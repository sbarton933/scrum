/**
 */
package Scrum;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sprint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Scrum.Sprint#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link Scrum.Sprint#getEndDate <em>End Date</em>}</li>
 *   <li>{@link Scrum.Sprint#getPlannedStoryPoints <em>Planned Story Points</em>}</li>
 *   <li>{@link Scrum.Sprint#getBacklogItems <em>Backlog Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see Scrum.ScrumPackage#getSprint()
 * @model
 * @generated
 */
public interface Sprint extends Composite {
	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #setStartDate(Date)
	 * @see Scrum.ScrumPackage#getSprint_StartDate()
	 * @model
	 * @generated
	 */
	Date getStartDate();

	/**
	 * Sets the value of the '{@link Scrum.Sprint#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(Date value);

	/**
	 * Returns the value of the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Date</em>' attribute.
	 * @see #setEndDate(Date)
	 * @see Scrum.ScrumPackage#getSprint_EndDate()
	 * @model
	 * @generated
	 */
	Date getEndDate();

	/**
	 * Sets the value of the '{@link Scrum.Sprint#getEndDate <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Date</em>' attribute.
	 * @see #getEndDate()
	 * @generated
	 */
	void setEndDate(Date value);

	/**
	 * Returns the value of the '<em><b>Planned Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planned Story Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planned Story Points</em>' attribute.
	 * @see #setPlannedStoryPoints(int)
	 * @see Scrum.ScrumPackage#getSprint_PlannedStoryPoints()
	 * @model
	 * @generated
	 */
	int getPlannedStoryPoints();

	/**
	 * Sets the value of the '{@link Scrum.Sprint#getPlannedStoryPoints <em>Planned Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planned Story Points</em>' attribute.
	 * @see #getPlannedStoryPoints()
	 * @generated
	 */
	void setPlannedStoryPoints(int value);

	/**
	 * Returns the value of the '<em><b>Backlog Items</b></em>' reference list.
	 * The list contents are of type {@link Scrum.BacklogItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backlog Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backlog Items</em>' reference list.
	 * @see Scrum.ScrumPackage#getSprint_BacklogItems()
	 * @model
	 * @generated
	 */
	EList<BacklogItem> getBacklogItems();

} // Sprint
