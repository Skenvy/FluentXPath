package com.skenvy.fluent.xpath;

import com.skenvy.fluent.NotBuildableContext;

public class XPathAxisContext extends XPathBuilder implements NotBuildableContext, XPathNodeContextualisers {

	public XPathAxisContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}

	@Override
	public void whyIsntThisABuildableContext() {
		// TODO Auto-generated method stub
	}

	@Override
	public XPathNodeContext nodeOfAnyType() {
		addSequenceToTheStringBuilder(XPathNodeContextualisers.nodeWildcard);
		return swapToNodeContext();
	}

	@Override
	public XPathNodeContext nodeOfType(String nodeType) {
		addSequenceToTheStringBuilder(nodeType);
		return swapToNodeContext();
	}

}
