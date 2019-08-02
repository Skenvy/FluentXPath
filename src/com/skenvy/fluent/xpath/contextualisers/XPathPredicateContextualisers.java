package com.skenvy.fluent.xpath.contextualisers;

import com.skenvy.fluent.xpath.XPathPredicateContext;
import com.skenvy.fluent.xpath.predicates.BuildablePredicate;

/***
 * A collection of methods that will either result in an XPathPredicateContext,
 * or whose operation's first context swap will be to that of the predicate 
 * context before fast-forwarding to a later context
 */
public interface XPathPredicateContextualisers {
	
	/* Predicates are composed of [ ], containing (A and B), (C or D), not(E), 
	 * F, where ABCDEF are either "node sets" produced as the result of 
	 * constructing an XPathBuilder through to a node, predicate, or attribute, 
	 * or the utilisation of a predicate function such as = or contains etc.
	 * PredicateContextualisers can add the results of combining these.
	 */
	
	/***
	 * Allows for the allocation of any generic predicate built using the
	 * PredicateBuilder class/subclasses.
	 * @param predicate
	 * @return
	 */
	XPathPredicateContext withCustomPredicate(BuildablePredicate predicate);
	
	//TODO: build a list of common predicate conditions that can be invoked immediately and without complication, taking only strings.
	
	//[@something="something"] //@id, @name, @class are very common
	
	//[contains(text(),"something")]
	
	//[text()="something"]
	
	//TODO: make it possible to invoke xpath functions, where the functions take XPathBuilder's contexts (buildable, or attribute specifically)
	
	//TODO: make is possible to invoke "or" and "and" on a range of predicate matched functions.

}
