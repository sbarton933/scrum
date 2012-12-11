/**
 */
package org.eclipse.emf.ecp.Scrum.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.emf.ecp.Scrum.ScrumFactory;
import org.eclipse.emf.ecp.Scrum.UserStory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>User Story</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UserStoryTest extends TestCase {

	/**
	 * The fixture for this User Story test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserStory fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UserStoryTest.class);
	}

	/**
	 * Constructs a new User Story test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserStoryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this User Story test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(UserStory fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this User Story test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserStory getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ScrumFactory.eINSTANCE.createUserStory());
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

} //UserStoryTest
