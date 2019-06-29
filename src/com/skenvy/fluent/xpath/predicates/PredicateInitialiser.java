package com.skenvy.fluent.xpath.predicates;


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
	
	/*
	 * Following is the singular instantiation of the Predicate Builder, to
	 * accommodate the fact that predicates themselves can be composed of node
	 * sets, and node sets can terminate with or without predication, that the
	 * construction of a predicate string need not be isolated to internal to a
	 * node set's predication. Although these are some instances of "predicate"
	 * functions that can only be applied to node sets, other expression built
	 * with XPaths need not return a node set as the final outcome. Those that
	 * can only be applied to node sets, such as [last()] will be facilitated 
	 * as "package private" to be invokable from the predicate context, while
	 * everything else will be public.
	 * 
	 * It would be possible to take the context redirection on a more rigorous
	 * adherence, and have individualised contexts according to the return type
	 * of specific predicate functions and the several arguments that each of 
	 * them need, yet this would minimise the potential to construct valid 
	 * XPath expressions that don't rely on node set contexts. Likewise, too
	 * many contexts here would grossly bloat the number of classes in a way
	 * that would not be readily changeable, and the primary goal of this is to
	 * accommodate the construction of XPaths specifically that can be used in
	 * invoking browser automation, for which we can restrict ourselves to a
	 * specific set of functions that can be incorporated into the "predicate
	 * context", while also giving the option to expand that arbitrarily by 
	 * invoking this class to initialise more complicated predicate expressions
	 */
	
	/*************************************************************************/
	/*The following is the simple implementation for a variety of predicates.*/
	/*************************************************************************/
	
	public static final PredicateBooleanContext OR(PredicateBuilder... builders) {
		return initialiseBuilder()._OR(builders);
	}
	
	public static final PredicateBooleanContext AND(PredicateBuilder... builders) {
		return initialiseBuilder()._AND(builders);
	}
	
	
	
//	/***
//	 * 
//	 * @return <*>
//	 */
//	public static Predicate<*>Context from<#>() {
//		return initialiseBuilder().swapTo<*>Context();
//	}
	
}
