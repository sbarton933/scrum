/**
 */
package org.eclipse.emf.ecp.Scrum.tests;

import junit.framework.TestCase;

import org.eclipse.emf.ecp.Scrum.Composite;
import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.Scrum.Task;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.Composite#getTotalStoryPoints() <em>Total Story Points</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class CompositeTest extends TestCase {

	/**
	 * The fixture for this Composite test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Composite fixture = null;

	/**
	 * Constructs a new Composite test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Composite test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Composite fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Composite test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Composite getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link org.eclipse.emf.ecp.Scrum.Composite#getTotalStoryPoints() <em>Total Story Points</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.Composite#getTotalStoryPoints()
	 * @generated NOT
	 */
	public void testGetTotalStoryPoints() {
		Sprint sprint = ScrumFactory.eINSTANCE.createSprint();		
		Task task1 = ScrumFactory.eINSTANCE.createTask();
		task1.setStoryPoints(2);
		Task task2 = ScrumFactory.eINSTANCE.createTask();
		task2.setStoryPoints(3);		
		sprint.getBacklogItems().add(task1);
		sprint.getBacklogItems().add(task2);
		int totalStoryPointsManually = task1.getStoryPoints() + task2.getStoryPoints();
		int totalStoryPointsByMethod = sprint.getTotalStoryPoints();		
		assertEquals(totalStoryPointsByMethod, totalStoryPointsManually);

	}

	/**
	 * Tests the '{@link org.eclipse.emf.ecp.Scrum.Composite#setTotalStoryPoints(int) <em>Total Story Points</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.Composite#setTotalStoryPoints(int)
	 * @generated
	 */
	public void testSetTotalStoryPoints() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //CompositeTest
