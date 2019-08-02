package com.skenvy.fluent.xpath;

import com.skenvy.fluent.xpath.contextualisers.XPathAxisContextualisers;

/***
 * The XPathInitialiser's "initialiser" used to initialise the XPath builder 
 * with any of a number of appropriate ways to start an XPath ; Rescoped to 
 * specifically initialise paths with axis' other than "descendant, child, or 
 * current context" that are refined to being in the "current context", if we
 * need to initialise an XPath inside of a non-top-level (predicated) context.
 */
public class XPathPredicatedPathInitialiser extends XPathBuilder implements XPathAxisContextualisers {

	/***
	 * Create a new XPathBuilder
	 */
	public XPathPredicatedPathInitialiser() {
		super();
	}
	
	// Implicitly current context
	@Override
	public XPathAxisContext withAncestor() {
		return _withAncestor_CurrentContext() ;
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withAncestorOrSelf() {
		return _withAncestorOrSelf_CurrentContext();
	}

	// NOT CURRENT CONTEXT: consider using @Deprecated
	@Override
	public XPathAxisContext withChild() {
		return _withChild_CurrentContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withDescendant() {
		return _withDescendant_CurrentContext();
	}

	// NOT CURRENT CONTEXT: consider using @Deprecated
	@Override
	public XPathAxisContext withDescendantOrSelf() {
		return _withDescendantOrSelf();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withFollowing() {
		return _withFollowing_CurrentContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withFollowingSibling() {
		return _withFollowingSibling_CurrentContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withNamespace() {
		return _withNamespace();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withPreceding() {
		return _withPreceding_CurrentContext();
	}

	// Implicitly current context
	@Override
	public XPathAxisContext withPrecedingSibling() {
		return _withPrecedingSibling_CurrentContext();
	}

	// Implicitly current context
	@Override
	public XPathNodeContext withParent() {
		return _withParent_CurrentContext();
	}

	// Implicitly current context
	@Override
	public XPathNodeContext withSelf() {
		return _withSelf_CurrentContext();
	}

	// Implicitly current context
	@Override
	public XPathAttributeContext withAttribute(String attributeName) {
		return _withAttribute_CurrentContext(attributeName);
	}

}
