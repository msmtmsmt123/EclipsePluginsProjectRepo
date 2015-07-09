/*******************************************************************************
 * Copyright (c) 2012 Michael Vorburger (http://www.vorburger.ch).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.odcgroup.workbench.dsl.xml;

import org.eclipse.emf.ecore.EObject;

/**
 * Util which deals with name:/Something URI Proxies.
 * This is used to transform EMF XML containing name-based cross references into real Xtext objects, and vice versa.  
 * 
 * @see NameURISwapperImpl#getNameFromProxy(EObject) to access the content of name:/ URI Proxies
 * 
 * @author Michael Vorburger
 */
public interface NameURISwapper extends NameToXtextURISwapper, XtextToNameURISwapper { 

}