package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.BuildableContext;
import com.skenvy.fluent.xpath.NodeSetContext;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a node set component.
 */
public class PredicateNodeSetContext extends PredicateBuilder implements BuildableContext {

	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ PredicateNodeSetContext(PredicateBuilder predicateBuilder) {
		super("("+predicateBuilder._buildToString()+")");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}

}
