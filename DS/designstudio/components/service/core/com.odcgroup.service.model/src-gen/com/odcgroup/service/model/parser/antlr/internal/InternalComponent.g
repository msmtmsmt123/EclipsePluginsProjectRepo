/*
* generated by Xtext
*/
grammar InternalComponent;

options {
	superClass=AbstractInternalAntlrParser;

}

@lexer::header {
package com.odcgroup.service.model.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import.
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package com.odcgroup.service.model.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.odcgroup.service.model.services.ComponentGrammarAccess;

}

@parser::members {

	private ComponentGrammarAccess grammarAccess;

    public InternalComponentParser(TokenStream input, ComponentGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
	return "Component";
	}

	@Override
	protected ComponentGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}
}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}




// Entry rule entryRuleComponent
entryRuleComponent returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getComponentRule()); }
	 iv_ruleComponent=ruleComponent
	 { $current=$iv_ruleComponent.current; }
	 EOF
;

// Rule Component
ruleComponent returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getComponentAccess().getDocumentationDocumentationParserRuleCall_0_0());
	    }
		lv_documentation_0_0=ruleDocumentation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentRule());
	        }
		set(
			$current,
			"documentation",
			lv_documentation_0_0,
			"Documentation");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_1='component'
    {
	newLeafNode(otherlv_1, grammarAccess.getComponentAccess().getComponentKeyword_1());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getComponentAccess().getNameIDTerminalRuleCall_2_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getComponentRule());
	        }
		setWithLastConsumed(
			$current,
			"name",
			lv_name_2_0,
			"ID");
	    }

)
)	otherlv_3='metamodelVersion'
    {
	newLeafNode(otherlv_3, grammarAccess.getComponentAccess().getMetamodelVersionKeyword_3());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getComponentAccess().getMetamodelVersionString_ValueParserRuleCall_4_0());
	    }
		lv_metamodelVersion_4_0=ruleString_Value		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentRule());
	        }
		set(
			$current,
			"metamodelVersion",
			lv_metamodelVersion_4_0,
			"String_Value");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getComponentAccess().getContentContentParserRuleCall_5_0());
	    }
		lv_content_5_0=ruleContent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentRule());
	        }
		add(
			$current,
			"content",
			lv_content_5_0,
			"Content");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleContent
entryRuleContent returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getContentRule()); }
	 iv_ruleContent=ruleContent
	 { $current=$iv_ruleContent.current; }
	 EOF
;

// Rule Content
ruleContent returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getContentAccess().getInterfaceInterfaceParserRuleCall_0_0());
	    }
		lv_interface_0_0=ruleInterface		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContentRule());
	        }
		set(
			$current,
			"interface",
			lv_interface_0_0,
			"Interface");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getContentAccess().getMethodMethodParserRuleCall_1_0());
	    }
		lv_method_1_0=ruleMethod		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContentRule());
	        }
		add(
			$current,
			"method",
			lv_method_1_0,
			"Method");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getContentAccess().getPropertyPropertyParserRuleCall_2_0());
	    }
		lv_property_2_0=ruleProperty		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContentRule());
	        }
		add(
			$current,
			"property",
			lv_property_2_0,
			"Property");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getContentAccess().getConstantConstantParserRuleCall_3_0());
	    }
		lv_constant_3_0=ruleConstant		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContentRule());
	        }
		add(
			$current,
			"constant",
			lv_constant_3_0,
			"Constant");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{
	        newCompositeNode(grammarAccess.getContentAccess().getTableTableParserRuleCall_4_0());
	    }
		lv_table_4_0=ruleTable		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getContentRule());
	        }
		add(
			$current,
			"table",
			lv_table_4_0,
			"Table");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleTable
entryRuleTable returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getTableRule()); }
	 iv_ruleTable=ruleTable
	 { $current=$iv_ruleTable.current; }
	 EOF
;

