package com.skenvy.fluent.xpath.internal.contextualisers;

import com.skenvy.fluent.xpath.internal.InternalXPathNodeContext;

/***
 * A collection of methods that will either result in an 
 * InternalXPathNodeContext, or whose operation's first context swap will be to
 * that of the node context before fast-forwarding to a later context
 */
public interface InternalXPathNodeContextualisers {
	
	String nodeWildcard = "*";
	
	InternalXPathNodeContext nodeOfAnyType();
	
	InternalXPathNodeContext nodeOfType(String nodeType);

}
