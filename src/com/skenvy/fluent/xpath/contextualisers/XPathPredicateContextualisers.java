package com.skenvy.fluent.xpath.contextualisers;

/***
 * A collection of methods that will either result in an XPathPredicateContext,
 * or whose operation's first context swap will be to that of the predicate 
 * context before fast-forwarding to a later context
 */
public interface XPathPredicateContextualisers {
	
	//TODO: build a list of common predicate conditions that can be invoked immediately and without complication, taking only strings.
	
	//[@something="something"] //@id, @name, @class are very common
	
	//[contains(text(),"something")]
	
	//[text()="something"]
	
	//Predicates are composed of [ ], containing (A and B), (C or D), not(E), F, 
	// where ABCDEF are either "node sets" produced as the result of 
	// constructing an XPathBuilder through to a node, predicate, or attribute, 
	// or the utilisation of a predicate function such as =, contains, starts-with, etc.
	
	//PredicateContextualisers can add the results of combining these.
	//While it should be possible to get the outer most and/or/not/self wrapped in [] from here,
	//the question remains of how to implement the actual functions.
	
	//Possibly, this interface would have the option to be implemented by an initialiser that unwraps
	// the xpath functions, and the above would take either buildable XPathBuilders OR the unwrapped predicate functions.
	
	//But some functions don't have implicitly defined boundries in how they can be implemented in this way.
	//Like, substring-after, substring-before. Should there be an "internal predicate expression builder"
	// which is aware that these functions return "strings"? that might be the best way to do it!
	
	
	//TODO: make it possible to invoke xpath functions, where the functions take XPathBuilder's contexts (buildable, or attribute specifically)
	
	//TODO: make is possible to invoke "or" and "and" on a range of predicate matched functions.

}
