package com.skenvy.fluent.xpath;

import com.skenvy.fluent.xpath.contextualisers.XPathAttributeContextualisers;
import com.skenvy.fluent.xpath.contextualisers.XPathAxisContextualisers;

/***
 * The builder's "initialiser" used to initialise the XPath builder with any of
 * a number of appropriate ways to start an XPath ; Rescoped to specifically
 * initialise paths with axis' other than "descendant, child, or current
 * context" that are refined to being in the "current context"
 */
public class XPathPredicatePathInitialiser extends XPathBuilder implements XPathAxisContextualisers {

	/***
	 * Create a new XPathBuilder
	 */
	public XPathPredicatePathInitialiser() {
		super();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withAncestor() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextAncestor);
		return swapToAxisContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withAncestorOrSelf() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextAncestorOrSelf);
		return swapToAxisContext();
	}

	// NOT CURRENT CONTEXT: consider using @Deprecated
	@Override
	public XPathAxisContext withChild() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextChild);
		return swapToAxisContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withDescendant() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextDescendant);
		return swapToAxisContext();
	}

	// NOT CURRENT CONTEXT: consider using @Deprecated
	@Override
	public XPathAxisContext withDescendantOrSelf() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextDescendantOrSelf);
		return swapToAxisContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withFollowing() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextFollowing);
		return swapToAxisContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withFollowingSibling() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextFollowingSibling);
		return swapToAxisContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withNamespace() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextNamespace);
		return swapToAxisContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withPreceding() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextPreceding);
		return swapToAxisContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withPrecedingSibling() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextPrecedingSibling);
		return swapToAxisContext();
	}

	// Implicitly current context
	@Override
	public XPathNodeContext withParent() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextParent);
		return swapToNodeContext();
	}

	// Implicitly current context
	@Override
	public XPathNodeContext withSelf() {
		appendTheStringBuilder(XPathAxisContextualisers.currentContextSelf);
		return swapToNodeContext();
	}

	// Implicitly current context
	@Override
	public XPathAttributeContext withAttribute(String attributeName) {
		appendTheStringBuilder(XPathAttributeContextualisers.currentContextAttribute);
		appendTheStringBuilder(attributeName);
		return swapToAttributeContext();
	}

}
