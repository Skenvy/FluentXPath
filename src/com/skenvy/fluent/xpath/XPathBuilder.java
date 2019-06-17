package com.skenvy.fluent.xpath;

/***
 * The contextless builder. Subclassed by the "context aware" builder facades.
 * There is not any public way to initialise the builder's context classes
 * without the help of the XPathInitialiser class.
 */
public abstract class XPathBuilder {
	
	/*
	 * Although this inner class only contains a StringBuilder, it serves to
	 * make it possible later to make the process more generic, of having an
	 * "inner" class instance that contains the fields which the "outer"
	 * builder class exposes to the context classes
	 */
	/***
	 * The "inner" class, which contains the fields which are to be exposed to
	 * the context classes via the "outer" builder class. As this is a fluency
	 * pattern, wrapped in the context-facade pattern, the only field of the
	 * inner class is a StringBuilder.
	 */
	private final class XPathBuilderInner{
		
		/***
		 * The StringBuilder for building the string output fluently
		 */
		/*Package Private*/ final StringBuilder stringBuilder;
		
		/***
		 * Parameterless constructor to make a new empty StringBuilder
		 */
		/*Package Private*/ XPathBuilderInner(){
			this.stringBuilder = new StringBuilder();
		}
		
		/***
		 * Parameterised constructor to initialise the StringBuilder with an
		 * already existing String.
		 * @param s
		 */
		/*Package Private*/ XPathBuilderInner(CharSequence chars) {
			this.stringBuilder = new StringBuilder(chars);
		}
		
	}

	/***
	 * The instance of the inner class.
	 */
	/*Package Private*/ final XPathBuilderInner xPathBuilderInner;
	
	/***
	 * Self referential variable, when a context class is created it can invoke
	 * "this" itself as an instance of this superclass to swap context.
	 */
	/*Package Private*/ final XPathBuilder xPathBuilder;
	
	/***
	 * Context class instance: The "axis" context
	 */
	private XPathAxisContext axisContext;

	/***
	 * Context class instance: The "node" context
	 */
	private XPathNodeContext nodeContext;

	/***
	 * Context class instance: The "predicate" context
	 */
	private XPathPredicateContext predicateContext;
	
	/***
	 * Context class instance: The "attribute" context
	 */
	private XPathAttributeContext attributeContext;
	
	/***
	 * Construct a new instance with a new inner class and self reference.
	 */
	/*Package Private*/ XPathBuilder() {
		this.xPathBuilderInner = new XPathBuilderInner();
		this.xPathBuilder = this;
	}

	/***
	 * Construct a new instance with a parameterised 
	 * inner class and self reference.
	 */
	/*Package Private*/ XPathBuilder(CharSequence chars) {
		this.xPathBuilderInner = new XPathBuilderInner(chars);
		this.xPathBuilder = this;
	}

	/***
	 * Construct a new instance which points to the same inner class instance
	 * and uses the same outer class instance to swap between contexts.
	 */
	/*Package Private*/ XPathBuilder(XPathBuilder xPathBuilder){
		this.xPathBuilderInner = xPathBuilder.xPathBuilderInner;
		this.xPathBuilder      = xPathBuilder;
	}

	/***
	 * Context class getters:  The "axis" context class
	 * @return XPathAxisContext
	 */
	private XPathAxisContext getAxisContext() {
		if(this.axisContext == null) {
			this.axisContext = new XPathAxisContext(this);
		}
		return this.axisContext;
	}

	/***
	 * Context class getters:  The "node" context class
	 * @return XPathNodeContext
	 */
	private XPathNodeContext getNodeContext() {
		if(this.nodeContext == null) {
			this.nodeContext = new XPathNodeContext(this);
		}
		return this.nodeContext;
	}

	/***
	 * Context class getters:  The "predicate" context class
	 * @return XPathPredicateContext
	 */
	private XPathPredicateContext getPredicateContext() {
		if(this.predicateContext == null) {
			this.predicateContext = new XPathPredicateContext(this);
		}
		return this.predicateContext;
	}
	
	/***
	 * Context class getters:  The "attribute" context class
	 * @return XPathAttributeContext
	 */
	private XPathAttributeContext getAttributeContext() {
		if(this.attributeContext == null) {
			this.attributeContext = new XPathAttributeContext(this);
		}
		return this.attributeContext;
	}

	/***
	 * Context class swappers:  The "axis" context class
	 * @return XPathAxisContext
	 */
	/*Package Private*/ XPathAxisContext swapToAxisContext() {
		return this.xPathBuilder.getAxisContext();
	}

	/***
	 * Context class swappers:  The "node" context class
	 * @return XPathNodeContext
	 */
	/*Package Private*/ XPathNodeContext swapToNodeContext() {
		return this.xPathBuilder.getNodeContext();
	}

	/***
	 * Context class swappers:  The "predicate" context class
	 * @return XPathPredicateContext
	 */
	/*Package Private*/ XPathPredicateContext swapToPredicateContext() {
		return this.xPathBuilder.getPredicateContext();
	}
	
	/***
	 * Context class swappers:  The "attribute" context class
	 * @return XPathPredicateContext
	 */
	/*Package Private*/ XPathAttributeContext swapToAttributeContext() {
		return this.xPathBuilder.getAttributeContext();
	}

	/***
	 * Interactions with the shared inner class: build the StringBuilder
	 * @return String
	 */
	/*Package Private*/ String buildTheStringBuilder() {
		return this.xPathBuilderInner.stringBuilder.toString();
	}

	/***
	 * Interactions with the shared inner class: Append to the StringBuilder
	 */
	/*Package Private*/ void appendTheStringBuilder(CharSequence chars) {
		this.xPathBuilderInner.stringBuilder.append(chars);
	}
	
	/***
	 * Interactions with the shared inner class: Prepend to the StringBuilder
	 */
	/*Package Private*/ void prependTheStringBuilder(CharSequence chars) {
		this.xPathBuilderInner.stringBuilder.insert(0, chars);
	}
	
	/***
	 * Interactions with the shared inner class: Wrap to the StringBuilder
	 */
	/*Package Private*/ void wrapTheStringBuilder(CharSequence appendChars, 
												  CharSequence prependChars) {
		prependTheStringBuilder(prependChars);
		appendTheStringBuilder(appendChars);
	}

}
