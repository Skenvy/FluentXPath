package com.skenvy.fluent.xpath.predicates;

import com.skenvy.fluent.xpath.XPathAttributeContext;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a string component.
 */
public final class PredicateStringContext  extends PredicateBuilder implements BuildablePredicate {
	
	/*************************************************************************/
	/*                    Constructors and "buildToString"                   */
	/*************************************************************************/
	
	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ PredicateStringContext(PredicateBuilder predicateBuilder) {
		super("(string("+predicateBuilder._buildToString()+"))");
	}
	
	/***
	 * Instantiate a PredicateStringContext wrapper of an XPathAttributeContext
	 * @param xPathAttributeContext
	 */
	/*Package Private*/ PredicateStringContext(XPathAttributeContext xPathAttributeContext) {
		super("(string("+xPathAttributeContext.buildToString()+"))");
	}
	
	/***
	 * Instantiate a predicate "String" from the java Object "String" 
	 * @param words
	 */
	/*Package Private*/ PredicateStringContext(String words) {
		super("(\""+words+"\")");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}
	
	/*************************************************************************/
	/*                    Functions (although argumentless)                  */
	/*************************************************************************/
	
	/***
	 * Returns the "text()" argumentless function
	 * @return PredicateStringContext
	 */
	//?:text() | Can be evaluated as a node(set) | Per W3C, defined under node set functions
	public static PredicateStringContext TEXT() {
		return new PredicateStringContext("text()");
	}

	/***
	 * Returns the "." argumentless function
	 * @return PredicateStringContext
	 */
	public static PredicateStringContext DOT() {
		return new PredicateStringContext(".");
	}
	
	/*************************************************************************/
	/*                               Functions                               */
	/*************************************************************************/
	
	/***
	 * Implements the xpath function which returns a string value:
	 * "substring(string, offset)"
	 * @param stringToSearchIn
	 * @param offsetValue
	 * @return PredicateStringContext
	 */
	public static PredicateStringContext substring(PredicateStringContext stringToSearchIn, PredicateNumberContext offsetValue) {
		PredicateStringContext psc = new PredicateStringContext("substring(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(offsetValue);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	/***
	 * Implements the xpath function which returns a string value:
	 * "substring(string, offset, length)"
	 * @param stringToSearchIn
	 * @param offsetValue
	 * @param lengthValue
	 * @return PredicateStringContext
	 */
	public static PredicateStringContext substring(PredicateStringContext stringToSearchIn, PredicateNumberContext offsetValue, PredicateNumberContext lengthValue) {
		PredicateStringContext psc = new PredicateStringContext("substring(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(offsetValue);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(lengthValue);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	/***
	 * Implements the xpath function which returns a string value:
	 * "substring-before(string1, string2)".
	 * Example debugger line: $x("substring-before(\"abcdefg\",\"c\")") = "ab"
	 * @param stringToSearchIn
	 * @param stringToSearchFor
	 * @return PredicateStringContext
	 */
	public static PredicateStringContext substringBefore(PredicateStringContext stringToSearchIn, PredicateStringContext stringToSearchFor) {
		PredicateStringContext psc = new PredicateStringContext("substring-before(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(stringToSearchFor);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	/***
	 * Implements the xpath function which returns a string value:
	 * "substring-after(string1, string2)".
	 * Example debugger line: $x("substring-after(\"abcdefg\",\"c\")") = "defg"
	 * @param stringToSearchIn
	 * @param stringToSearchFor
	 * @return PredicateStringContext
	 */
	public static PredicateStringContext substringAfter(PredicateStringContext stringToSearchIn, PredicateStringContext stringToSearchFor) {
		PredicateStringContext psc = new PredicateStringContext("substring-after(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(stringToSearchFor);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	/***
	 * Implements the xpath function which returns a string value:
	 * "normalize-space(string)"
	 * @param stringToNormalize
	 * @return PredicateStringContext
	 */
	public static PredicateStringContext normalizeSpace(PredicateStringContext stringToNormalize) {
		PredicateStringContext psc = new PredicateStringContext("normalize-space(");
		psc.appendStringBuilder(stringToNormalize);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	/***
	 * Implements the xpath function which returns a string value:
	 * "translate(string1, string2, string3)".
	 * Example debugger line: $x("translate(\"abcdefg\",\"cg\",\"jk\")") = "abjdefk"
	 * @param stringToSearchIn
	 * @param stringToSearchForMapFrom
	 * @param stringToSearchForMapTo
	 * @return PredicateStringContext
	 */
	public static PredicateStringContext translate(PredicateStringContext stringToSearchIn, PredicateStringContext stringToSearchForMapFrom, PredicateStringContext stringToSearchForMapTo) {
		PredicateStringContext psc = new PredicateStringContext("translate(");
		psc.appendStringBuilder(stringToSearchIn);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(stringToSearchForMapFrom);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(stringToSearchForMapTo);
		psc.appendStringBuilder(")");
		return psc;
	}
	
	/***
	 * Implements the xpath function which returns a string value:
	 * "concat(string1, string2, stringN...)"
	 * @param string1
	 * @param string2
	 * @param stringNs
	 * @return PredicateStringContext
	 */
	public static PredicateStringContext concat(PredicateStringContext string1, PredicateStringContext string2, PredicateStringContext... stringNs) {
		PredicateStringContext psc = new PredicateStringContext("concat(");
		psc.appendStringBuilder(string1);
		psc.appendStringBuilder(",");
		psc.appendStringBuilder(string2);
		for(PredicateStringContext stringN : stringNs) {
			psc.appendStringBuilder(",");
			psc.appendStringBuilder(stringN);
		}
		psc.appendStringBuilder(")");
		return psc;
	}
	
}