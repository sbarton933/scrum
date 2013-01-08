/**
 */
package org.eclipse.emf.ecp.Scrum;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ecp.Scrum.ScrumFactory
 * @model kind="package"
 * @generated
 */
public interface ScrumPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Scrum";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org/eclipse/emf/ecp/scrum";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.ecp.scrum";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScrumPackage eINSTANCE = org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.BacklogItem <em>Backlog Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.BacklogItem
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getBacklogItem()
	 * @generated
	 */
	int BACKLOG_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_ITEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_ITEM__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_ITEM__ID = 2;

	/**
	 * The feature id for the '<em><b>Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_ITEM__STORY_POINTS = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_ITEM__STATUS = 4;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_ITEM__PRIORITY = 5;

	/**
	 * The number of structural features of the '<em>Backlog Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_ITEM_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.impl.TaskImpl
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = BACKLOG_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DESCRIPTION = BACKLOG_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ID = BACKLOG_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__STORY_POINTS = BACKLOG_ITEM__STORY_POINTS;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__STATUS = BACKLOG_ITEM__STATUS;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PRIORITY = BACKLOG_ITEM__PRIORITY;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = BACKLOG_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.impl.BugreportImpl <em>Bugreport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.impl.BugreportImpl
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getBugreport()
	 * @generated
	 */
	int BUGREPORT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUGREPORT__NAME = BACKLOG_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUGREPORT__DESCRIPTION = BACKLOG_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUGREPORT__ID = BACKLOG_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUGREPORT__STORY_POINTS = BACKLOG_ITEM__STORY_POINTS;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUGREPORT__STATUS = BACKLOG_ITEM__STATUS;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUGREPORT__PRIORITY = BACKLOG_ITEM__PRIORITY;

	/**
	 * The number of structural features of the '<em>Bugreport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUGREPORT_FEATURE_COUNT = BACKLOG_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.impl.UserStoryImpl <em>User Story</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.impl.UserStoryImpl
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getUserStory()
	 * @generated
	 */
	int USER_STORY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_STORY__NAME = BACKLOG_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_STORY__DESCRIPTION = BACKLOG_ITEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_STORY__ID = BACKLOG_ITEM__ID;

	/**
	 * The feature id for the '<em><b>Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_STORY__STORY_POINTS = BACKLOG_ITEM__STORY_POINTS;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_STORY__STATUS = BACKLOG_ITEM__STATUS;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_STORY__PRIORITY = BACKLOG_ITEM__PRIORITY;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_STORY__TASKS = BACKLOG_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Story</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_STORY_FEATURE_COUNT = BACKLOG_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.impl.CompositeImpl <em>Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.impl.CompositeImpl
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getComposite()
	 * @generated
	 */
	int COMPOSITE = 4;

	/**
	 * The feature id for the '<em><b>Total Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__TOTAL_STORY_POINTS = 0;

	/**
	 * The feature id for the '<em><b>Backlog Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__BACKLOG_ITEMS = 1;

	/**
	 * The number of structural features of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.impl.BacklogImpl <em>Backlog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.impl.BacklogImpl
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getBacklog()
	 * @generated
	 */
	int BACKLOG = 5;

	/**
	 * The feature id for the '<em><b>Total Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG__TOTAL_STORY_POINTS = COMPOSITE__TOTAL_STORY_POINTS;

	/**
	 * The feature id for the '<em><b>Backlog Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG__BACKLOG_ITEMS = COMPOSITE__BACKLOG_ITEMS;

	/**
	 * The number of structural features of the '<em>Backlog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKLOG_FEATURE_COUNT = COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.impl.SprintImpl <em>Sprint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.impl.SprintImpl
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getSprint()
	 * @generated
	 */
	int SPRINT = 6;

	/**
	 * The feature id for the '<em><b>Total Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT__TOTAL_STORY_POINTS = COMPOSITE__TOTAL_STORY_POINTS;

	/**
	 * The feature id for the '<em><b>Backlog Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT__BACKLOG_ITEMS = COMPOSITE__BACKLOG_ITEMS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT__NAME = COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT__START_DATE = COMPOSITE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT__END_DATE = COMPOSITE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Planned Story Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT__PLANNED_STORY_POINTS = COMPOSITE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sprint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRINT_FEATURE_COUNT = COMPOSITE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.impl.UserImpl
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getUser()
	 * @generated
	 */
	int USER = 7;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Backlog Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__BACKLOG_ITEMS = 2;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.Scrum.Status <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.Scrum.Status
	 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.Scrum.BacklogItem <em>Backlog Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Backlog Item</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.BacklogItem
	 * @generated
	 */
	EClass getBacklogItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.BacklogItem#getID()
	 * @see #getBacklogItem()
	 * @generated
	 */
	EAttribute getBacklogItem_ID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getStoryPoints <em>Story Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Story Points</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.BacklogItem#getStoryPoints()
	 * @see #getBacklogItem()
	 * @generated
	 */
	EAttribute getBacklogItem_StoryPoints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.BacklogItem#getName()
	 * @see #getBacklogItem()
	 * @generated
	 */
	EAttribute getBacklogItem_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.BacklogItem#getStatus()
	 * @see #getBacklogItem()
	 * @generated
	 */
	EAttribute getBacklogItem_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.BacklogItem#getDescription()
	 * @see #getBacklogItem()
	 * @generated
	 */
	EAttribute getBacklogItem_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.BacklogItem#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.BacklogItem#getPriority()
	 * @see #getBacklogItem()
	 * @generated
	 */
	EAttribute getBacklogItem_Priority();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.Scrum.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.Scrum.Bugreport <em>Bugreport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bugreport</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Bugreport
	 * @generated
	 */
	EClass getBugreport();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.Scrum.UserStory <em>User Story</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Story</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.UserStory
	 * @generated
	 */
	EClass getUserStory();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.ecp.Scrum.UserStory#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tasks</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.UserStory#getTasks()
	 * @see #getUserStory()
	 * @generated
	 */
	EReference getUserStory_Tasks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.Scrum.Composite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Composite
	 * @generated
	 */
	EClass getComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.Composite#getTotalStoryPoints <em>Total Story Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Story Points</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Composite#getTotalStoryPoints()
	 * @see #getComposite()
	 * @generated
	 */
	EAttribute getComposite_TotalStoryPoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecp.Scrum.Composite#getBacklogItems <em>Backlog Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Backlog Items</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Composite#getBacklogItems()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_BacklogItems();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.Scrum.Backlog <em>Backlog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Backlog</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Backlog
	 * @generated
	 */
	EClass getBacklog();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.Scrum.Sprint <em>Sprint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sprint</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Sprint
	 * @generated
	 */
	EClass getSprint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.Sprint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Sprint#getName()
	 * @see #getSprint()
	 * @generated
	 */
	EAttribute getSprint_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.Sprint#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Sprint#getStartDate()
	 * @see #getSprint()
	 * @generated
	 */
	EAttribute getSprint_StartDate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.Sprint#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Sprint#getEndDate()
	 * @see #getSprint()
	 * @generated
	 */
	EAttribute getSprint_EndDate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.Sprint#getPlannedStoryPoints <em>Planned Story Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Planned Story Points</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Sprint#getPlannedStoryPoints()
	 * @see #getSprint()
	 * @generated
	 */
	EAttribute getSprint_PlannedStoryPoints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.Scrum.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.User#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.User#getFirstName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecp.Scrum.User#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.User#getLastName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_LastName();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.ecp.Scrum.User#getBacklogItems <em>Backlog Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Backlog Items</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.User#getBacklogItems()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_BacklogItems();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.ecp.Scrum.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see org.eclipse.emf.ecp.Scrum.Status
	 * @generated
	 */
	EEnum getStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScrumFactory getScrumFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.BacklogItem <em>Backlog Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.BacklogItem
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getBacklogItem()
		 * @generated
		 */
		EClass BACKLOG_ITEM = eINSTANCE.getBacklogItem();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKLOG_ITEM__ID = eINSTANCE.getBacklogItem_ID();

		/**
		 * The meta object literal for the '<em><b>Story Points</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKLOG_ITEM__STORY_POINTS = eINSTANCE.getBacklogItem_StoryPoints();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKLOG_ITEM__NAME = eINSTANCE.getBacklogItem_Name();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKLOG_ITEM__STATUS = eINSTANCE.getBacklogItem_Status();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKLOG_ITEM__DESCRIPTION = eINSTANCE.getBacklogItem_Description();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BACKLOG_ITEM__PRIORITY = eINSTANCE.getBacklogItem_Priority();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.impl.TaskImpl
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.impl.BugreportImpl <em>Bugreport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.impl.BugreportImpl
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getBugreport()
		 * @generated
		 */
		EClass BUGREPORT = eINSTANCE.getBugreport();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.impl.UserStoryImpl <em>User Story</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.impl.UserStoryImpl
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getUserStory()
		 * @generated
		 */
		EClass USER_STORY = eINSTANCE.getUserStory();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_STORY__TASKS = eINSTANCE.getUserStory_Tasks();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.impl.CompositeImpl <em>Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.impl.CompositeImpl
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getComposite()
		 * @generated
		 */
		EClass COMPOSITE = eINSTANCE.getComposite();

		/**
		 * The meta object literal for the '<em><b>Total Story Points</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE__TOTAL_STORY_POINTS = eINSTANCE.getComposite_TotalStoryPoints();

		/**
		 * The meta object literal for the '<em><b>Backlog Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__BACKLOG_ITEMS = eINSTANCE.getComposite_BacklogItems();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.impl.BacklogImpl <em>Backlog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.impl.BacklogImpl
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getBacklog()
		 * @generated
		 */
		EClass BACKLOG = eINSTANCE.getBacklog();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.impl.SprintImpl <em>Sprint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.impl.SprintImpl
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getSprint()
		 * @generated
		 */
		EClass SPRINT = eINSTANCE.getSprint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRINT__NAME = eINSTANCE.getSprint_Name();

		/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRINT__START_DATE = eINSTANCE.getSprint_StartDate();

		/**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRINT__END_DATE = eINSTANCE.getSprint_EndDate();

		/**
		 * The meta object literal for the '<em><b>Planned Story Points</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRINT__PLANNED_STORY_POINTS = eINSTANCE.getSprint_PlannedStoryPoints();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.impl.UserImpl
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__FIRST_NAME = eINSTANCE.getUser_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__LAST_NAME = eINSTANCE.getUser_LastName();

		/**
		 * The meta object literal for the '<em><b>Backlog Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__BACKLOG_ITEMS = eINSTANCE.getUser_BacklogItems();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.Scrum.Status <em>Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.Scrum.Status
		 * @see org.eclipse.emf.ecp.Scrum.impl.ScrumPackageImpl#getStatus()
		 * @generated
		 */
		EEnum STATUS = eINSTANCE.getStatus();

	}

} //ScrumPackage
