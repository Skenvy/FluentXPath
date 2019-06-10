package com.skenvy.fluent.xpath;

/***
 * The "contextless" builder. Used to initialise a new fluent expression to
 * build the XPath, and handle the initial context swap.
 */
public class XPathBuilder {

	/*Package Private*/
	final StringBuilder stringBuilder;
	
	/*Package Private*/
	final XPathBuilder xPathBuilder;

	/*Package Private*/
	private XPathAxisContext axisContext;

	/*Package Private*/
	private XPathNodeContext nodeContext;

	/*Package Private*/
	private XPathPredicateContext predicateContext;
	
	/*Package Private*/
	XPathBuilder() {
		this.stringBuilder = new StringBuilder();
		this.xPathBuilder  = this;
	}
	
	/*Package Private*/
	<S extends CharSequence> XPathBuilder(S s) {
		this.stringBuilder = new StringBuilder(s);
		this.xPathBuilder  = this;
	}
	
	/*Package Private*/
	XPathBuilder(XPathBuilder xPathBuilder){
		this.stringBuilder = xPathBuilder.stringBuilder;
		this.xPathBuilder  = xPathBuilder;
	}
	
	/*Package Private*/
	XPathAxisContext getAxisContext() {
		if(this.axisContext == null) {
			this.axisContext = new XPathAxisContext(this);
		}
		return this.axisContext;
	}
	
	/*Package Private*/
	XPathNodeContext getNodeContext() {
		if(this.nodeContext == null) {
			this.nodeContext = new XPathNodeContext(this);
		}
		return this.nodeContext;
	}
	
	/*Package Private*/
	XPathPredicateContext getPredicateContext() {
		if(this.predicateContext == null) {
			this.predicateContext = new XPathPredicateContext(this);
		}
		return this.predicateContext;
	}
	
	public static XPathAxisContext startFromAnyNode() {
		return new XPathBuilder("//").getAxisContext();
	}
	
	public static XPathAxisContext startFromTheRootNode() {
		return new XPathBuilder("/").getAxisContext();
	}
	
	public static XPathAxisContext startFromTheCurrentContextNode() {
		return new XPathBuilder().getAxisContext();
	}
	
	public static XPathNodeContext startFromAnyNodeOfSpecificNodeType(String nodeType) {
		return new XPathBuilder("//"+nodeType).getNodeContext();
	}
	
	public static XPathNodeContext startFromTheRootNodeOfSpecificNodeType(String nodeType) {
		return new XPathBuilder("/"+nodeType).getNodeContext();
	}
	
	public static XPathNodeContext startFromTheCurrentContextNodeOfSpecificNodeType(String nodeType) {
		return new XPathBuilder(nodeType).getNodeContext();
	}
	
	public static XPathNodeContext startFromAnyNodeOfAnyNodeType() {
		return new XPathBuilder("//*").getNodeContext();
	}
	
	public static XPathNodeContext startFromTheRootNodeOfAnyNodeType() {
		return new XPathBuilder("/*").getNodeContext();
	}
	
	public static XPathNodeContext startFromTheCurrentContextNodeOfAnyNodeType() {
		return new XPathBuilder("*").getNodeContext();
	}

}
