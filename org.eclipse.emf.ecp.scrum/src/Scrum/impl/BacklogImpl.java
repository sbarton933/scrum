/**
 */
package Scrum.impl;

import Scrum.Backlog;
import Scrum.BacklogItem;
import Scrum.ScrumPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Backlog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Scrum.impl.BacklogImpl#getTotalStoryPoints <em>Total Story Points</em>}</li>
 *   <li>{@link Scrum.impl.BacklogImpl#getBacklogItems <em>Backlog Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BacklogImpl extends EObjectImpl implements Backlog {
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
	protected BacklogImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScrumPackage.Literals.BACKLOG;
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
	public void setTotalStoryPoints(int newTotalStoryPoints) {
		int oldTotalStoryPoints = totalStoryPoints;
		totalStoryPoints = newTotalStoryPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.BACKLOG__TOTAL_STORY_POINTS, oldTotalStoryPoints, totalStoryPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BacklogItem> getBacklogItems() {
		if (backlogItems == null) {
			backlogItems = new EObjectResolvingEList<BacklogItem>(BacklogItem.class, this, ScrumPackage.BACKLOG__BACKLOG_ITEMS);
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
			case ScrumPackage.BACKLOG__TOTAL_STORY_POINTS:
				return getTotalStoryPoints();
			case ScrumPackage.BACKLOG__BACKLOG_ITEMS:
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
			case ScrumPackage.BACKLOG__TOTAL_STORY_POINTS:
				setTotalStoryPoints((Integer)newValue);
				return;
			case ScrumPackage.BACKLOG__BACKLOG_ITEMS:
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
			case ScrumPackage.BACKLOG__TOTAL_STORY_POINTS:
				setTotalStoryPoints(TOTAL_STORY_POINTS_EDEFAULT);
				return;
			case ScrumPackage.BACKLOG__BACKLOG_ITEMS:
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
			case ScrumPackage.BACKLOG__TOTAL_STORY_POINTS:
				return totalStoryPoints != TOTAL_STORY_POINTS_EDEFAULT;
			case ScrumPackage.BACKLOG__BACKLOG_ITEMS:
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
		result.append(')');
		return result.toString();
	}

} //BacklogImpl
