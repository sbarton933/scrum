/**
 */
package org.eclipse.emf.ecp.Scrum.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.emf.ecp.Scrum.Sprint;

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
	 * @generated
	 */
	public void testValidate__DiagnosticChain_Map() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		
		//Sprint createSprint = ScrumFactory.eINSTANCE.createSprint();
		//createSprint.setPlannedStoryPoints(10);
		//createSprint.setTotalStoryPoints(11);
		//Diagnostic validate = Diagnostician.INSTANCE.validate(createSprint);
		//assertEquals(Diagnostic.ERROR, validate.getSeverity());
	}

} //SprintTest
