package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.xpath.XPathAttributeContext;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a number component.
 */
public final class PredicateNumberContext extends PredicateBuilder implements BuildablePredicate {
	
	/*************************************************************************/
	/*                    Constructors and "buildToString"                   */
	/*************************************************************************/

	/***
	 * Internal constructor used to instantiate a PredicateNumberContext
	 * instance with some initial CharSequence
	 * @param chars
	 */
	private PredicateNumberContext(CharSequence chars) {
		super(chars);
	}
	
	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ PredicateNumberContext(PredicateBuilder predicateBuilder) {
		super("(number("+predicateBuilder._buildToString()+"))");
	}
	
	/***
	 * Instantiate a PredicateNumberContext wrapper of an XPathAttributeContext
	 * @param xPathAttributeContext
	 */
	/*Package Private*/ PredicateNumberContext(XPathAttributeContext xPathAttributeContext) {
		super("(number("+xPathAttributeContext.buildToString()+"))");
	}

	/***
	 * Instantiate a predicate "Number" from the java literal "int" 
	 * @param words
	 */
	/*Package Private*/ PredicateNumberContext(int number) {
		super("("+number+")");
	}

	/***
	 * Instantiate a predicate "Number" from the java literal "long" 
	 * @param words
	 */
	/*Package Private*/ PredicateNumberContext(long number) {
		super("("+number+")");
	}

	/***
	 * Instantiate a predicate "Number" from the java literal "float" 
	 * @param words
	 */
	/*Package Private*/ PredicateNumberContext(float number) {
		super("("+number+")");
	}

	/***
	 * Instantiate a predicate "Number" from the java literal "double" 
	 * @param words
	 */
	/*Package Private*/ PredicateNumberContext(double number) {
		super("("+number+")");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}	
	
	/*************************************************************************/
	/*                               Functions                               */
	/*************************************************************************/

	/***
	 * Implements the xpath function which returns a number value:
	 * "ceiling(number)"
	 * @param predicateNumberContext
	 * @return PredicateNumberContext
	 */
	public PredicateNumberContext ceiling(PredicateNumberContext predicateNumberContext) {
		PredicateNumberContext pnc = new PredicateNumberContext("ceiling(");
		pnc.appendStringBuilder(predicateNumberContext);
		pnc.appendStringBuilder(")");
		return pnc;
	}

	/***
	 * Implements the xpath function which returns a number value:
	 * "floor(number)"
	 * @param predicateNumberContext
	 * @return PredicateNumberContext
	 */
	public PredicateNumberContext floor(PredicateNumberContext predicateNumberContext) {
		PredicateNumberContext pnc = new PredicateNumberContext("floor(");
		pnc.appendStringBuilder(predicateNumberContext);
		pnc.appendStringBuilder(")");
		return pnc;
	}

	/***
	 * Implements the xpath function which returns a number value:
	 * "round(number)"
	 * @param predicateNumberContext
	 * @return PredicateNumberContext
	 */
	public PredicateNumberContext round(PredicateNumberContext predicateNumberContext) {
		PredicateNumberContext pnc = new PredicateNumberContext("round(");
		pnc.appendStringBuilder(predicateNumberContext);
		pnc.appendStringBuilder(")");
		return pnc;
	}

	/***
	 * Implements the xpath function which returns a number value:
	 * "string-length(string)"
	 * @param predicateStringContext
	 * @return PredicateNumberContext
	 */
	public PredicateNumberContext stringLength(PredicateStringContext predicateStringContext) {
		PredicateNumberContext pnc = new PredicateNumberContext("string-length(");
		pnc.appendStringBuilder(predicateStringContext);
		pnc.appendStringBuilder(")");
		return pnc;
	}
	
}
