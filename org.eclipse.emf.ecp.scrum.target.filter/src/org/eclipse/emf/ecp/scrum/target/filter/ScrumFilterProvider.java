package org.eclipse.emf.ecp.scrum.target.filter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecp.core.util.IFilterProvider;

public class ScrumFilterProvider implements IFilterProvider {

	public ScrumFilterProvider() {
		
	}

	@Override
	public Collection<String> getFilteredPackages() {
		Set<String> packages = new HashSet<String>();
		//e4
				packages.add("http://www.eclipse.org/ui/2010/UIModel/application/ui/menu");
				packages.add("http://www.eclipse.org/ui/2010/UIModel/application/ui");
				packages.add("http://www.eclipse.org/ui/2010/UIModel/fragment");
				packages.add("http://www.eclipse.org/ui/2010/UIModel/application/ui/basic");
				packages.add("http://www.eclipse.org/ui/2010/UIModel/application");
				packages.add("http://www.eclipse.org/ui/2010/UIModel/application/ui/advanced");
				packages.add("http://www.eclipse.org/ui/2010/UIModel/application/commands");
				packages.add("http://www.eclipse.org/ui/2010/UIModel/application/descriptor/basic");
				//emfstore
				packages.add("http://eclipse.org/emf/emfstore/server/model/roles");
				packages.add("http://eclipse.org/emf/emfstore/common/model");
				
				packages.add("http://eclipse.org/emf/emfstore/server/model/versioning/events");
				packages.add("http://eclipse.org/emf/emfstore/client/model");
				packages.add("http://eclipse.org/emf/emfstore/server/model/versioning");
				packages.add("http://eclipse.org/emf/emfstore/server/model/versioning/operations");
				packages.add("http://eclipse.org/emf/emfstore/server/model/versioning/events/server/");
				packages.add("http://eclipse.org/emf/emfstore/server/model/url");
				packages.add("http://eclipse.org/emf/emfstore/server/model/versioning/operations/semantic");
				packages.add("http://eclipse.org/emf/emfstore/server/model");
				packages.add("http://eclipse.org/emf/emfstore/server/model/accesscontrol");
				//emf
				packages.add("http://www.eclipse.org/emf/2002/Ecore");
				packages.add("http://www.eclipse.org/emf/2002/Tree");
				packages.add("http://www.eclipse.org/emf/2003/Change");
				packages.add("http://www.eclipse.org/emf/2003/XMLType");
				packages.add("http://www.eclipse.org/emf/2004/Ecore2Ecore");
				packages.add("http://www.eclipse.org/emf/2009/Validation");
				packages.add("http://www.eclipse.org/emf/2002/Mapping");
				packages.add("http://www.eclipse.org/emf/2002/GenModel");
				packages.add("http://www.eclipse.org/emf/2005/Ecore2XML");
				packages.add("http://www.eclipse.org/emf/2002/XSD2Ecore");
				//xml
				packages.add("http://www.eclipse.org/xsd/2002/XSD");
				packages.add("http://www.w3.org/XML/1998/namespace");
				//CDO
				packages.add("http://www.eclipse.org/emf/CDO/Eresource/4.0.0");
				packages.add("http://www.eclipse.org/emf/CDO/security/4.1.0");
				packages.add("http://www.eclipse.org/emf/CDO/Etypes/4.0.0");
				//OCL
				packages.add("http://www.eclipse.org/ocl/1.1.0/OCL/CST");
				packages.add("http://www.eclipse.org/ocl/1.1.0/OCL/Expressions");
				packages.add("http://www.eclipse.org/ocl/1.1.0/Ecore");
				packages.add("http://www.eclipse.org/ocl/1.1.0/UML");
				packages.add("http://www.eclipse.org/ocl/1.1.0/OCL");
				packages.add("http://www.eclipse.org/ocl/1.1.0/OCL/Types");
				packages.add("http://www.eclipse.org/ocl/1.1.0/OCL/Utilities");
				//UML
				packages.add("http://www.eclipse.org/uml2/2.2.0/GenModel");
				packages.add("http://www.eclipse.org/uml2/1.1.0/GenModel");
				packages.add("http://www.eclipse.org/uml2/schemas/Standard/1");
				packages.add("http://www.eclipse.org/uml2/2.1.0/UML");
				packages.add("http://www.eclipse.org/uml2/3.0.0/UML");
				packages.add("http://www.eclipse.org/uml2/4.0.0/Types");
				packages.add("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L3");
				packages.add("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L2");
				packages.add("http://www.eclipse.org/uml2/2.0.0/UML");
				packages.add("http://www.eclipse.org/uml2/4.0.0/UML");
				//emf compare
				packages.add("http://www.eclipse.org/emf/compare/match/1.1");
				packages.add("http://www.eclipse.org/emf/compare/epatch/0.1");
				packages.add("http://www.eclipse.org/emf/compare/diff/1.1");
				//gmf
				packages.add("http://www.eclipse.org/gmf/runtime/1.0.0/notation");
				packages.add("http://www.eclipse.org/gmf/runtime/1.0.2/notation");
				packages.add("http://www.eclipse.org/gmf/runtime/1.0.1/notation");
				//other default
				packages.add("http://www.eclipse.org/amalgamation/discovery/1.0");
				packages.add("http://www.eclipse.org/acceleo/profiler/3.0");
				packages.add("http://www.eclipse.org/acceleo/mtl/3.0");
				
				//graphiti
				packages.add("http://eclipse.org/graphiti/mm");
				packages.add("http://eclipse.org/graphiti/mm/pictograms");
				packages.add("http://eclipse.org/graphiti/mm/algorithms");
				packages.add("http://eclipse.org/graphiti/mm/algorithms/styles");
				
				packages.add("http://eclipse.org/graphiti/examples/chess");
				packages.add("http:///org/eclipse/graphiti/examples/filesystem");
				
				packages.add("http://ecp/1.0");
				packages.add("http://eclipse.org/emf/ecp/xmiworkspace/structure");
				packages.add("http://eclipse.org/emf/ecp/common/model/workspaceModel");
				
				packages.add("http://eclipse.org/emf/emfstore/server/model/accesscontrol");
				
				//packages.add("http://eclipse.org/emf/emfstore/server/model/accesscontrol");
					
				return packages;

		
	}

	
}
