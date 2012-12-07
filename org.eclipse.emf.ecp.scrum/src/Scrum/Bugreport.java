/**
 */
package Scrum;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bugreport</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Scrum.Bugreport#getTask <em>Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see Scrum.ScrumPackage#getBugreport()
 * @model
 * @generated
 */
public interface Bugreport extends BacklogItem {
	/**
	 * Returns the value of the '<em><b>Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' reference.
	 * @see #setTask(Task)
	 * @see Scrum.ScrumPackage#getBugreport_Task()
	 * @model required="true"
	 * @generated
	 */
	Task getTask();

	/**
	 * Sets the value of the '{@link Scrum.Bugreport#getTask <em>Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(Task value);

} // Bugreport
