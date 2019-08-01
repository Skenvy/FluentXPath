package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.BuildableContext;
import com.skenvy.fluent.xpath.XPathAttributeContext;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a string component.
 */
public class PredicateStringContext  extends PredicateBuilder implements BuildableContext {
	
	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	
	/*Package Private*/ PredicateStringContext(PredicateBuilder predicateBuilder) {
		super("(string("+predicateBuilder._buildToString()+"))");
	}
	
	/*Package Private*/ PredicateStringContext(XPathAttributeContext xPathAttributeContext) {
		super("(string("+xPathAttributeContext.buildToString()+"))");
	}
	
	/*Package Private*/ PredicateStringContext(String words) {
		super("(\""+words+"\")");
	}
	
	//?:text() | Can be evaluated as a node(set) | Per W3C, defined under node set functions
	/*Package Private*/ static PredicateStringContext TEXT() {
		return new PredicateStringContext("text()");
	}
	
	/*Package Private*/ static PredicateStringContext DOT() {
		return new PredicateStringContext(".");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}
	
	//substring(string, offset)
	/*Package Private*/ static PredicateStringContext substring(PredicateStringContext stringToSearchIn, PredicateNumberContext offsetValue) {
		PredicateStringContext psc = new PredicateStringContext("substring(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(offsetValue);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	//substring(string, offset, length)
	/*Package Private*/ static PredicateStringContext substring(PredicateStringContext stringToSearchIn, PredicateNumberContext offsetValue, PredicateNumberContext lengthValue) {
		PredicateStringContext psc = new PredicateStringContext("substring(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(offsetValue);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(lengthValue);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	
	//substring-before(string1, string2)
	//$x("substring-before(\"abcdefg\",\"c\")") = "ab"
	/*Package Private*/ static PredicateStringContext substringBefore(PredicateStringContext stringToSearchIn, PredicateStringContext stringToSearchFor) {
		PredicateStringContext psc = new PredicateStringContext("substring-before(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(stringToSearchFor);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	//substring-after(string1, string2)
	//$x("substring-after(\"abcdefg\",\"c\")") = "defg"
	/*Package Private*/ static PredicateStringContext substringAfter(PredicateStringContext stringToSearchIn, PredicateStringContext stringToSearchFor) {
		PredicateStringContext psc = new PredicateStringContext("substring-after(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(stringToSearchFor);
		psc.appendStringBuilder(")");
		return psc;
	}
		
	//normalize-space(string)
	/*Package Private*/ static PredicateStringContext normalizeSpace(PredicateStringContext stringToNormalize) {
		PredicateStringContext psc = new PredicateStringContext("normalize-space(");
		psc.appendStringBuilder(stringToNormalize);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	//translate(string1, string2, string3)
	//$x("translate(\"abcdefg\",\"cg\",\"jk\")") = "abjdefk"
	/*Package Private*/ static PredicateStringContext translate(PredicateStringContext stringToSearchIn, PredicateStringContext stringToSearchForMapFrom, PredicateStringContext stringToSearchForMapTo) {
		PredicateStringContext psc = new PredicateStringContext("translate(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(stringToSearchForMapFrom);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(stringToSearchForMapTo);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	//concat(string1, string2, ...)
	/*Package Private*/ static PredicateStringContext concat(PredicateStringContext string1, PredicateStringContext string2, PredicateStringContext... stringNs) {
		PredicateStringContext psc = new PredicateStringContext("concat(");
		psc.appendStringBuilder(string1);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(string2);
		for(PredicateStringContext stringN : stringNs) {
			psc.appendStringBuilder(",");
			psc.appendStringBuilder(stringN);
		}
		psc.appendStringBuilder(")");
		return psc;
	}
	
	//format-number(number1, string1, string2) XSLT unfortunately!
	
}
