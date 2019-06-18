package com.skenvy.fluent.xpath;

import com.skenvy.fluent.xpath.contextualisers.XPathAttributeContextualisers;
import com.skenvy.fluent.xpath.contextualisers.XPathAxisContextualisers;
import com.skenvy.fluent.xpath.contextualisers.XPathNodeContextualisers;

/***
 * The contextless builder. Subclassed by the "context aware" builder facades.
 * There is not any public way to initialise the builder's context classes
 * without the help of the XPathInitialiser class.
 */
public abstract class XPathBuilder {
	
	/*************************************************************************/
	/*                The inner class definition and instance                */
	/*************************************************************************/
	
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
	
	/*************************************************************************/
	/*     The super class, and context subclasses, reference variables      */
	/*************************************************************************/
	
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
	
	/*************************************************************************/
	/*  Constructors [mirror all of the inner class', and self referential]  */
	/*************************************************************************/
	
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

	/*************************************************************************/
	/*                            Context Getters                            */
	/*************************************************************************/
	
	/***
	 * Context class getters:  The "axis" context class
	 * @return XPathAxisContext
	 */
	private final XPathAxisContext getAxisContext() {
		if(this.axisContext == null) {
			this.axisContext = new XPathAxisContext(this);
		}
		return this.axisContext;
	}

	/***
	 * Context class getters:  The "node" context class
	 * @return XPathNodeContext
	 */
	private final XPathNodeContext getNodeContext() {
		if(this.nodeContext == null) {
			this.nodeContext = new XPathNodeContext(this);
		}
		return this.nodeContext;
	}

	/***
	 * Context class getters:  The "predicate" context class
	 * @return XPathPredicateContext
	 */
	private final XPathPredicateContext getPredicateContext() {
		if(this.predicateContext == null) {
			this.predicateContext = new XPathPredicateContext(this);
		}
		return this.predicateContext;
	}
	
	/***
	 * Context class getters:  The "attribute" context class
	 * @return XPathAttributeContext
	 */
	private final XPathAttributeContext getAttributeContext() {
		if(this.attributeContext == null) {
			this.attributeContext = new XPathAttributeContext(this);
		}
		return this.attributeContext;
	}

	/*************************************************************************/
	/*                            Context Swappers                           */
	/*************************************************************************/
	
	/***
	 * Context class swappers:  The "axis" context class
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext swapToAxisContext() {
		return this.xPathBuilder.getAxisContext();
	}

	/***
	 * Context class swappers:  The "node" context class
	 * @return XPathNodeContext
	 */
	/*Package Private*/ final XPathNodeContext swapToNodeContext() {
		return this.xPathBuilder.getNodeContext();
	}

	/***
	 * Context class swappers:  The "predicate" context class
	 * @return XPathPredicateContext
	 */
	/*Package Private*/ final XPathPredicateContext swapToPredicateContext() {
		return this.xPathBuilder.getPredicateContext();
	}
	
	/***
	 * Context class swappers:  The "attribute" context class
	 * @return XPathPredicateContext
	 */
	/*Package Private*/ final XPathAttributeContext swapToAttributeContext() {
		return this.xPathBuilder.getAttributeContext();
	}
	
	/*************************************************************************/
	/*   Outer class wrapper functionality to interact with the inner class  */
	/*************************************************************************/

	/***
	 * Interactions with the shared inner class: build the StringBuilder
	 * @return String
	 */
	/*Package Private*/ final String buildTheStringBuilder() {
		return this.xPathBuilderInner.stringBuilder.toString();
	}

	/***
	 * Interactions with the shared inner class: Append to the StringBuilder
	 */
	/*Package Private*/ final void appendStringBuilder(CharSequence chars) {
		this.xPathBuilderInner.stringBuilder.append(chars);
	}
	
	/***
	 * Interactions with the shared inner class: Prepend to the StringBuilder
	 */
	/*Package Private*/ final void prependStringBuilder(CharSequence chars){
		this.xPathBuilderInner.stringBuilder.insert(0, chars);
	}
	
