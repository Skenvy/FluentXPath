package com.skenvy.fluent.xpath;

import com.skenvy.fluent.NotBuildableContext;
import com.skenvy.fluent.xpath.contextualisers.XPathNodeContextualisers;

public class XPathAxisContext extends XPathBuilder implements NotBuildableContext, XPathNodeContextualisers {

	/*Package Private*/ XPathAxisContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}

	@Override
	public void whyIsntThisABuildableContext() {
		_whyIsntThisABuildableContext();
	}

	@Override
	public XPathNodeContext nodeOfAnyType() {
		return _nodeOfAnyType();
	}

	@Override
	public XPathNodeContext nodeOfType(String nodeType) {
		return _nodeOfType(nodeType);
	}

	@Override
	public XPathNodeContext nodeLineage(String... nodeTypes) {
		return _nodeLineage(nodeTypes);
	}

}
