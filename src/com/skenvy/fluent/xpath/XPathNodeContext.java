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
		return _buildToString();
	}

	@Override
	public XPathAxisContext withAncestor() {
		return _withAncestor() ;
	}

	@Override
	public XPathAxisContext withAncestorOrSelf() {
		return _withAncestorOrSelf();
	}

	@Override
	public XPathAxisContext withChild() {
		return _withChild();
	}

	@Override
	public XPathAxisContext withDescendant() {
		return _withDescendant();
	}

	@Override
	public XPathAxisContext withDescendantOrSelf() {
		return _withDescendantOrSelf();
	}

	@Override
	public XPathAxisContext withFollowing() {
		return _withFollowing();
	}

	@Override
	public XPathAxisContext withFollowingSibling() {
		return _withFollowingSibling();
	}

	@Override
	public XPathAxisContext withNamespace() {
		return _withNamespace();
	}

	@Override
	public XPathAxisContext withPreceding() {
		return _withPreceding();
	}

	@Override
	public XPathAxisContext withPrecedingSibling() {
		return _withPrecedingSibling();
	}

	@Override
	public XPathNodeContext withParent() {
		return _withParent();
	}

	@Override
	public XPathNodeContext withSelf() {
		return _withSelf();
	}

	@Override
	public XPathAttributeContext withAttribute(String attributeName) {
		return _withAttribute(attributeName);
	}

}
