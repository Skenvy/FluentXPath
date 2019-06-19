package com.skenvy.fluent.xpath;

import com.skenvy.fluent.NotBuildableContext;
import com.skenvy.fluent.xpath.contextualisers.XPathNodeContextualisers;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be an axis component.
 */
public class XPathAxisContext extends XPathBuilder implements NotBuildableContext, XPathNodeContextualisers {

	/***
	 * Create a new XPathBuilder subclass that refers to an existing instance
	 * of the XPathBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
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
