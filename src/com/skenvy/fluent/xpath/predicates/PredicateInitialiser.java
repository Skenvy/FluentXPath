package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.xpath.contextualisers.XPathAttributeContextualisers;
import com.skenvy.fluent.xpath.contextualisers.XPathNodeContextualisers;

/***
 * The builder's "initialiser" used to initialise the XPath builder with any of
 * a number of appropriate ways to start an XPath, used to start "predicate
 * paths" inside of predicates, used to wrap sets of internal predicates in 
 * boolean expression syntax, and generate predicates themselves.
 */
public class PredicateInitialiser extends PredicateBuilder {
	
	/***
	 * Create a new PredicateBuilder
	 */
	private PredicateInitialiser() {
		super();
	}
	
	/***
	 * Create a new PredicateBuilder with initial characters
	 */
	private PredicateInitialiser(CharSequence chars) {
		super(chars);
	}
	
	/***
	 * Returns a new instance of this initialiser class, invoked with the no
	 * argument constructor
	 * @return PredicateInitialiser
	 */
	private static PredicateInitialiser initialiseBuilder() {
		return (new PredicateInitialiser());
	}

	/***
	 * Returns a new instance of this initialiser class, invoked with the
	 * CharSequence constructor
	 * @return PredicateInitialiser
	 */
	private static PredicateInitialiser initialiseBuilder(CharSequence chars) {
		return (new PredicateInitialiser(chars));
	}
	
//	/***
//	 * 
//	 * @return <*>
//	 */
//	public static Predicate<*>Context from<#>() {
//		return initialiseBuilder().swapTo<*>Context();
//	}
	
}
