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

	private XPathInitialiser initialiser;
	
	private XPathAxisContext axisContext;

	private XPathNodeContext nodeContext;

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
	
	private XPathInitialiser getInitialiser() {
		if(this.initialiser == null) {
			this.initialiser = new XPathInitialiser(this);
		}
		return this.initialiser;
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
	
	/*Package Private*/
	XPathAxisContext swapToAxisContext() {
		return this.xPathBuilder.getAxisContext();
	}
	
	/*Package Private*/
	XPathNodeContext swapToNodeContext() {
		return this.xPathBuilder.getNodeContext();
	}
	
	/*Package Private*/
	XPathPredicateContext swapToPredicateContext() {
		return this.xPathBuilder.getPredicateContext();
	}
	
	/*Package Private*/
	String buildTheStringBuilder() {
		return this.stringBuilder.toString();
	}
	
	/*Package Private*/
	<S extends CharSequence> void addSequenceToTheStringBuilder(S s) {
		this.stringBuilder.append(s);
	}
	
	//TODO Swap to invoking the initialiser first to stop later calls to "start"
	
	/*Package Private*/
	public static XPathInitialiser start() {
		return (new XPathBuilder()).getInitialiser();
	}

}
