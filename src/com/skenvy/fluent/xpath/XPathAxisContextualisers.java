package com.skenvy.fluent.xpath;

/***
 * A collection of methods that will either result in an XPathAxisContext, or
 * whose operation's first context swap will be to that of the axis context
 * before fast-forwarding to a later context
 */
public interface XPathAxisContextualisers {
	
	String ancestor = "/ancestor::";
	String ancestorOrSelf = "/ancestor-or-self::";
	String child = "/";
	String descendant = "/descendant::";
	String descendantOrSelf = "//";
	String following = "/following::";
	String followingSibling = "/following-sibling::";
	String namespace = "/namespace::";
	String preceding = "/preceding::";
	String precedingSibling = "/preceding-sibling::";
	String parent = "/.."; //Node is self evident, the context will be node
	String self = "/."; //Node is self evident, the context will be node
	String attribute = "/@"; //Attribute, not a node! TODO refine the context
	
	XPathAxisContext withAncestor();
	
	XPathAxisContext withAncestorOrSelf();
	
	XPathAxisContext withChild();
	
	XPathAxisContext withDescendant();
	
	XPathAxisContext withDescendantOrSelf();
	
	XPathAxisContext withFollowing();
	
	XPathAxisContext withFollowingSibling();
	
	XPathAxisContext withNamespace();
	
	XPathAxisContext withPreceding();
	
	XPathAxisContext withPrecedingSibling();
	
	XPathNodeContext withParent();
	
	XPathNodeContext withSelf();
	
	XPathAxisContext withAttribute(); //TODO pick a more refined context
	
}