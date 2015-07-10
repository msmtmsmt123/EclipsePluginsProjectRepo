/*
* generated by Xtext
*/
package com.odcgroup.t24.version.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import com.odcgroup.t24.version.services.VersionDSLGrammarAccess;

public class VersionDSLParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private VersionDSLGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected com.odcgroup.t24.version.parser.antlr.internal.InternalVersionDSLParser createParser(XtextTokenStream stream) {
		return new com.odcgroup.t24.version.parser.antlr.internal.InternalVersionDSLParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Version";
	}
	
	public VersionDSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(VersionDSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}