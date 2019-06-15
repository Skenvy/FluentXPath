package com.skenvy.fluent.xpath.external.contextualisers;

import com.skenvy.fluent.xpath.external.XPathNodeContext;

/***
 * A collection of methods that will either result in an XPathNodeContext, or
 * whose operation's first context swap will be to that of the node context
 * before fast-forwarding to a later context
 */
public interface XPathNodeContextualisers {
	
	String nodeWildcard = "*";
	
	XPathNodeContext nodeOfAnyType();
	
	XPathNodeContext nodeOfType(String nodeType);

}
