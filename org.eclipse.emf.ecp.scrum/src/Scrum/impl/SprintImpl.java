/**
 */
package Scrum.impl;

import Scrum.BacklogItem;
import Scrum.ScrumPackage;
import Scrum.Sprint;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sprint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Scrum.impl.SprintImpl#getTotalStoryPoints <em>Total Story Points</em>}</li>
 *   <li>{@link Scrum.impl.SprintImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link Scrum.impl.SprintImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link Scrum.impl.SprintImpl#getPlannedStoryPoints <em>Planned Story Points</em>}</li>
 *   <li>{@link Scrum.impl.SprintImpl#getBacklogItems <em>Backlog Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SprintImpl extends EObjectImpl implements Sprint {
	/**
	 * The default value of the '{@link #getTotalStoryPoints() <em>Total Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_STORY_POINTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalStoryPoints() <em>Total Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected int totalStoryPoints = TOTAL_STORY_POINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date startDate = START_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected Date endDate = END_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlannedStoryPoints() <em>Planned Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlannedStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected static final int PLANNED_STORY_POINTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPlannedStoryPoints() <em>Planned Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlannedStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected int plannedStoryPoints = PLANNED_STORY_POINTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBacklogItems() <em>Backlog Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBacklogItems()
	 * @generated
	 * @ordered
	 */
	protected EList<BacklogItem> backlogItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SprintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScrumPackage.Literals.SPRINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalStoryPoints() {
		return totalStoryPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalStoryPoints() {
		int oldTotalStoryPoints = totalStoryPoints;
		//totalStoryPoints = newTotalStoryPoints;
		for (int i = 0; i < backlogItems.size()-1; i++){
			totalStoryPoints += backlogItems.get(i).getStoryPoints();
		}
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.SPRINT__TOTAL_STORY_POINTS, oldTotalStoryPoints, totalStoryPoints));
	}
	
	@Override
	public void setTotalStoryPoints(int value) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.SPRINT__START_DATE, oldStartDate, startDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDate(Date newEndDate) {
		Date oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.SPRINT__END_DATE, oldEndDate, endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPlannedStoryPoints() {
		return plannedStoryPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlannedStoryPoints(int newPlannedStoryPoints) {
		int oldPlannedStoryPoints = plannedStoryPoints;
		plannedStoryPoints = newPlannedStoryPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.SPRINT__PLANNED_STORY_POINTS, oldPlannedStoryPoints, plannedStoryPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BacklogItem> getBacklogItems() {
		if (backlogItems == null) {
			backlogItems = new EObjectResolvingEList<BacklogItem>(BacklogItem.class, this, ScrumPackage.SPRINT__BACKLOG_ITEMS);
		}
		return backlogItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScrumPackage.SPRINT__TOTAL_STORY_POINTS:
				return getTotalStoryPoints();
			case ScrumPackage.SPRINT__START_DATE:
				return getStartDate();
			case ScrumPackage.SPRINT__END_DATE:
				return getEndDate();
			case ScrumPackage.SPRINT__PLANNED_STORY_POINTS:
				return getPlannedStoryPoints();
			case ScrumPackage.SPRINT__BACKLOG_ITEMS:
				return getBacklogItems();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScrumPackage.SPRINT__TOTAL_STORY_POINTS:
				setTotalStoryPoints((Integer)newValue);
				return;
			case ScrumPackage.SPRINT__START_DATE:
				setStartDate((Date)newValue);
				return;
			case ScrumPackage.SPRINT__END_DATE:
				setEndDate((Date)newValue);
				return;
			case ScrumPackage.SPRINT__PLANNED_STORY_POINTS:
				setPlannedStoryPoints((Integer)newValue);
				return;
			case ScrumPackage.SPRINT__BACKLOG_ITEMS:
				getBacklogItems().clear();
				getBacklogItems().addAll((Collection<? extends BacklogItem>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ScrumPackage.SPRINT__TOTAL_STORY_POINTS:
				setTotalStoryPoints(TOTAL_STORY_POINTS_EDEFAULT);
				return;
			case ScrumPackage.SPRINT__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case ScrumPackage.SPRINT__END_DATE:
				setEndDate(END_DATE_EDEFAULT);
				return;
			case ScrumPackage.SPRINT__PLANNED_STORY_POINTS:
				setPlannedStoryPoints(PLANNED_STORY_POINTS_EDEFAULT);
				return;
			case ScrumPackage.SPRINT__BACKLOG_ITEMS:
				getBacklogItems().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScrumPackage.SPRINT__TOTAL_STORY_POINTS:
				return totalStoryPoints != TOTAL_STORY_POINTS_EDEFAULT;
			case ScrumPackage.SPRINT__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case ScrumPackage.SPRINT__END_DATE:
				return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
			case ScrumPackage.SPRINT__PLANNED_STORY_POINTS:
				return plannedStoryPoints != PLANNED_STORY_POINTS_EDEFAULT;
			case ScrumPackage.SPRINT__BACKLOG_ITEMS:
				return backlogItems != null && !backlogItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (totalStoryPoints: ");
		result.append(totalStoryPoints);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", plannedStoryPoints: ");
		result.append(plannedStoryPoints);
		result.append(')');
		return result.toString();
	}

} //SprintImpl
