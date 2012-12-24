/**
 */
package org.eclipse.emf.ecp.Scrum.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

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
	Backlog backlog;
	public int getTotalStoryPoints() {
		int totalStoryPoint = 0;		

		EList<BacklogItem> backlogItemList = backlog.getBacklogItems();
		
		for(BacklogItem backlogItem : backlogItemList)
		{
			totalStoryPoint = totalStoryPoint + backlogItem.getStoryPoints();			
		}
		
		return totalStoryPoint;
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
		}
		return super.eGet(featureID, resolve, coreType);
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
		}
		return super.eIsSet(featureID);
	}

} //CompositeImpl
