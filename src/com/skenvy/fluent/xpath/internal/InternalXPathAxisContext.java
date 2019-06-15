package com.skenvy.fluent.xpath.internal;

import com.skenvy.fluent.xpath.internal.contextualisers.InternalXPathNodeContextualisers;

public class InternalXPathAxisContext extends InternalXPathBuilder implements InternalXPathNodeContextualisers {

	/*Package Private*/ InternalXPathAxisContext(InternalXPathBuilder internalXPathBuilder) {
		super(internalXPathBuilder);
	}

	@Override
	public InternalXPathNodeContext nodeOfAnyType() {
		appendTheStringBuilder(InternalXPathNodeContextualisers.nodeWildcard);
		return swapToNodeContext();
	}

	@Override
	public InternalXPathNodeContext nodeOfType(String nodeType) {
		appendTheStringBuilder(nodeType);
		return swapToNodeContext();
	}

}
