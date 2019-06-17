package com.skenvy.fluent.xpath.contextualisers;

import com.skenvy.fluent.xpath.XPathAttributeContext;

/***
 * A collection of methods that will either result in an XPathAttributeContext,
 * or whose operation's first context swap will be to that of the axis context
 * before fast-forwarding to a later context
 */
public interface XPathAttributeContextualisers {
	
	/***
	 * The "current context" axis declaration to target attributes
	 */
	String currentContextAttribute = "@";
	
	/***
	 * The axis declaration to target attributes, relative to the context of 
	 * the preceding node.
	 */
	String attribute = "/@";
	
	/***
	 * Targets attributes, from either the implied relative context of a 
	 * preceding node, or invoked as a "current context" axis.
	 * @param attributeName
	 * @return XPathAttributeContext
	 */
	XPathAttributeContext withAttribute(String attributeName);

}
