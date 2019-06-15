package com.skenvy.fluent.xpath.external;

import com.skenvy.fluent.NotBuildableContext;
import com.skenvy.fluent.xpath.external.contextualisers.XPathNodeContextualisers;

public class XPathAxisContext extends XPathBuilder implements NotBuildableContext, XPathNodeContextualisers {

	/*Package Private*/ XPathAxisContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}

	@Override
	public void whyIsntThisABuildableContext() {
		// TODO Auto-generated method stub
	}

	@Override
	public XPathNodeContext nodeOfAnyType() {
		appendTheStringBuilder(XPathNodeContextualisers.nodeWildcard);
		return swapToNodeContext();
	}

	@Override
	public XPathNodeContext nodeOfType(String nodeType) {
		appendTheStringBuilder(nodeType);
		return swapToNodeContext();
	}

}
