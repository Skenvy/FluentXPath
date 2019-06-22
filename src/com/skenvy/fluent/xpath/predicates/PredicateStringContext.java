package com.skenvy.fluent.xpath.predicates;

public class PredicateStringContext  extends PredicateBuilder {
	
	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ PredicateStringContext(PredicateBuilder predicateBuilder) {
		super(predicateBuilder);
	}

}