// Rule Table
ruleTable returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getTableAccess().getDocumentationDocumentationParserRuleCall_0_0());
	    }
		lv_documentation_0_0=ruleDocumentation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
		set(
			$current,
			"documentation",
			lv_documentation_0_0,
			"Documentation");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
	        newCompositeNode(grammarAccess.getTableAccess().getAccessSpecifierAccessSpecifierEnumRuleCall_1_0());
	    }
		lv_accessSpecifier_1_0=ruleAccessSpecifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
		set(
			$current,
			"accessSpecifier",
			lv_accessSpecifier_1_0,
			"AccessSpecifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='table'
    {
	newLeafNode(otherlv_2, grammarAccess.getTableAccess().getTableKeyword_2());
    }
(
(
		lv_tableName_3_0=RULE_ID
		{
			newLeafNode(lv_tableName_3_0, grammarAccess.getTableAccess().getTableNameIDTerminalRuleCall_3_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTableRule());
	        }
		setWithLastConsumed(
			$current,
			"tableName",
			lv_tableName_3_0,
			"ID");
	    }

)
)	otherlv_4='{'
    {
	newLeafNode(otherlv_4, grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_4());
    }
	otherlv_5='t24:'
    {
	newLeafNode(otherlv_5, grammarAccess.getTableAccess().getT24Keyword_5());
    }
(
(
		lv_type_6_0=RULE_ID
		{
			newLeafNode(lv_type_6_0, grammarAccess.getTableAccess().getTypeIDTerminalRuleCall_6_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTableRule());
	        }
		setWithLastConsumed(
			$current,
			"type",
			lv_type_6_0,
			"ID");
	    }

)
)(	otherlv_7='fields:'
    {
	newLeafNode(otherlv_7, grammarAccess.getTableAccess().getFieldsKeyword_7_0());
    }
	otherlv_8='{'
    {
	newLeafNode(otherlv_8, grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_7_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getTableAccess().getAttributeAttributeParserRuleCall_7_2_0());
	    }
		lv_attribute_9_0=ruleAttribute		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTableRule());
	        }
		add(
			$current,
			"attribute",
			lv_attribute_9_0,
			"Attribute");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_10='}'
    {
	newLeafNode(otherlv_10, grammarAccess.getTableAccess().getRightCurlyBracketKeyword_7_3());
    }
)?	otherlv_11='}'
    {
	newLeafNode(otherlv_11, grammarAccess.getTableAccess().getRightCurlyBracketKeyword_8());
    }
)
;





// Entry rule entryRuleConstant
entryRuleConstant returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getConstantRule()); }
	 iv_ruleConstant=ruleConstant
	 { $current=$iv_ruleConstant.current; }
	 EOF
;

// Rule Constant
ruleConstant returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getConstantAccess().getDocumentationDocumentationParserRuleCall_0_0());
	    }
		lv_documentation_0_0=ruleDocumentation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConstantRule());
	        }
		set(
			$current,
			"documentation",
			lv_documentation_0_0,
			"Documentation");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
	        newCompositeNode(grammarAccess.getConstantAccess().getAccessSpecifierAccessSpecifierEnumRuleCall_1_0());
	    }
		lv_accessSpecifier_1_0=ruleAccessSpecifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConstantRule());
	        }
		set(
			$current,
			"accessSpecifier",
			lv_accessSpecifier_1_0,
			"AccessSpecifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='constant'
    {
	newLeafNode(otherlv_2, grammarAccess.getConstantAccess().getConstantKeyword_2());
    }
(
(
		lv_constantName_3_0=RULE_ID
		{
			newLeafNode(lv_constantName_3_0, grammarAccess.getConstantAccess().getConstantNameIDTerminalRuleCall_3_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConstantRule());
	        }
		setWithLastConsumed(
			$current,
			"constantName",
			lv_constantName_3_0,
			"ID");
	    }

)
)(	otherlv_4='('
    {
	newLeafNode(otherlv_4, grammarAccess.getConstantAccess().getLeftParenthesisKeyword_4_0());
    }
(
(
		lv_jBCName_5_0=RULE_ID
		{
			newLeafNode(lv_jBCName_5_0, grammarAccess.getConstantAccess().getJBCNameIDTerminalRuleCall_4_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConstantRule());
	        }
		setWithLastConsumed(
			$current,
			"jBCName",
			lv_jBCName_5_0,
			"ID");
	    }

)
)	otherlv_6=')'
    {
	newLeafNode(otherlv_6, grammarAccess.getConstantAccess().getRightParenthesisKeyword_4_2());
    }
)?	otherlv_7='='
    {
	newLeafNode(otherlv_7, grammarAccess.getConstantAccess().getEqualsSignKeyword_5());
    }
(
(
		lv_value_8_0=RULE_INT
		{
			newLeafNode(lv_value_8_0, grammarAccess.getConstantAccess().getValueINTTerminalRuleCall_6_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConstantRule());
	        }
		setWithLastConsumed(
			$current,
			"value",
			lv_value_8_0,
			"INT");
	    }

)
))
;





