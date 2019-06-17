package com.skenvy.fluent.xpath.contextualisers;

/***
 * A collection of methods that will either result in an XPathPredicateContext,
 * or whose operation's first context swap will be to that of the predicate 
 * context before fast-forwarding to a later context
 */
public interface XPathPredicateContextualisers {
	
	//TODO: build a list of common predicate conditions that can be invoked immediately and without complication, taking only strings.
	
	//TODO: make it possible to invoke xpath functions, where the functions take XPathBuilder's contexts (buildable, or attribute specifically)
	
	//TODO: make is possible to invoke "or" and "and" on a range of predicate matched functions.

}
