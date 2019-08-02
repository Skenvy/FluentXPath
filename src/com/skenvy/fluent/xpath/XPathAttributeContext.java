package com.skenvy.fluent.xpath;

import com.skenvy.fluent.BuildableContext;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be an attribute component.
 */
public class XPathAttributeContext extends XPathBuilder implements BuildableContext {

	/*************************************************************************/
	/*                      Constructor and buildability                     */
	/*************************************************************************/
	
	/***
	 * Create a new XPathBuilder subclass that refers to an existing instance
	 * of the XPathBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ XPathAttributeContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}

	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}

}