// Entry rule entryRuleProperty
entryRuleProperty returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getPropertyRule()); }
	 iv_ruleProperty=ruleProperty
	 { $current=$iv_ruleProperty.current; }
	 EOF
;

// Rule Property
ruleProperty returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getPropertyAccess().getDocumentationDocumentationParserRuleCall_0_0());
	    }
		lv_documentation_0_0=ruleDocumentation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPropertyRule());
	        }
		set(
			$current,
			"documentation",
			lv_documentation_0_0,
			"Documentation");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
	        newCompositeNode(grammarAccess.getPropertyAccess().getAccessSpecifierAccessSpecifierEnumRuleCall_1_0());
	    }
		lv_accessSpecifier_1_0=ruleAccessSpecifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPropertyRule());
	        }
		set(
			$current,
			"accessSpecifier",
			lv_accessSpecifier_1_0,
			"AccessSpecifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='property'
    {
	newLeafNode(otherlv_2, grammarAccess.getPropertyAccess().getPropertyKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPropertyAccess().getReadOnlyReadWriteEnumRuleCall_3_0());
	    }
		lv_readOnly_3_0=ruleReadWrite		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPropertyRule());
	        }
		set(
			$current,
			"readOnly",
			lv_readOnly_3_0,
			"ReadWrite");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_propertyName_4_0=RULE_ID
		{
			newLeafNode(lv_propertyName_4_0, grammarAccess.getPropertyAccess().getPropertyNameIDTerminalRuleCall_4_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPropertyRule());
	        }
		setWithLastConsumed(
			$current,
			"propertyName",
			lv_propertyName_4_0,
			"ID");
	    }

)
)	otherlv_5=': string'
    {
	newLeafNode(otherlv_5, grammarAccess.getPropertyAccess().getStringKeyword_5());
    }
	otherlv_6='{'
    {
	newLeafNode(otherlv_6, grammarAccess.getPropertyAccess().getLeftCurlyBracketKeyword_6());
    }
	otherlv_7='jBC:'
    {
	newLeafNode(otherlv_7, grammarAccess.getPropertyAccess().getJBCKeyword_7());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPropertyAccess().getType1JBC_IDParserRuleCall_8_0());
	    }
		lv_type1_8_0=ruleJBC_ID		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPropertyRule());
	        }
		set(
			$current,
			"type1",
			lv_type1_8_0,
			"JBC_ID");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_9='->'
    {
	newLeafNode(otherlv_9, grammarAccess.getPropertyAccess().getHyphenMinusGreaterThanSignKeyword_9());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getPropertyAccess().getType2JBC_IDParserRuleCall_10_0());
	    }
		lv_type2_10_0=ruleJBC_ID		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPropertyRule());
	        }
		set(
			$current,
			"type2",
			lv_type2_10_0,
			"JBC_ID");
	        afterParserOrEnumRuleCall();
	    }

)
)((
(
		lv_array_11_0=	'('
    {
        newLeafNode(lv_array_11_0, grammarAccess.getPropertyAccess().getArrayLeftParenthesisKeyword_11_0_0());
    }

	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPropertyRule());
	        }
		setWithLastConsumed($current, "array", true, "(");
	    }

)
)(
(
		lv_value_12_0=RULE_INT
		{
			newLeafNode(lv_value_12_0, grammarAccess.getPropertyAccess().getValueINTTerminalRuleCall_11_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPropertyRule());
	        }
		setWithLastConsumed(
			$current,
			"value",
			lv_value_12_0,
			"INT");
	    }

)
)?	otherlv_13=')'
    {
	newLeafNode(otherlv_13, grammarAccess.getPropertyAccess().getRightParenthesisKeyword_11_2());
    }
)?	otherlv_14='}'
    {
	newLeafNode(otherlv_14, grammarAccess.getPropertyAccess().getRightCurlyBracketKeyword_12());
    }
)
;





// Entry rule entryRuleMethod
entryRuleMethod returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMethodRule()); }
	 iv_ruleMethod=ruleMethod
	 { $current=$iv_ruleMethod.current; }
	 EOF
;

