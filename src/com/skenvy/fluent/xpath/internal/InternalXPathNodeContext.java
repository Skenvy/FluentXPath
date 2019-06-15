package com.skenvy.fluent.xpath.internal;

import com.skenvy.fluent.xpath.internal.contextualisers.InternalXPathAxisContextualisers;
import com.skenvy.fluent.xpath.internal.contextualisers.InternalXPathPredicateContextualisers;

public class InternalXPathNodeContext extends InternalXPathBuilder implements InternalXPathAxisContextualisers, InternalXPathPredicateContextualisers {

	/*Package Private*/ InternalXPathNodeContext(InternalXPathBuilder internalXPathBuilder) {
		super(internalXPathBuilder);
	}

	//TODO must include an "internally" visible build option
	public String buildToString() {
		return this.buildTheStringBuilder();
	}

	@Override
	public InternalXPathAxisContext withAncestor() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.ancestor);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withAncestorOrSelf() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.ancestorOrSelf);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withChild() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.child);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withDescendant() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.descendant);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withDescendantOrSelf() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.descendantOrSelf);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withFollowing() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.following);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withFollowingSibling() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.followingSibling);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withNamespace() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.namespace);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withPreceding() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.preceding);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathAxisContext withPrecedingSibling() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.precedingSibling);
		return swapToAxisContext();
	}

	@Override
	public InternalXPathNodeContext withParent() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.parent);
		return swapToNodeContext();
	}

	@Override
	public InternalXPathNodeContext withSelf() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.self);
		return swapToNodeContext();
	}

	@Override
	public InternalXPathAxisContext withAttribute() {
		appendTheStringBuilder(InternalXPathAxisContextualisers.attribute);
		return swapToAxisContext();
	}

}
