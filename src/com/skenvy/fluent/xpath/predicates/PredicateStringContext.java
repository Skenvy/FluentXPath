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
	
	//substring(string, offset, length?)
	
	//substring-before(string1, string2)
	
	//substring-after(string1, string2)
	
	//normalize-space(string)
	
	//translate(string1, string2, string3)
	
	//concat(string1, string2, ...)
	
	//format-number(number1, string1, string2)

}
