package com.skenvy.fluent.xpath;

import com.skenvy.fluent.BuildableContext;

public class XPathNodeContext extends XPathBuilder implements BuildableContext, XPathAxisContextualisers, XPathPredicateContextualisers {

	public XPathNodeContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}

	@Override
	public String buildToString() {
		return this.stringBuilder.toString();
	}

	@Override
	public XPathAxisContext withAncestor() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.ancestor);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withAncestorOrSelf() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.ancestorOrSelf);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withChild() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.child);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withDescendant() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.descendant);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withDescendantOrSelf() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.descendantOrSelf);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withFollowing() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.following);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withFollowingSibling() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.followingSibling);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withNamespace() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.namespace);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withPreceding() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.preceding);
		return swapToAxisContext();
	}

	@Override
	public XPathAxisContext withPrecedingSibling() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.precedingSibling);
		return swapToAxisContext();
	}

	@Override
	public XPathNodeContext withParent() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.parent);
		return swapToNodeContext();
	}

	@Override
	public XPathNodeContext withSelf() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.self);
		return swapToNodeContext();
	}

	@Override
	public XPathAxisContext withAttribute() {
		addSequenceToTheStringBuilder(XPathAxisContextualisers.attribute);
		return swapToAxisContext();
	}

}
