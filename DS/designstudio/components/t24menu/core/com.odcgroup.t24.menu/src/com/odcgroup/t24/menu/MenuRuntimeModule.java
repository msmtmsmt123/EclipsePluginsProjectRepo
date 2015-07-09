/*
 * generated by Xtext
 */
package com.odcgroup.t24.menu;

import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.service.SingletonBinding;

import com.google.inject.Provider;
import com.odcgroup.t24.menu.naming.MenuNameProvider;
import com.odcgroup.t24.menu.resource.MenuResource;
import com.odcgroup.t24.menu.resource.MenuResourceDescriptionStrategy;
import com.odcgroup.t24.menu.scoping.MenuGlobalScopeProvider;
import com.odcgroup.workbench.dsl.resources.CommonDSLResourceServiceProvider;
import com.odcgroup.workbench.dsl.resources.DSLEncodingProviderProvider;
/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class MenuRuntimeModule extends com.odcgroup.t24.menu.AbstractMenuRuntimeModule {

	@Override
	@SingletonBinding
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return MenuGlobalScopeProvider.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return MenuResource.class;
	}
	
    public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
    	return MenuNameProvider.class;
    }

	@Override
	public Class<? extends Provider<IEncodingProvider>> provideIEncodingProvider() {
	    return DSLEncodingProviderProvider.class;
	}
	
	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return MenuResourceDescriptionStrategy.class;
	}
	
//	@Override
//    @SingletonBinding
//    public Class<? extends IValueConverterService> bindIValueConverterService() {
//          return DSLValueConverterService.class;
//    }
	
	public Class<? extends IResourceServiceProvider> bindIResourceServiceProvider() {
		return CommonDSLResourceServiceProvider.class;
	}
 
}
