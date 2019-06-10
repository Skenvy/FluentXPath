package com.skenvy.fluent.xpath;

import com.skenvy.fluent.BuildableContext;

public class XPathPredicateContext extends XPathBuilder implements BuildableContext, XPathAxisContextualisers, XPathPredicateContextualisers {

	public XPathPredicateContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}

	@Override
	public String buildToString() {
		return this.stringBuilder.toString();
	}

	@Override
	public XPathAxisContext withAncestor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withAncestorOrSelf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withDescendant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withDescendantOrSelf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withFollowing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withFollowingSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withNamespace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withPreceding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withPrecedingSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathNodeContext withParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathNodeContext withSelf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPathAxisContext withAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

}
