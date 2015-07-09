/*
 * generated by Xtext
 */
package com.odcgroup.t24.menu.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import com.odcgroup.t24.menu.ui.internal.MenuActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MenuExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return MenuActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return MenuActivator.getInstance().getInjector(MenuActivator.COM_ODCGROUP_T24_MENU_MENU);
	}
	
}
