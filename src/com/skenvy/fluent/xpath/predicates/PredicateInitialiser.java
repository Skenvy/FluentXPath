package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.xpath.XPathAttributeContext;

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
	 * 
	 * These are to be used exclusively by or internal to the 
	 * XPathPredicateContextualiser interface, which should wrap the preceding
	 * expression in "(" ~ ")" and follow with the predicate builder wrapped in
	 * "[" ~ "]".
	 */
	
	/*************************************************************************/
	/* The following are the specific initialisations of Predicate contexts. */
	/*************************************************************************/
	
	//Boolean Constants
	
	public static final PredicateBooleanContext getTrueConstant() {
		return PredicateBooleanContext.TRUE();
	}
	
	public static final PredicateBooleanContext getFalseConstant() {
		return PredicateBooleanContext.FALSE();
	}
	
	//Get attribute wrapped to predicate
	
	public static final PredicateStringContext getAttributeAsString(XPathAttributeContext xPathAttributeContext) {
		return new PredicateStringContext(xPathAttributeContext);
	}
	
	public static final PredicateNumberContext getAttributeAsNumber(XPathAttributeContext xPathAttributeContext) {
		return new PredicateNumberContext(xPathAttributeContext);
	}
	
	//Get primitive types wrapped to predicate
	
	public static final PredicateStringContext getStringLiteralAsPredicate(String words) {
		return new PredicateStringContext(words);
	}
	
	public static final PredicateNumberContext getIntegerLiteralAsPredicate(int number) {
		return new PredicateNumberContext(number);
	}
	
	public static final PredicateNumberContext getLongLiteralAsPredicate(int number) {
		return new PredicateNumberContext(number);
	}
	
	public static final PredicateNumberContext getFloatLiteralAsPredicate(int number) {
		return new PredicateNumberContext(number);
	}
	
	public static final PredicateNumberContext getDoubleLiteralAsPredicate(int number) {
		return new PredicateNumberContext(number);
	}
	
	/*************************************************************************/
	/* The following are the wrappers from any predicate builder to a type.  */
	/*************************************************************************/
	
	public static final PredicateStringContext wrapAPredicateToStringType(PredicateBuilder predicateBuilder) {
		return new PredicateStringContext(predicateBuilder);
	}
	
	public static final PredicateNumberContext wrapAPredicateToNumberType(PredicateBuilder predicateBuilder) {
		return new PredicateNumberContext(predicateBuilder);
	}
	
	public static final PredicateBooleanContext wrapAPredicateToBooleanType(PredicateBuilder predicateBuilder) {
		return new PredicateBooleanContext(predicateBuilder);
	}
	
	/* Node set, although having a "wrap to" in xpath functions has no 
	 * meaningful actualisation that cannot be produced simply through the
	 * builder. Would be ill-advised to return it from here as a public static
	 */
	
	/*************************************************************************/
	/*The following is the simple implementation for a variety of predicates.*/
	/*************************************************************************/
	
	public static final PredicateBooleanContext NOT(PredicateBuilder builder) {
		return initialiseBuilder()._NOT(builder);
	}
	
	public static final PredicateBooleanContext OR(PredicateBuilder... builders) {
		return initialiseBuilder()._OR(builders);
	}
	
	public static final PredicateBooleanContext AND(PredicateBuilder... builders) {
		return initialiseBuilder()._AND(builders);
	}
	
	public static final PredicateBooleanContext EQUALS(PredicateBuilder... builders) {
		return initialiseBuilder()._EQUALS(builders);
	}
	
	public static final PredicateBooleanContext NOTEQUALS(PredicateBuilder... builders) {
		return initialiseBuilder()._NOTEQUALS(builders);
	}
	
	public static final PredicateBooleanContext GREATERTHAN(PredicateNumberContext... builders) {
		return initialiseBuilder()._GREATERTHAN(builders);
	}
	
	public static final PredicateBooleanContext GREATERTHANOREQUALTO(PredicateNumberContext... builders) {
		return initialiseBuilder()._GREATERTHANOREQUALTO(builders);
	}
	
	public static final PredicateBooleanContext LESSTHAN(PredicateNumberContext... builders) {
		return initialiseBuilder()._LESSTHAN(builders);
	}
	
	public static final PredicateBooleanContext LESSTHANOREQUALTO(PredicateNumberContext... builders) {
		return initialiseBuilder()._LESSTHANOREQUALTO(builders);
	}
	
	public static final PredicateNumberContext PLUS(PredicateNumberContext... numbers) {
		return initialiseBuilder()._PLUS(numbers);
	}
	
	public static final PredicateNumberContext MINUS(PredicateNumberContext... numbers) {
		return initialiseBuilder()._MINUS(numbers);
	}
	
	public static final PredicateNumberContext MULTIPLY(PredicateNumberContext... numbers) {
		return initialiseBuilder()._MULTIPLY(numbers);
	}
	
	public static final PredicateNumberContext DIVIDE(PredicateNumberContext... numbers) {
		return initialiseBuilder()._DIVIDE(numbers);
	}
	
	public static final PredicateNumberContext MODULO(PredicateNumberContext... numbers) {
		return initialiseBuilder()._MODULO(numbers);
	}
	
//	/***
//	 * 
//	 * @return <*>
//	 */
//	public static Predicate<*>Context from<#>() {
//		return initialiseBuilder().swapTo<*>Context();
//	}
	
}
