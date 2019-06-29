package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.BuildableContext;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a boolean component.
 */
public final class PredicateBooleanContext extends PredicateBuilder implements BuildableContext {

	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	
	private PredicateBooleanContext(CharSequence chars) {
		super(chars);
	}
	
	/*Package Private*/ PredicateBooleanContext(PredicateBuilder predicateBuilder) {
		super("(boolean("+predicateBuilder._buildToString()+"))");
	}
	
	public static PredicateBooleanContext TRUE() {
		return new PredicateBooleanContext("(true)");
	}
	
	public static PredicateBooleanContext FALSE() {
		return new PredicateBooleanContext("(false)");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}
	
}
