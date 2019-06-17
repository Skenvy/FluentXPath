package com.skenvy.fluent.xpath;

import com.skenvy.fluent.BuildableContext;

public class XPathAttributeContext extends XPathBuilder implements BuildableContext {

	/*Package Private*/ XPathAttributeContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}

}
