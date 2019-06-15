package com.skenvy.fluent.xpath.internal.contextualisers;

import com.skenvy.fluent.xpath.internal.InternalXPathAxisContext;
import com.skenvy.fluent.xpath.internal.InternalXPathNodeContext;

/***
 * A collection of methods that will either result in an 
 * InternalXPathAxisContext, or whose operation's first context swap will be to
 * that of the node context before fast-forwarding to a later context
 */
public interface InternalXPathAxisContextualisers {
	
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
	
	InternalXPathAxisContext withAncestor();
	
	InternalXPathAxisContext withAncestorOrSelf();
	
	InternalXPathAxisContext withChild();
	
	InternalXPathAxisContext withDescendant();
	
	InternalXPathAxisContext withDescendantOrSelf();
	
	InternalXPathAxisContext withFollowing();
	
	InternalXPathAxisContext withFollowingSibling();
	
	InternalXPathAxisContext withNamespace();
	
	InternalXPathAxisContext withPreceding();
	
	InternalXPathAxisContext withPrecedingSibling();
	
	InternalXPathNodeContext withParent();
	
	InternalXPathNodeContext withSelf();
	
	InternalXPathAxisContext withAttribute(); //TODO pick a more refined context
	
}