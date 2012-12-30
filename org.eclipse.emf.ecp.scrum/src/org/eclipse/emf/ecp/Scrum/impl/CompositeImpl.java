/**
 */
package org.eclipse.emf.ecp.Scrum.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecp.Scrum.Backlog;
import org.eclipse.emf.ecp.Scrum.BacklogItem;
import org.eclipse.emf.ecp.Scrum.Composite;
import org.eclipse.emf.ecp.Scrum.ScrumPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.CompositeImpl#getTotalStoryPoints <em>Total Story Points</em>}</li>
 *   <li>{@link org.eclipse.emf.ecp.Scrum.impl.CompositeImpl#getBacklogItems <em>Backlog Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompositeImpl extends EObjectImpl implements Composite {
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
	 * The cached value of the '{@link #getBacklogItems() <em>Backlog Items</em>}' containment reference list.
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
	protected CompositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScrumPackage.Literals.COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private Backlog backlog;
	public int getTotalStoryPoints() {
		int totalStoryPoint = 0;		
		//FIXME This can't work as backlog is always null
//		EList<BacklogItem> backlogItemList = backlog.getBacklogItems();
//		
//		for(BacklogItem backlogItem : backlogItemList)
//		{
//			totalStoryPoint = totalStoryPoint + backlogItem.getStoryPoints();			
//		}
		
		return totalStoryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BacklogItem> getBacklogItems() {
		if (backlogItems == null) {
			backlogItems = new EObjectContainmentEList<BacklogItem>(BacklogItem.class, this, ScrumPackage.COMPOSITE__BACKLOG_ITEMS);
		}
		return backlogItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScrumPackage.COMPOSITE__BACKLOG_ITEMS:
				return ((InternalEList<?>)getBacklogItems()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScrumPackage.COMPOSITE__TOTAL_STORY_POINTS:
				return getTotalStoryPoints();
			case ScrumPackage.COMPOSITE__BACKLOG_ITEMS:
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
			case ScrumPackage.COMPOSITE__BACKLOG_ITEMS:
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
			case ScrumPackage.COMPOSITE__BACKLOG_ITEMS:
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
			case ScrumPackage.COMPOSITE__TOTAL_STORY_POINTS:
				return getTotalStoryPoints() != TOTAL_STORY_POINTS_EDEFAULT;
			case ScrumPackage.COMPOSITE__BACKLOG_ITEMS:
				return backlogItems != null && !backlogItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeImpl
