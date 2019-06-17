package com.skenvy.fluent.xpath.contextualisers;

import com.skenvy.fluent.xpath.XPathNodeContext;

/***
 * A collection of methods that will either result in an XPathNodeContext, or
 * whose operation's first context swap will be to that of the node context
 * before fast-forwarding to a later context
 */
public interface XPathNodeContextualisers {
	
	/***
	 * The wildcard used to select "any" node.
	 */
	String nodeWildcard = "*";
	
	/***
	 * Selects, within the current axis, any node that is within that axis
	 * @return XPathNodeContext
	 */
	XPathNodeContext nodeOfAnyType();
	
	/***
	 * Selects, within the current axis, any named node that is within the axis
	 * @return XPathNodeContext
	 */
	XPathNodeContext nodeOfType(String nodeType);
	
	/***
	 * Selects, within the current axis, a chain of named nodes as direct
	 * children of the immediately preceding named node, and returns the
	 * node context of the result of this.
	 * @return XPathNodeContext
	 */
	XPathNodeContext nodeLineage(String... nodeTypes);

}
