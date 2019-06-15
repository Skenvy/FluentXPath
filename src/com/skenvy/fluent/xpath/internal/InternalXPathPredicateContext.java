package com.skenvy.fluent.xpath.internal;

import com.skenvy.fluent.xpath.internal.contextualisers.InternalXPathAxisContextualisers;
import com.skenvy.fluent.xpath.internal.contextualisers.InternalXPathPredicateContextualisers;

public class InternalXPathPredicateContext extends InternalXPathBuilder implements InternalXPathAxisContextualisers, InternalXPathPredicateContextualisers {
	
	/*Package Private*/ InternalXPathPredicateContext(InternalXPathBuilder internalXPathBuilder) {
		super(internalXPathBuilder);
	}
	
	public String buildToString() {
		return this.buildTheStringBuilder();
	}

	@Override
	public InternalXPathAxisContext withAncestor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withAncestorOrSelf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withDescendant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withDescendantOrSelf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withFollowing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withFollowingSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withNamespace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withPreceding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withPrecedingSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathNodeContext withParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathNodeContext withSelf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InternalXPathAxisContext withAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

}
