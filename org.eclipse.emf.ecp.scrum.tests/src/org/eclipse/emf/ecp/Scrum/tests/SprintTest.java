/**
 */
package org.eclipse.emf.ecp.Scrum.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.emf.ecp.Scrum.Sprint;
import org.eclipse.emf.ecp.Scrum.Task;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sprint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.Sprint#validate(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SprintTest extends CompositeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SprintTest.class);
	}

	/**
	 * Constructs a new Sprint test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SprintTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sprint test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Sprint getFixture() {
		return (Sprint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ScrumFactory.eINSTANCE.createSprint());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.emf.ecp.Scrum.Sprint#validate(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.Sprint#validate(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated NOT
	 */
	public void testValidate__DiagnosticChain_Map() {
		Sprint sprint = ScrumFactory.eINSTANCE.createSprint();
		Task task = ScrumFactory.eINSTANCE.createTask();
		task.setStoryPoints(2);
		sprint.getBacklogItems().add(task);
		sprint.setPlannedStoryPoints(1);
		Diagnostic validate = Diagnostician.INSTANCE.validate(sprint);
		assertEquals(Diagnostic.ERROR, validate.getSeverity());
	}

} //SprintTest
