/**
 */
package Scrum;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Scrum.Composite#getTotalStoryPoints <em>Total Story Points</em>}</li>
 * </ul>
 * </p>
 *
 * @see Scrum.ScrumPackage#getComposite()
 * @model interface="true" abstract="true"
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
	 * @see #setTotalStoryPoints(int)
	 * @see Scrum.ScrumPackage#getComposite_TotalStoryPoints()
	 * @model
	 * @generated
	 */
	int getTotalStoryPoints();

	/**
	 * Sets the value of the '{@link Scrum.Composite#getTotalStoryPoints <em>Total Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Story Points</em>' attribute.
	 * @see #getTotalStoryPoints()
	 * @generated
	 */
	void setTotalStoryPoints(int value);

} // Composite
