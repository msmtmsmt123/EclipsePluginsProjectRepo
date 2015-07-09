/*
 * generated by Xtext
 */
package com.odcgroup.t24.enquiry;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

import com.odcgroup.t24.enquiry.formatting.EnquiryFormatter;
import com.odcgroup.t24.enquiry.resource.EnquiryResourceDescriptionStrategy;
import com.odcgroup.t24.enquiry.scoping.EnquiryQualifiedNameProvider;
import com.odcgroup.t24.enquiry.serializer.IntTransientValueService;
import com.odcgroup.t24.enquiry.validation.EnquirySyntaxErrorMessageProvider;
import com.odcgroup.t24.enquiry.valueconverter.EnquiryValueConverterService;
import com.odcgroup.workbench.dsl.resources.CommonDSLResourceServiceProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("restriction")
public class EnquiryRuntimeModule extends AbstractEnquiryRuntimeModule {
	
    @Override
    public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
    	return EnquiryQualifiedNameProvider.class;
    }
	
	@Override
	public Class<? extends org.eclipse.xtext.formatting.IFormatter> bindIFormatter() {
		return EnquiryFormatter.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return EnquiryValueConverterService.class;
	}
	
	public Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		return EnquirySyntaxErrorMessageProvider.class;
	}
	
	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return EnquiryResourceDescriptionStrategy.class;
	}

	public Class<? extends IResourceServiceProvider> bindIResourceServiceProvider() {
		return CommonDSLResourceServiceProvider.class;
	}

	public Class<? extends ITransientValueService> bindITransientValueService2() {
	    return IntTransientValueService.class;
	}
}
