/*
* generated by Xtext
*/
package com.odcgroup.t24.enquiry.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class EnquiryAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("com/odcgroup/t24/enquiry/parser/antlr/internal/InternalEnquiry.tokens");
	}
}