// Rule Method
ruleMethod returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getMethodAccess().getDocumentationDocumentationParserRuleCall_0_0());
	    }
		lv_documentation_0_0=ruleDocumentation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodRule());
	        }
		set(
			$current,
			"documentation",
			lv_documentation_0_0,
			"Documentation");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
	        newCompositeNode(grammarAccess.getMethodAccess().getAccessSpecifierMethodAccessSpecifierEnumRuleCall_1_0());
	    }
		lv_accessSpecifier_1_0=ruleMethodAccessSpecifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodRule());
	        }
		set(
			$current,
			"accessSpecifier",
			lv_accessSpecifier_1_0,
			"MethodAccessSpecifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='method'
    {
	newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getMethodKeyword_2());
    }
(
(
		lv_name_3_0=RULE_ID
		{
			newLeafNode(lv_name_3_0, grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_3_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMethodRule());
	        }
		setWithLastConsumed(
			$current,
			"name",
			lv_name_3_0,
			"ID");
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getMethodAccess().getAnnotationsMethodAnnotationParserRuleCall_4_0());
	    }
		lv_annotations_4_0=ruleMethodAnnotation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodRule());
	        }
		add(
			$current,
			"annotations",
			lv_annotations_4_0,
			"MethodAnnotation");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_5='('
    {
	newLeafNode(otherlv_5, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_5());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getMethodAccess().getArgumentsArgumentParserRuleCall_6_0_0());
	    }
		lv_arguments_6_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodRule());
	        }
		add(
			$current,
			"arguments",
			lv_arguments_6_0,
			"Argument");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_7=','
    {
	newLeafNode(otherlv_7, grammarAccess.getMethodAccess().getCommaKeyword_6_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getMethodAccess().getArgumentsArgumentParserRuleCall_6_1_1_0());
	    }
		lv_arguments_8_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodRule());
	        }
		add(
			$current,
			"arguments",
			lv_arguments_8_0,
			"Argument");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_9=')'
    {
	newLeafNode(otherlv_9, grammarAccess.getMethodAccess().getRightParenthesisKeyword_7());
    }
(	otherlv_10='{'
    {
	newLeafNode(otherlv_10, grammarAccess.getMethodAccess().getLeftCurlyBracketKeyword_8_0());
    }
	otherlv_11='jBC:'
    {
	newLeafNode(otherlv_11, grammarAccess.getMethodAccess().getJBCKeyword_8_1());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getMethodAccess().getTypeJBC_IDParserRuleCall_8_2_0());
	    }
		lv_type_12_0=ruleJBC_ID		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodRule());
	        }
		set(
			$current,
			"type",
			lv_type_12_0,
			"JBC_ID");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_13='}'
    {
	newLeafNode(otherlv_13, grammarAccess.getMethodAccess().getRightCurlyBracketKeyword_8_3());
    }
)?)
;





// Entry rule entryRuleInterface
entryRuleInterface returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getInterfaceRule()); }
	 iv_ruleInterface=ruleInterface
	 { $current=$iv_ruleInterface.current; }
	 EOF
;

// Rule Interface
ruleInterface returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getInterfaceAccess().getDocumentationDocumentationParserRuleCall_0_0());
	    }
		lv_documentation_0_0=ruleDocumentation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInterfaceRule());
	        }
		set(
			$current,
			"documentation",
			lv_documentation_0_0,
			"Documentation");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
	        newCompositeNode(grammarAccess.getInterfaceAccess().getAccessSpecifierAccessSpecifierEnumRuleCall_1_0());
	    }
		lv_accessSpecifier_1_0=ruleAccessSpecifier		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInterfaceRule());
	        }
		set(
			$current,
			"accessSpecifier",
			lv_accessSpecifier_1_0,
			"AccessSpecifier");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='interface'
    {
	newLeafNode(otherlv_2, grammarAccess.getInterfaceAccess().getInterfaceKeyword_2());
    }
(
(
		lv_name_3_0=RULE_ID
		{
			newLeafNode(lv_name_3_0, grammarAccess.getInterfaceAccess().getNameIDTerminalRuleCall_3_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getInterfaceRule());
	        }
		setWithLastConsumed(
			$current,
			"name",
			lv_name_3_0,
			"ID");
	    }

)
)	otherlv_4='('
    {
	newLeafNode(otherlv_4, grammarAccess.getInterfaceAccess().getLeftParenthesisKeyword_4());
    }
