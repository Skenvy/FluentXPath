package com.skenvy.fluent.xpath.contextualisers;

import com.skenvy.fluent.xpath.XPathAxisContext;
import com.skenvy.fluent.xpath.XPathNodeContext;

/***
 * A collection of methods that will either result in an XPathAxisContext, or
 * whose operation's first context swap will be to that of the axis context
 * before fast-forwarding to a later context
 */
public interface XPathAxisContextualisers extends XPathAttributeContextualisers {
	
	/***
	 * The "current context" axis declaration to target ancestor elements
	 */
	String currentContextAncestor = "ancestor::";

	/***
	 * The "current context" axis declaration to target ancestor elements, or
	 * the current node
	 */
	String currentContextAncestorOrSelf = "ancestor-or-self::";
	
	/***
	 * The "current context" axis declaration to target child elements
	 */
	String currentContextChild = "child::";

	/***
	 * The "current context" axis declaration to target descendant elements
	 */
	String currentContextDescendant = "descendant::";

	/***
	 * The "current context" axis declaration to target descendant elements, or
	 * the current node
	 */
	String currentContextDescendantOrSelf = "descendant-or-self::";
	
	/***
	 * The "current context" axis declaration to target following elements
	 */
	String currentContextFollowing = "following::";
	
	/***
	 * The "current context" axis declaration to target following elements, or
	 * a sibling element
	 */
	String currentContextFollowingSibling = "following-sibling::";
	
	/***
	 * The "current context" axis declaration to target an element in a
	 * namespace
	 */
	String currentContextNamespace = "namespace::";
	
	/***
	 * The "current context" axis declaration to target preceding elements
	 */
	String currentContextPreceding = "preceding::";
	
	/***
	 * The "current context" axis declaration to target preceding elements, or
	 * a sibling element
	 */
	String currentContextPrecedingSibling = "preceding-sibling::";
	
	/***
	 * The "current context" node declaration to target the parent element
	 */
	String currentContextParent = "..";
	
	/***
	 * The "current context" node declaration to target the current element
	 */
	String currentContextSelf = ".";

	/***
	 * The axis declaration to target ancestor elements, relative to the
	 * context of the preceding node.
	 */
	String ancestor = "/"+currentContextAncestor;

	/***
	 * The axis declaration to target ancestor elements, or the current node, 
	 * relative to the context of the preceding node.
	 */
	String ancestorOrSelf = "/"+currentContextAncestorOrSelf;
	
	/***
	 * The axis declaration to target child elements, relative to the context 
	 * of the preceding node.
	 */
	String child = "/";

	/***
	 * The axis declaration to target descendant elements, relative to the
	 * context of the preceding node.
	 */
	String descendant = "/"+currentContextDescendant;

	/***
	 * The axis declaration to target descendant elements, or the current node,
	 * relative to the context of the preceding node.
	 */
	String descendantOrSelf = "//";
	
	/***
	 * The axis declaration to target following elements, relative to the
	 * context of the preceding node.
	 */
	String following = "/"+currentContextFollowing;
	
	/***
	 * The axis declaration to target following elements, or a sibling element,
	 * relative to the context of the preceding node.
	 */
	String followingSibling = "/"+currentContextFollowingSibling;
	
	/***
	 * The axis declaration to target an element in a namespace, relative to 
	 * the context of the preceding node.
	 */
	String namespace = "/"+currentContextNamespace;
	
	/***
	 * The axis declaration to target preceding elements, relative to the
	 * context of the preceding node.
	 */
	String preceding = "/"+currentContextPreceding;
	
	/***
	 * The axis declaration to target preceding elements, or a sibling element,
	 * relative to the context of the preceding node.
	 */
	String precedingSibling = "/"+currentContextPrecedingSibling;
	
	/***
	 * The node declaration to target the parent element, relative to the
	 * context of the preceding node.
	 */
	String parent = "/..";
	
	/***
	 * The node declaration to target the current element, relative to the
	 * context of the preceding node.
	 */
	String self = "/.";

	/***
	 * Targets ancestor elements, from either the implied relative context of a
	 * preceding node, or invoked as a "current context" axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withAncestor();

	/***
	 * Targets ancestor elements or the current node, from either the implied
	 * relative context of a preceding node, or invoked as a "current context"
	 * axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withAncestorOrSelf();

	/***
	 * Targets child elements, from either the implied relative context of a 
	 * preceding node, or invoked as a "current context" axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withChild();

	/***
	 * Targets descendant elements, from either the implied relative context of
	 * a preceding node, or invoked as a "current context" axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withDescendant();

	/***
	 * Targets descendant elements or the current node, from either the implied 
	 * relative context of a preceding node, or invoked as a "current context"
	 * axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withDescendantOrSelf();

	/***
	 * Targets following elements, from either the implied relative context of
	 * a preceding node, or invoked as a "current context" axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withFollowing();

	/***
	 * Targets following or sibling elements, from either the implied relative
	 * context of a preceding node, or invoked as a "current context" axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withFollowingSibling();

	/***
	 * Targets namespace elements, from either the implied relative context of
	 * a preceding node, or invoked as a "current context" axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withNamespace();

	/***
	 * Targets preceding elements, from either the implied relative context of
	 * a preceding node, or invoked as a "current context" axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withPreceding();
	
	/***
	 * Targets preceding or sibling elements, from either the implied relative
	 * context of a preceding node, or invoked as a "current context" axis.
	 * @return XPathAxisContext
	 */
	XPathAxisContext withPrecedingSibling();
	
	/***
	 * Targets the parent node, from either the implied relative context of a
	 * preceding node, or invoked as a "current context" axis.
	 * @return XPathNodeContext
	 */
	XPathNodeContext withParent();
	
	/***
	 * Targets the current node, from either the implied relative context of a
	 * preceding node, or invoked as a "current context" axis.
	 * @return XPathNodeContext
	 */
	XPathNodeContext withSelf();
	
}