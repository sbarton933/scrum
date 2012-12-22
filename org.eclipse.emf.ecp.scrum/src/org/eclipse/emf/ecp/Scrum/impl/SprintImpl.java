/**
 */
package org.eclipse.emf.ecp.Scrum.impl;

import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecp.Scrum.ScrumPackage;
import org.eclipse.emf.ecp.Scrum.Sprint;

import org.eclipse.emf.ecp.Scrum.util.ScrumValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sprint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.SprintImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.SprintImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.SprintImpl#getPlannedStoryPoints <em>Planned Story Points</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SprintImpl extends CompositeImpl implements Sprint {
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
	 * @generated NOT
	 */
	public boolean validate(DiagnosticChain diagnostic, Map<?, ?> context) {

		if (getTotalStoryPoints() > plannedStoryPoints) {
			if (diagnostic != null) {
				diagnostic.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "Total Story Points",
						 ScrumValidator.SPRINT__VALIDATE,
						 "Delete a Task from this Sprint",
						 new Object[] {this, ScrumPackage.eINSTANCE.getSprint_PlannedStoryPoints()}));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScrumPackage.SPRINT__START_DATE:
				return getStartDate();
			case ScrumPackage.SPRINT__END_DATE:
				return getEndDate();
			case ScrumPackage.SPRINT__PLANNED_STORY_POINTS:
				return getPlannedStoryPoints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScrumPackage.SPRINT__START_DATE:
				setStartDate((Date)newValue);
				return;
			case ScrumPackage.SPRINT__END_DATE:
				setEndDate((Date)newValue);
				return;
			case ScrumPackage.SPRINT__PLANNED_STORY_POINTS:
				setPlannedStoryPoints((Integer)newValue);
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
			case ScrumPackage.SPRINT__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case ScrumPackage.SPRINT__END_DATE:
				setEndDate(END_DATE_EDEFAULT);
				return;
			case ScrumPackage.SPRINT__PLANNED_STORY_POINTS:
				setPlannedStoryPoints(PLANNED_STORY_POINTS_EDEFAULT);
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
			case ScrumPackage.SPRINT__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case ScrumPackage.SPRINT__END_DATE:
				return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
			case ScrumPackage.SPRINT__PLANNED_STORY_POINTS:
				return plannedStoryPoints != PLANNED_STORY_POINTS_EDEFAULT;
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
		result.append(" (startDate: ");
		result.append(startDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", plannedStoryPoints: ");
		result.append(plannedStoryPoints);
		result.append(')');
		return result.toString();
	}

} //SprintImpl
