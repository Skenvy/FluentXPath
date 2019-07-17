package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.BuildableContext;
import com.skenvy.fluent.xpath.XPathAttributeContext;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a number component.
 */
public class PredicateNumberContext extends PredicateBuilder implements BuildableContext {
	
	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ PredicateNumberContext(PredicateBuilder predicateBuilder) {
		super("(number("+predicateBuilder._buildToString()+"))");
	}
	
	/*Package Private*/ PredicateNumberContext(XPathAttributeContext xPathAttributeContext) {
		super("(number("+xPathAttributeContext.buildToString()+"))");
	}
	
	/*Package Private*/ PredicateNumberContext(int number) {
		super("("+number+")");
	}
	
	/*Package Private*/ PredicateNumberContext(long number) {
		super("("+number+")");
	}
	
	/*Package Private*/ PredicateNumberContext(float number) {
		super("("+number+")");
	}
	
	/*Package Private*/ PredicateNumberContext(double number) {
		super("("+number+")");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}
	
	//PredicateNumberContext ceiling(PredicateNumberContext predicateNumberContext)
	
	//PredicateNumberContext floor(PredicateNumberContext predicateNumberContext)
	
	//PredicateNumberContext round(PredicateNumberContext predicateNumberContext)

	//string-length(string)
	
}