	/***
	 * Interactions with the shared inner class: Wrap to the StringBuilder
	 */
	/*Package Private*/ final void wrapTheStringBuilder(CharSequence append,
												        CharSequence prepend) {
		prependStringBuilder(prepend);
		appendStringBuilder(append);
	}
	
	/*
	 * Following is the deduplication of function implementations for functions
	 * defined in the "buildable/not-buildable" and subclass contexts. So that
	 * there can be a 1-1 correspondence between these superclass, "package
	 * private", finalised methods, and the requirement to override functions
	 * of the same function signature, we will bastardise the java naming
	 * conventions, by simply prefacing these superclass defined functions'
	 * names with underscores. Thus we have deduplicated the function
	 * signatures of method bodies defined for the purpose of deduplication!
	 * 
	 * Deduplinception!
	 */
	
	/*************************************************************************/
	/*   Buildability Contextualiser's function deduplication : Buildable    */
	/*************************************************************************/
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements BuildableContext>).buildToString();
	 * }
	 * @return String
	 */
	/*Package Private*/ final String _buildToString() {
		return this.buildTheStringBuilder();
	}
	
	/*************************************************************************/
	/* Buildability Contextualiser's function deduplication : Not Buildable  */
	/*************************************************************************/

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements NotBuildableContext>).whyIsntThisABuildableContext();
	 * }
	 * @return String
	 */
	/*Package Private*/ final void _whyIsntThisABuildableContext(){
		System.out.println("Only the node, predicate, and attribute context" +
		                   " are buildable contexts. Can't build a" +
		                   " terminal axis");
	}
	
	/*************************************************************************/
	/*    Subclass Contextualiser's function deduplication : Axis Context    */
	/*************************************************************************/
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withAncestor();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withAncestor() {
		appendStringBuilder(XPathAxisContextualisers.ancestor);
		return swapToAxisContext();
	}
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withAncestor();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withAncestor_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.currentContextAncestor);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withAncestorOrSelf();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withAncestorOrSelf() {
		appendStringBuilder(XPathAxisContextualisers.ancestorOrSelf);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withAncestorOrSelf();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext 
	                                     _withAncestorOrSelf_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.
				            currentContextAncestorOrSelf);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withChild();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withChild() {
		appendStringBuilder(XPathAxisContextualisers.child);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withChild();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withChild_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.currentContextChild);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withDescendant();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withDescendant() {
		appendStringBuilder(XPathAxisContextualisers.descendant);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withDescendant();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext 
	                                         _withDescendant_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.currentContextDescendant);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withDescendantOrSelf();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withDescendantOrSelf() {
		appendStringBuilder(XPathAxisContextualisers.descendantOrSelf);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withDescendantOrSelf();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext 
	                                   _withDescendantOrSelf_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.
				            currentContextDescendantOrSelf);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withFollowing();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withFollowing() {
		appendStringBuilder(XPathAxisContextualisers.following);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withFollowing();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withFollowing_CurrentContext(){
		appendStringBuilder(XPathAxisContextualisers.currentContextFollowing);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withFollowingSibling();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withFollowingSibling() {
		appendStringBuilder(XPathAxisContextualisers.followingSibling);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withFollowingSibling();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext 
	                                   _withFollowingSibling_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.
				            currentContextFollowingSibling);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withNamespace();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withNamespace() {
		appendStringBuilder(XPathAxisContextualisers.namespace);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withNamespace();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withNamespace_CurrentContext(){
		appendStringBuilder(XPathAxisContextualisers.currentContextNamespace);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withPreceding();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withPreceding() {
		appendStringBuilder(XPathAxisContextualisers.preceding);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withPreceding();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withPreceding_CurrentContext(){
		appendStringBuilder(XPathAxisContextualisers.currentContextPreceding);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withPrecedingSibling();
	 * }
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext _withPrecedingSibling() {
		appendStringBuilder(XPathAxisContextualisers.precedingSibling);
		return swapToAxisContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withPrecedingSibling();
	 * } for the special case of the current context initialiser
	 * @return XPathAxisContext
	 */
	/*Package Private*/ final XPathAxisContext 
	                                   _withPrecedingSibling_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.
				            currentContextPrecedingSibling);
		return swapToAxisContext();
	}
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withParent();
	 * }
	 * @return XPathNodeContext
	 */
	/*Package Private*/ final XPathNodeContext _withParent() {
		appendStringBuilder(XPathAxisContextualisers.parent);
		return swapToNodeContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withParent();
	 * } for the special case of the current context initialiser
	 * @return XPathNodeContext
	 */
	/*Package Private*/ final XPathNodeContext _withParent_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.currentContextParent);
		return swapToNodeContext();
	}
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withSelf();
	 * }
	 * @return XPathNodeContext
	 */
	/*Package Private*/ final XPathNodeContext _withSelf() {
		appendStringBuilder(XPathAxisContextualisers.self);
		return swapToNodeContext();
	}
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAxisContextualisers>).withSelf();
	 * } for the special case of the current context initialiser
	 * @return XPathNodeContext
	 */
	/*Package Private*/ final XPathNodeContext _withSelf_CurrentContext() {
		appendStringBuilder(XPathAxisContextualisers.currentContextSelf);
		return swapToNodeContext();
	}

	
	/*************************************************************************/
	/*    Subclass Contextualiser's function deduplication : Node Context    */
	/*************************************************************************/
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathNodeContextualisers>).nodeOfAnyType();
	 * }
	 * @param attributeName
	 * @return XPathAttributeContext
	 */
	/*Package Private*/ final XPathNodeContext _nodeOfAnyType() {
		appendStringBuilder(XPathNodeContextualisers.nodeWildcard);
		return swapToNodeContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathNodeContextualisers>).nodeOfType(String 
	 * nodeType);}
	 * @param attributeName
	 * @return XPathAttributeContext
	 */
	/*Package Private*/ final XPathNodeContext _nodeOfType(String nodeType) {
		appendStringBuilder(nodeType);
		return swapToNodeContext();
	}

	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathNodeContextualisers>).nodeLineage(String... 
	 * nodeTypes);}
	 * @param attributeName
	 * @return XPathAttributeContext
	 */
	/*Package Private*/ final XPathNodeContext 
	                                        _nodeLineage(String... nodeTypes) {
		for(int k = 0; k < nodeTypes.length; k++) {
			if(k == (nodeTypes.length - 1)) {
				return this._nodeOfType(nodeTypes[k]);
			} else {
				this._nodeOfType(nodeTypes[k]).withChild();
			}
		}
		return swapToNodeContext();
	}
	
	/*************************************************************************/
	/* Subclass Contextualiser's function deduplication : Predicate Context  */
	/*************************************************************************/
	
	
	
	/*************************************************************************/
	/* Subclass Contextualiser's function deduplication : Attribute Context  */
	/*************************************************************************/
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAttributeContextualisers>).withAttribute(String
	 * attributeName);}
	 * @param attributeName
	 * @return XPathAttributeContext
	 */
	/*Package Private*/ final XPathAttributeContext 
	                                     _withAttribute(String attributeName) {
		appendStringBuilder(XPathAxisContextualisers.attribute);
		appendStringBuilder(attributeName);
		return swapToAttributeContext();
	}
	
	/***
	 * Deduplication of the functionality of the interface method {@code 
	 * (new <? implements XPathAttributeContextualisers>).withAttribute(String
	 * attributeName);} for the special case of the current context initialiser
	 * @param attributeName
	 * @return XPathAttributeContext
	 */
	/*Package Private*/ final XPathAttributeContext 
	                      _withAttribute_CurrentContext(String attributeName) {
		appendStringBuilder(XPathAttributeContextualisers
				               .currentContextAttribute);
		appendStringBuilder(attributeName);
		return swapToAttributeContext();
	}

}
