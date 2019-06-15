package com.skenvy.fluent.xpath.internal;

/***
 * The contextless builder. Subclassed by the "context aware" builder facades.
 * There is not any public way to initialise the builder's context classes
 * without the help of the InternalXPathInitialiser class.
 */
public abstract class InternalXPathBuilder {
	
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
	private final class InternalXPathBuilderInner{
		
		/***
		 * The StringBuilder for building the string output fluently
		 */
		/*Package Private*/ final StringBuilder stringBuilder;
		
		/***
		 * Parameterless constructor to make a new empty StringBuilder
		 */
		/*Package Private*/ InternalXPathBuilderInner(){
			this.stringBuilder = new StringBuilder();
		}
		
		/***
		 * Parameterised constructor to initialise the StringBuilder with an
		 * already existing String.
		 * @param s
		 */
		/*Package Private*/ InternalXPathBuilderInner(CharSequence chars) {
			this.stringBuilder = new StringBuilder(chars);
		}
		
	}

	/***
	 * The instance of the inner class.
	 */
	/*Package Private*/ final InternalXPathBuilderInner internalXPathBuilderInner;
	
	/***
	 * Self referential variable, when a context class is created it can invoke
	 * "this" itself as an instance of this superclass to swap context.
	 */
	/*Package Private*/ final InternalXPathBuilder internalXPathBuilder;
	
	/***
	 * Context class instance: The "axis" context
	 */
	private InternalXPathAxisContext internalAxisContext;

	/***
	 * Context class instance: The "node" context
	 */
	private InternalXPathNodeContext internalNodeContext;

	/***
	 * Context class instance: The "predicate" context
	 */
	private InternalXPathPredicateContext internalPredicateContext;
	
	/***
	 * Construct a new instance with a new inner class and self reference.
	 */
	/*Package Private*/ InternalXPathBuilder() {
		this.internalXPathBuilderInner = new InternalXPathBuilderInner();
		this.internalXPathBuilder = this;
	}

	/***
	 * Construct a new instance with a parameterised 
	 * inner class and self reference.
	 */
	/*Package Private*/ InternalXPathBuilder(CharSequence chars) {
		this.internalXPathBuilderInner = new InternalXPathBuilderInner(chars);
		this.internalXPathBuilder = this;
	}

	/***
	 * Construct a new instance which points to the same inner class instance
	 * and uses the same outer class instance to swap between contexts.
	 */
	/*Package Private*/ InternalXPathBuilder(InternalXPathBuilder internalXPathBuilder){
		this.internalXPathBuilderInner = internalXPathBuilder.internalXPathBuilderInner;
		this.internalXPathBuilder      = internalXPathBuilder;
	}

	/***
	 * Context class getters:  The "axis" context class
	 * @return XPathAxisContext
	 */
	private InternalXPathAxisContext getAxisContext() {
		if(this.internalAxisContext == null) {
			this.internalAxisContext = new InternalXPathAxisContext(this);
		}
		return this.internalAxisContext;
	}

	/***
	 * Context class getters:  The "node" context class
	 * @return XPathNodeContext
	 */
	private InternalXPathNodeContext getNodeContext() {
		if(this.internalNodeContext == null) {
			this.internalNodeContext = new InternalXPathNodeContext(this);
		}
		return this.internalNodeContext;
	}

	/***
	 * Context class getters:  The "predicate" context class
	 * @return XPathPredicateContext
	 */
	private InternalXPathPredicateContext getPredicateContext() {
		if(this.internalPredicateContext == null) {
			this.internalPredicateContext = new InternalXPathPredicateContext(this);
		}
		return this.internalPredicateContext;
	}

	/***
	 * Context class swappers:  The "axis" context class
	 * @return XPathAxisContext
	 */
	/*Package Private*/ InternalXPathAxisContext swapToAxisContext() {
		return this.internalXPathBuilder.getAxisContext();
	}

	/***
	 * Context class swappers:  The "node" context class
	 * @return XPathNodeContext
	 */
	/*Package Private*/ InternalXPathNodeContext swapToNodeContext() {
		return this.internalXPathBuilder.getNodeContext();
	}

	/***
	 * Context class swappers:  The "predicate" context class
	 * @return XPathPredicateContext
	 */
	/*Package Private*/ InternalXPathPredicateContext swapToPredicateContext() {
		return this.internalXPathBuilder.getPredicateContext();
	}

	/***
	 * Interactions with the shared inner class: build the StringBuilder
	 * @return String
	 */
	/*Package Private*/ String buildTheStringBuilder() {
		return this.internalXPathBuilderInner.stringBuilder.toString();
	}

	/***
	 * Interactions with the shared inner class: Append to the StringBuilder
	 */
	/*Package Private*/ void appendTheStringBuilder(CharSequence chars) {
		this.internalXPathBuilderInner.stringBuilder.append(chars);
	}
	
	/***
	 * Interactions with the shared inner class: Prepend to the StringBuilder
	 */
	/*Package Private*/ void prependTheStringBuilder(CharSequence chars) {
		this.internalXPathBuilderInner.stringBuilder.insert(0, chars);
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
