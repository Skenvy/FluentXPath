package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.BuildableContext;

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
	
	private PredicateNodeSetContext(CharSequence chars) {
		super(chars);
	}
	
	/*Package Private*/ PredicateNodeSetContext(PredicateBuilder predicateBuilder) {
		super("("+predicateBuilder._buildToString()+")");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}
	
	//?:comment() | Can be evaluated as a node(set)
	/*Package Private*/ PredicateNodeSetContext comment() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("comment()");
		return pnsc;
	}
	
	//?:node() | Can be evaluated as a node(set)
	/*Package Private*/ PredicateNodeSetContext node() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("node()");
		return pnsc;
	}
	
	//?:processing-instruction() | Can be evaluated as a node(set)
	/*Package Private*/ PredicateNodeSetContext processingInstruction() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("processing-instruction()");
		return pnsc;
	}
	
	//?:text() | Can be evaluated as a node(set) | Contained in PredicateStringContext
	
	//?:name() | Can NOT be evaluated as a node(set)
	/*Package Private*/ PredicateNodeSetContext name() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("name()");
		return pnsc;
	}
	
	//?:position()
	/*Package Private*/ PredicateNodeSetContext position() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("position()");
		return pnsc;
	}
	
	//?:last()
	/*Package Private*/ PredicateNodeSetContext last() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("last()");
		return pnsc;
	}

}
