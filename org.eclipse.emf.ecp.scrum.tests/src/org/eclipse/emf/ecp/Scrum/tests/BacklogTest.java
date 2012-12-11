/**
 */
package org.eclipse.emf.ecp.Scrum.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.ecp.Scrum.Backlog;
import org.eclipse.emf.ecp.Scrum.ScrumFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Backlog</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BacklogTest extends CompositeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BacklogTest.class);
	}

	/**
	 * Constructs a new Backlog test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BacklogTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Backlog test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Backlog getFixture() {
		return (Backlog)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ScrumFactory.eINSTANCE.createBacklog());
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

} //BacklogTest
