/**
 */
package org.eclipse.emf.ecp.Scrum.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecp.Scrum.Bugreport;
import org.eclipse.emf.ecp.Scrum.ScrumPackage;
import org.eclipse.emf.ecp.Scrum.Status;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bugreport</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.BugreportImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.BugreportImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.BugreportImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.BugreportImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.BugreportImpl#getStoryPoints <em>Story Points</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.BugreportImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BugreportImpl extends EObjectImpl implements Bugreport, Serializable  {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	
	private static final long serialVersionUID = 7526472295622776147L; 
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final Status STATUS_EDEFAULT = Status.OPEN;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Status status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStoryPoints() <em>Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected static final int STORY_POINTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStoryPoints() <em>Story Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoryPoints()
	 * @generated
	 * @ordered
	 */
	protected int storyPoints = STORY_POINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BugreportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScrumPackage.Literals.BUGREPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(int newID) {
		int oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.BUGREPORT__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStoryPoints() {
		return storyPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoryPoints(int newStoryPoints) {
		int oldStoryPoints = storyPoints;
		storyPoints = newStoryPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.BUGREPORT__STORY_POINTS, oldStoryPoints, storyPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.BUGREPORT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(Status newStatus) {
		Status oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.BUGREPORT__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.BUGREPORT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScrumPackage.BUGREPORT__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScrumPackage.BUGREPORT__NAME:
				return getName();
			case ScrumPackage.BUGREPORT__DESCRIPTION:
				return getDescription();
			case ScrumPackage.BUGREPORT__ID:
				return getID();
			case ScrumPackage.BUGREPORT__STATUS:
				return getStatus();
			case ScrumPackage.BUGREPORT__STORY_POINTS:
				return getStoryPoints();
			case ScrumPackage.BUGREPORT__PRIORITY:
				return getPriority();
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
			case ScrumPackage.BUGREPORT__NAME:
				setName((String)newValue);
				return;
			case ScrumPackage.BUGREPORT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ScrumPackage.BUGREPORT__ID:
				setID((Integer)newValue);
				return;
			case ScrumPackage.BUGREPORT__STATUS:
				setStatus((Status)newValue);
				return;
			case ScrumPackage.BUGREPORT__STORY_POINTS:
				setStoryPoints((Integer)newValue);
				return;
			case ScrumPackage.BUGREPORT__PRIORITY:
				setPriority((Integer)newValue);
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
			case ScrumPackage.BUGREPORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ScrumPackage.BUGREPORT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ScrumPackage.BUGREPORT__ID:
				setID(ID_EDEFAULT);
				return;
			case ScrumPackage.BUGREPORT__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case ScrumPackage.BUGREPORT__STORY_POINTS:
				setStoryPoints(STORY_POINTS_EDEFAULT);
				return;
			case ScrumPackage.BUGREPORT__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
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
			case ScrumPackage.BUGREPORT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ScrumPackage.BUGREPORT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ScrumPackage.BUGREPORT__ID:
				return id != ID_EDEFAULT;
			case ScrumPackage.BUGREPORT__STATUS:
				return status != STATUS_EDEFAULT;
			case ScrumPackage.BUGREPORT__STORY_POINTS:
				return storyPoints != STORY_POINTS_EDEFAULT;
			case ScrumPackage.BUGREPORT__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", ID: ");
		result.append(id);
		result.append(", status: ");
		result.append(status);
		result.append(", storyPoints: ");
		result.append(storyPoints);
		result.append(", priority: ");
		result.append(priority);
		result.append(')');
		return result.toString();
	}
	

} //BugreportImpl