((
(
		{
	        newCompositeNode(grammarAccess.getInterfaceAccess().getArgumentsArgumentParserRuleCall_5_0_0());
	    }
		lv_arguments_5_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInterfaceRule());
	        }
		add(
			$current,
			"arguments",
			lv_arguments_5_0,
			"Argument");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_6=','
    {
	newLeafNode(otherlv_6, grammarAccess.getInterfaceAccess().getCommaKeyword_5_1_0());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getInterfaceAccess().getArgumentsArgumentParserRuleCall_5_1_1_0());
	    }
		lv_arguments_7_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getInterfaceRule());
	        }
		add(
			$current,
			"arguments",
			lv_arguments_7_0,
			"Argument");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_8=')'
    {
	newLeafNode(otherlv_8, grammarAccess.getInterfaceAccess().getRightParenthesisKeyword_6());
    }
)
;





// Entry rule entryRuleAttribute
entryRuleAttribute returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getAttributeRule()); }
	 iv_ruleAttribute=ruleAttribute
	 { $current=$iv_ruleAttribute.current; }
	 EOF
;

// Rule Attribute
ruleAttribute returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		lv_attrName_0_0=RULE_ID
		{
			newLeafNode(lv_attrName_0_0, grammarAccess.getAttributeAccess().getAttrNameIDTerminalRuleCall_0_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAttributeRule());
	        }
		setWithLastConsumed(
			$current,
			"attrName",
			lv_attrName_0_0,
			"ID");
	    }

)
)(	otherlv_1='('
    {
	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		lv_jBCName_2_0=RULE_ID
		{
			newLeafNode(lv_jBCName_2_0, grammarAccess.getAttributeAccess().getJBCNameIDTerminalRuleCall_1_1_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAttributeRule());
	        }
		setWithLastConsumed(
			$current,
			"jBCName",
			lv_jBCName_2_0,
			"ID");
	    }

)
)	otherlv_3=')'
    {
	newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getRightParenthesisKeyword_1_2());
    }
)?	otherlv_4='='
    {
	newLeafNode(otherlv_4, grammarAccess.getAttributeAccess().getEqualsSignKeyword_2());
    }
(
(
		lv_value_5_0=RULE_INT
		{
			newLeafNode(lv_value_5_0, grammarAccess.getAttributeAccess().getValueINTTerminalRuleCall_3_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAttributeRule());
	        }
		setWithLastConsumed(
			$current,
			"value",
			lv_value_5_0,
			"INT");
	    }

)
))
;





// Entry rule entryRuleArgument
entryRuleArgument returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getArgumentRule()); }
	 iv_ruleArgument=ruleArgument
	 { $current=$iv_ruleArgument.current; }
	 EOF
;

// Rule Argument
ruleArgument returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
((
(
		{
	        newCompositeNode(grammarAccess.getArgumentAccess().getDocumentationDocumentationParserRuleCall_0_0());
	    }
		lv_documentation_0_0=ruleDocumentation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
		set(
			$current,
			"documentation",
			lv_documentation_0_0,
			"Documentation");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{
	        newCompositeNode(grammarAccess.getArgumentAccess().getInoutInOutTypeEnumRuleCall_1_0());
	    }
		lv_inout_1_0=ruleInOutType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
		set(
			$current,
			"inout",
			lv_inout_1_0,
			"InOutType");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_2_0());
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getArgumentRule());
	        }
		setWithLastConsumed(
			$current,
			"name",
			lv_name_2_0,
			"ID");
	    }

)
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getArgumentRule());
	        }
        }
		{
	        newCompositeNode(grammarAccess.getArgumentAccess().getTypeMdfEntityCrossReference_3_0());
	    }
		ruleEntityRef		{
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{
	        newCompositeNode(grammarAccess.getArgumentAccess().getMultiplicityMultiplicityEnumRuleCall_4_0());
	    }
		lv_multiplicity_4_0=ruleMultiplicity		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getArgumentRule());
	        }
		set(
			$current,
			"multiplicity",
			lv_multiplicity_4_0,
			"Multiplicity");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleDocumentation
entryRuleDocumentation returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getDocumentationRule()); }
	 iv_ruleDocumentation=ruleDocumentation
	 { $current=$iv_ruleDocumentation.current.getText(); }
	 EOF
;

// Rule Documentation
ruleDocumentation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
    this_ML_DOC_0=RULE_ML_DOC    {
		$current.merge(this_ML_DOC_0);
    }

    {
    newLeafNode(this_ML_DOC_0, grammarAccess.getDocumentationAccess().getML_DOCTerminalRuleCall());
    }

    ;





