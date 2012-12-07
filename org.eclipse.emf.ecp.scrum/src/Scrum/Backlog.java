/**
 */
package Scrum;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Backlog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Scrum.Backlog#getBacklogItems <em>Backlog Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see Scrum.ScrumPackage#getBacklog()
 * @model
 * @generated
 */
public interface Backlog extends Composite {
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
	 * @see Scrum.ScrumPackage#getBacklog_BacklogItems()
	 * @model
	 * @generated
	 */
	EList<BacklogItem> getBacklogItems();

} // Backlog
