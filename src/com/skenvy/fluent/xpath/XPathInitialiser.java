package com.skenvy.fluent.xpath;

import com.skenvy.fluent.xpath.contextualisers.XPathNodeContextualisers;

/***
 * The builder's "initialiser" used to initialise the XPath builder with any of
 * a number of appropriate ways to start an XPath
 */
public class XPathInitialiser extends XPathBuilder {
	
	/***
	 * Create a new XPathBuilder
	 */
	private XPathInitialiser() {
		super();
	}
	
	/***
	 * Create a new XPathBuilder with initial characters
	 */
	private XPathInitialiser(CharSequence chars) {
		super(chars);
	}
	
	/***
	 * Returns a new instance of this initialiser class, invoked with the no
	 * argument constructor
	 * @return XPathInitialiser
	 */
	private static XPathInitialiser initialiseBuilder() {
		return (new XPathInitialiser());
	}

	/***
	 * Returns a new instance of this initialiser class, invoked with the
	 * CharSequence constructor
	 * @return XPathInitialiser
	 */
	private static XPathInitialiser initialiseBuilder(CharSequence chars) {
		return (new XPathInitialiser(chars));
	}
	
	/* Axis safe (any descendant node)
	 * Predicate safe (although useless? Descendants of document node!)
	 */
	/***
	 * Starts the XPath as having an axis that targets any descendant element
	 * of the current context node ; starts the XPath with the axis "//".
	 * @return XPathAxisContext
	 */
	public static XPathAxisContext fromAnyDescendant() {
		return initialiseBuilder("//").swapToAxisContext();
	}
	
	/* Axis safe (root document node)
	 * Predicate safe (although useless? Only invokes "self", equivalent to 
	 *     "/.", "//*[/.]" works, yet is the same as "//*[/./*]", 
	 *     can only chain to "self")
	 */
	/***
	 * Starts the XPath as having an axis that targets a child element of the
	 * current context node ; starts the XPath with the axis "/".
	 * @return XPathAxisContext
	 */
	public static XPathAxisContext fromAnyChild() {
		return initialiseBuilder("/").swapToAxisContext();
	}
	
	/* Axis safe (top level node)
	 * Predicate safe (child node)
	 */
	/***
	 * Starts the XPath as having an axis that targets an element of the
	 * current context node set ; starts the XPath with nothing.
	 * @return XPathAxisContext
	 */
	public static XPathAxisContext fromTheCurrentContext() {
		return initialiseBuilder().swapToAxisContext();
	}
	
	/* Axis safe (any descendant node of specific type)
	 * Predicate safe (although useless? Descendants of document node!)
	 */
	/***
	 * Starts the XPath as targeting any descendant element of the current
	 * context node ; starts the XPath with "//{@code <nodeType>}".
	 * @param nodeType
	 * @return XPathNodeContext
	 */
	public static XPathNodeContext fromAnyDescendantOfNodeType(String nodeType) {
		return fromAnyDescendant().nodeOfType(nodeType);
	}
	
	/* Axis safe (root document node of specific type)
	 * Predicate safe (although useless? Only invokes "self", equivalent to 
	 *     "/.", "//*[/.]" works, yet is the same as "//*[/./*]", 
	 *     can only chain to "self")
	 */
	/***
	 * Starts the XPath as targeting a child element of the current
	 * context node ; starts the XPath with "/{@code <nodeType>}".
	 * @param nodeType
	 * @return XPathNodeContext
	 */
	public static XPathNodeContext fromAnyChildOfNodeType(String nodeType) {
		return fromAnyChild().nodeOfType(nodeType);
	}
	
	/* Axis safe (top level node)
	 * Predicate safe (child node)
	 */
	/***
	 * Starts the XPath as targeting an element of the current context node set
	 * ; starts the XPath with "{@code <nodeType>}".
	 * @param nodeType
	 * @return XPathNodeContext
	 */
	public static XPathNodeContext fromTheCurrentContextOfNodeType(String nodeType) {
		return fromTheCurrentContext().nodeOfType(nodeType);
	}
	
	/* Axis safe (any descendant node of any type)
	 * Predicate safe (although useless? Descendants of document node!)
	 */
	/***
	 * Starts the XPath as targeting any descendant element of the current
	 * context node ; starts the XPath with "//*".
	 * @return XPathNodeContext
	 */
	public static XPathNodeContext fromAnyDescendantOfAnyNodeType() {
		return fromAnyDescendantOfNodeType(XPathNodeContextualisers.nodeWildcard);
	}
	
	/* Axis safe (root document node of any type)
	 * Predicate safe (although useless? Only invokes "self", equivalent to 
	 *     "/.", "//*[/.]" works, yet is the same as "//*[/./*]", 
	 *     can only chain to "self")
	 */
	/***
	 * Starts the XPath as targeting a child element of the current
	 * context node ; starts the XPath with "/*".
	 * @return XPathNodeContext
	 */
	public static XPathNodeContext fromAnyChildOfAnyNodeType() {
		return fromAnyChildOfNodeType(XPathNodeContextualisers.nodeWildcard);
	}
	
	/* Axis safe (top level node)
	 * Predicate safe (child node)
	 */
	/***
	 * Starts the XPath as targeting an element of the current context node set
	 * ; starts the XPath with "*".
	 * @return XPathNodeContext
	 */
	public static XPathNodeContext fromTheCurrentContextOfAnyNodeType() {
		return fromTheCurrentContextOfNodeType(XPathNodeContextualisers.nodeWildcard);
	}
	
	//TODO: Add for "html/body" and "html/head" ?
	//What is the difference between "//*" every node of any type and "//." 
	// every node's self reflection (has a lot more nodes than "every node")
	//TODO: Add "attibute" start

}