// Entry rule entryRuleMethodAnnotation
entryRuleMethodAnnotation returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getMethodAnnotationRule()); }
	 iv_ruleMethodAnnotation=ruleMethodAnnotation
	 { $current=$iv_ruleMethodAnnotation.current; }
	 EOF
;

// Rule MethodAnnotation
ruleMethodAnnotation returns [EObject current=null]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(	otherlv_0='@'
    {
	newLeafNode(otherlv_0, grammarAccess.getMethodAnnotationAccess().getCommercialAtKeyword_0());
    }
	otherlv_1='t24'
    {
	newLeafNode(otherlv_1, grammarAccess.getMethodAnnotationAccess().getT24Keyword_1());
    }
	otherlv_2=':'
    {
	newLeafNode(otherlv_2, grammarAccess.getMethodAnnotationAccess().getColonKeyword_2());
    }
(
(
		{
	        newCompositeNode(grammarAccess.getMethodAnnotationAccess().getNameT24MethodStereotypeEnumRuleCall_3_0());
	    }
		lv_name_3_0=ruleT24MethodStereotype		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMethodAnnotationRule());
	        }
		set(
			$current,
			"name",
			lv_name_3_0,
			"T24MethodStereotype");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleEntityRef
entryRuleEntityRef returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getEntityRefRule()); }
	 iv_ruleEntityRef=ruleEntityRef
	 { $current=$iv_ruleEntityRef.current.getText(); }
	 EOF
;

// Rule EntityRef
ruleEntityRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    {
    newLeafNode(this_ID_0, grammarAccess.getEntityRefAccess().getIDTerminalRuleCall_0());
    }
(
	kw=':'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEntityRefAccess().getColonKeyword_1_0());
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    {
    newLeafNode(this_ID_2, grammarAccess.getEntityRefAccess().getIDTerminalRuleCall_1_1());
    }
)?)
    ;





// Entry rule entryRuleJBC_ID
entryRuleJBC_ID returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getJBC_IDRule()); }
	 iv_ruleJBC_ID=ruleJBC_ID
	 { $current=$iv_ruleJBC_ID.current.getText(); }
	 EOF
;

// Rule JBC_ID
ruleJBC_ID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    {
    newLeafNode(this_ID_0, grammarAccess.getJBC_IDAccess().getIDTerminalRuleCall_0());
    }
(
	kw='$'
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getJBC_IDAccess().getDollarSignKeyword_1_0());
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    {
    newLeafNode(this_ID_2, grammarAccess.getJBC_IDAccess().getIDTerminalRuleCall_1_1());
    }
)*)
    ;





// Entry rule entryRuleString_Value
entryRuleString_Value returns [String current=null]
	:
	{ newCompositeNode(grammarAccess.getString_ValueRule()); }
	 iv_ruleString_Value=ruleString_Value
	 { $current=$iv_ruleString_Value.current.getText(); }
	 EOF
;

// Rule String_Value
ruleString_Value returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
    @init { enterRule();
    }
    @after { leaveRule(); }:
(    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    {
    newLeafNode(this_STRING_0, grammarAccess.getString_ValueAccess().getSTRINGTerminalRuleCall_0());
    }

    |    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    {
    newLeafNode(this_ID_1, grammarAccess.getString_ValueAccess().getIDTerminalRuleCall_1());
    }

    |    this_VALUE_2=RULE_VALUE    {
		$current.merge(this_VALUE_2);
    }

    {
    newLeafNode(this_VALUE_2, grammarAccess.getString_ValueAccess().getVALUETerminalRuleCall_2());
    }
)
    ;





// Rule T24MethodStereotype
ruleT24MethodStereotype returns [Enumerator current=null]
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='integrationFlowSupportable'
	{
        $current = grammarAccess.getT24MethodStereotypeAccess().getIntegrationFlowSupportableEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getT24MethodStereotypeAccess().getIntegrationFlowSupportableEnumLiteralDeclaration_0());
    }
)
    |(	enumLiteral_1='unsafe'
	{
        $current = grammarAccess.getT24MethodStereotypeAccess().getUnsafeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getT24MethodStereotypeAccess().getUnsafeEnumLiteralDeclaration_1());
    }
)
    |(	enumLiteral_2='idempotent'
	{
        $current = grammarAccess.getT24MethodStereotypeAccess().getIdempotentEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getT24MethodStereotypeAccess().getIdempotentEnumLiteralDeclaration_2());
    }
));



