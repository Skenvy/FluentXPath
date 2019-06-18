package com.skenvy.fluent.xpath;

import com.skenvy.fluent.NotBuildableContext;
import com.skenvy.fluent.xpath.contextualisers.XPathNodeContextualisers;

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
		appendStringBuilder(XPathNodeContextualisers.nodeWildcard);
		return swapToNodeContext();
	}

	@Override
	public XPathNodeContext nodeOfType(String nodeType) {
		appendStringBuilder(nodeType);
		return swapToNodeContext();
	}

	@Override
	public XPathNodeContext nodeLineage(String... nodeTypes) {
		for(int k = 0; k < nodeTypes.length; k++) {
			if(k == (nodeTypes.length - 1)) {
				return this.nodeOfType(nodeTypes[k]);
			} else {
				this.nodeOfType(nodeTypes[k]).withChild();
			}
		}
		return swapToNodeContext();
	}

}
