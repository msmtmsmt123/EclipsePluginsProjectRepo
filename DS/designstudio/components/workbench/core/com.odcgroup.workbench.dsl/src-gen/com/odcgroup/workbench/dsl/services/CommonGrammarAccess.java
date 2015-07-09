/*
* generated by Xtext
*/
package com.odcgroup.workbench.dsl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class CommonGrammarAccess extends AbstractGrammarElementFinder {


	public class String_ValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "String_Value");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cVALUETerminalRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);

		//String_Value:
		//	STRING | ID | VALUE;
		public ParserRule getRule() { return rule; }

		//STRING | ID | VALUE
		public Alternatives getAlternatives() { return cAlternatives; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0() { return cSTRINGTerminalRuleCall_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//VALUE
		public RuleCall getVALUETerminalRuleCall_2() { return cVALUETerminalRuleCall_2; }
	}


	private final String_ValueElements pString_Value;
	private final TerminalRule tID;
	private final TerminalRule tVALUE;
	private final TerminalRule tURI;
	private final TerminalRule tSTRING;

	private final Grammar grammar;

	@Inject
	public CommonGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pString_Value = new String_ValueElements();
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID");
		this.tVALUE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "VALUE");
		this.tURI = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "URI");
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "STRING");
	}

	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("com.odcgroup.workbench.dsl.Common".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}


	public Grammar getGrammar() {
		return grammar;
	}



	//String_Value:
	//	STRING | ID | VALUE;
	public String_ValueElements getString_ValueAccess() {
		return pString_Value;
	}

	public ParserRule getString_ValueRule() {
		return getString_ValueAccess().getRule();
	}

	//// Terminal rules
	// terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "-" | "." | "0".."9")*;
	public TerminalRule getIDRule() {
		return tID;
	}

	//terminal VALUE:
	//	("a".."z" | "A".."Z" | "_" | "0".."9" | "&" | "/" | "%" | "." | "-" | "�" | "�" | "�" | "�" | "�" | "�" | "�" | "�" |
	//	"�" | "�" | "�" | "�" | "�" | "�")+;
	public TerminalRule getVALUERule() {
		return tVALUE;
	}

	//terminal URI:
	//	("resource:///" | "platform:/") ("a".."z" | "A".."Z" | "_" | "0".."9" | "&" | "/" | "%" | "." | "-")+;
	public TerminalRule getURIRule() {
		return tURI;
	}

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"";
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	}
}