// Rule ReadWrite
ruleReadWrite returns [Enumerator current=null]
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='readonly'
	{
        $current = grammarAccess.getReadWriteAccess().getReadonlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getReadWriteAccess().getReadonlyEnumLiteralDeclaration_0());
    }
)
    |(	enumLiteral_1='readwrite'
	{
        $current = grammarAccess.getReadWriteAccess().getReadwriteEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getReadWriteAccess().getReadwriteEnumLiteralDeclaration_1());
    }
));



// Rule AccessSpecifier
ruleAccessSpecifier returns [Enumerator current=null]
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='module'
	{
        $current = grammarAccess.getAccessSpecifierAccess().getModuleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getAccessSpecifierAccess().getModuleEnumLiteralDeclaration_0());
    }
)
    |(	enumLiteral_1='private'
	{
        $current = grammarAccess.getAccessSpecifierAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getAccessSpecifierAccess().getPrivateEnumLiteralDeclaration_1());
    }
)
    |(	enumLiteral_2='public'
	{
        $current = grammarAccess.getAccessSpecifierAccess().getPublicEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getAccessSpecifierAccess().getPublicEnumLiteralDeclaration_2());
    }
));



// Rule MethodAccessSpecifier
ruleMethodAccessSpecifier returns [Enumerator current=null]
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='module'
	{
        $current = grammarAccess.getMethodAccessSpecifierAccess().getModuleEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getMethodAccessSpecifierAccess().getModuleEnumLiteralDeclaration_0());
    }
)
    |(	enumLiteral_1='private'
	{
        $current = grammarAccess.getMethodAccessSpecifierAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getMethodAccessSpecifierAccess().getPrivateEnumLiteralDeclaration_1());
    }
)
    |(	enumLiteral_2='public'
	{
        $current = grammarAccess.getMethodAccessSpecifierAccess().getPublicEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getMethodAccessSpecifierAccess().getPublicEnumLiteralDeclaration_2());
    }
)
    |(	enumLiteral_3='external'
	{
        $current = grammarAccess.getMethodAccessSpecifierAccess().getExternalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getMethodAccessSpecifierAccess().getExternalEnumLiteralDeclaration_3());
    }
));



// Rule InOutType
ruleInOutType returns [Enumerator current=null]
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='IN'
	{
        $current = grammarAccess.getInOutTypeAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getInOutTypeAccess().getINEnumLiteralDeclaration_0());
    }
)
    |(	enumLiteral_1='OUT'
	{
        $current = grammarAccess.getInOutTypeAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getInOutTypeAccess().getOUTEnumLiteralDeclaration_1());
    }
)
    |(	enumLiteral_2='INOUT'
	{
        $current = grammarAccess.getInOutTypeAccess().getINOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getInOutTypeAccess().getINOUTEnumLiteralDeclaration_2());
    }
));



// Rule Multiplicity
ruleMultiplicity returns [Enumerator current=null]
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='[0..1]'
	{
        $current = grammarAccess.getMultiplicityAccess().getOPTIONALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getMultiplicityAccess().getOPTIONALEnumLiteralDeclaration_0());
    }
)
    |(	enumLiteral_1='[0..*]'
	{
        $current = grammarAccess.getMultiplicityAccess().getMANYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getMultiplicityAccess().getMANYEnumLiteralDeclaration_1());
    }
)
    |(	enumLiteral_2='[1..1]'
	{
        $current = grammarAccess.getMultiplicityAccess().getMANDATORYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getMultiplicityAccess().getMANDATORYEnumLiteralDeclaration_2());
    }
)
    |(	enumLiteral_3='[1..*]'
	{
        $current = grammarAccess.getMultiplicityAccess().getONETOMANYEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getMultiplicityAccess().getONETOMANYEnumLiteralDeclaration_3());
    }
));



RULE_ML_DOC : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : ('#'|'*') ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_INT : ('0'..'9')+;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'-'|'.'|'0'..'9')*;

RULE_VALUE : ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'&'|'/'|'%'|'.'|'-'|'\u00E9'|'\u00E8'|'\u00E0'|'\u00E4'|'\u00F6'|'\u00FC'|'\u00C4'|'\u00D6'|'\u00DC'|'\u00C9'|'\u00C8'|'\u00C0'|'\u00E7'|'\u00DF')+;

RULE_URI : ('resource:///'|'platform:/') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'&'|'/'|'%'|'.'|'-')+;

RULE_STRING : '"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"';