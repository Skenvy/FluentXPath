package com.skenvy.fluent.xpath.predicates;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a boolean component.
 */
public final class PredicateBooleanContext extends PredicateBuilder implements BuildablePredicate {
	
	/*************************************************************************/
	/*                    Constructors and "buildToString"                   */
	/*************************************************************************/
	
	/***
	 * Internal constructor used to instantiate a PredicateBooleanContext
	 * instance with some initial CharSequence
	 * @param chars
	 */
	private PredicateBooleanContext(CharSequence chars) {
		super(chars);
	}
	
	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ PredicateBooleanContext(PredicateBuilder predicateBuilder) {
		super("(boolean("+predicateBuilder._buildToString()+"))");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}
	
	/*************************************************************************/
	/*                               Constants                               */
	/*************************************************************************/
	
	/***
	 * Returns the "true" constant
	 * @return PredicateBooleanContext
	 */
	public static PredicateBooleanContext TRUE() {
		return new PredicateBooleanContext("(true())");
	}
	
	/***
	 * Returns the "false" constant
	 * @return PredicateBooleanContext
	 */
	public static PredicateBooleanContext FALSE() {
		return new PredicateBooleanContext("(false())");
	}
	
	/*************************************************************************/
	/*                               Functions                               */
	/*************************************************************************/
	
	/***
	 * Implements the xpath function which returns a boolean value:
	 * "starts-with(haystack, needle)"
	 * @param stringToSearchIn
	 * @param stringToSearchFor
	 * @return PredicateBooleanContext
	 */
	public static PredicateBooleanContext startsWith(PredicateStringContext stringToSearchIn, PredicateStringContext stringToSearchFor) {
		PredicateBooleanContext pbc = new PredicateBooleanContext("starts-with(");
		pbc.appendStringBuilder(stringToSearchIn);
		pbc.appendStringBuilder(",");
		pbc.appendStringBuilder(stringToSearchFor);
		pbc.appendStringBuilder(")");
		return pbc;
	}
	
	/***
	 * Implements the xpath function which returns a boolean value:
	 * "contains(haystack, needle)"
	 * @param stringToSearchIn
	 * @param stringToSearchFor
	 * @return PredicateBooleanContext
	 */
	public static PredicateBooleanContext contains(PredicateStringContext stringToSearchIn, PredicateStringContext stringToSearchFor) {
		PredicateBooleanContext pbc = new PredicateBooleanContext("contains(");
		pbc.appendStringBuilder(stringToSearchIn);
		pbc.appendStringBuilder(",");
		pbc.appendStringBuilder(stringToSearchFor);
		pbc.appendStringBuilder(")");
		return pbc;
	}
	
}