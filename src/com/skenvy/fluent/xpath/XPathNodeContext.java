package com.skenvy.fluent.xpath;

import com.skenvy.fluent.BuildableContext;
import com.skenvy.fluent.xpath.contextualisers.XPathAxisContextualisers;
import com.skenvy.fluent.xpath.contextualisers.XPathPredicateContextualisers;

public class XPathNodeContext extends XPathBuilder implements BuildableContext, XPathAxisContextualisers, XPathPredicateContextualisers {

	/*Package Private*/ XPathNodeContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}

	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}

	@Override
	public XPathAxisContext withAncestor() {
		appendTheStringBuilder(XPathAxisContextualisers.ancestor);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withAncestorOrSelf() {
		appendTheStringBuilder(XPathAxisContextualisers.ancestorOrSelf);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withChild() {
		appendTheStringBuilder(XPathAxisContextualisers.child);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withDescendant() {
		appendTheStringBuilder(XPathAxisContextualisers.descendant);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withDescendantOrSelf() {
		appendTheStringBuilder(XPathAxisContextualisers.descendantOrSelf);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withFollowing() {
		appendTheStringBuilder(XPathAxisContextualisers.following);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withFollowingSibling() {
		appendTheStringBuilder(XPathAxisContextualisers.followingSibling);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withNamespace() {
		appendTheStringBuilder(XPathAxisContextualisers.namespace);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withPreceding() {
		appendTheStringBuilder(XPathAxisContextualisers.preceding);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withPrecedingSibling() {
		appendTheStringBuilder(XPathAxisContextualisers.precedingSibling);
		return swapToAxisContext();
	}

	@Override
	public XPathNodeContext withParent() {
		appendTheStringBuilder(XPathAxisContextualisers.parent);
		return swapToNodeContext();
	}

	@Override
	public XPathNodeContext withSelf() {
		appendTheStringBuilder(XPathAxisContextualisers.self);
		return swapToNodeContext();
	}

	@Override
	public XPathAttributeContext withAttribute(String attributeName) {
		appendTheStringBuilder(XPathAxisContextualisers.attribute);
		appendTheStringBuilder(attributeName);
		return swapToAttributeContext();
	}

}
