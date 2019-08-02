package com.skenvy.fluent.xpath;

import com.skenvy.fluent.BuildableContext;
import com.skenvy.fluent.xpath.contextualisers.XPathAxisContextualisers;
import com.skenvy.fluent.xpath.contextualisers.XPathPredicateContextualisers;
import com.skenvy.fluent.xpath.predicates.BuildablePredicate;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a predicate component.
 */
public class XPathPredicateContext extends XPathBuilder implements BuildableContext, XPathAxisContextualisers, XPathPredicateContextualisers, NodeSetContext {
	
	/*************************************************************************/
	/*                      Constructor and buildability                     */
	/*************************************************************************/
	
	/***
	 * Create a new XPathBuilder subclass that refers to an existing instance
	 * of the XPathBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ XPathPredicateContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}

	@Override
	public String buildToString() {
		return _buildToString();
	}
	
	/*************************************************************************/
	/*                  XPathAxisContextualisers @Override's                 */
	/*************************************************************************/

	@Override
	public XPathAxisContext withAncestor() {
		return _withAncestor() ;
	}

	@Override
	public XPathAxisContext withAncestorOrSelf() {
		return _withAncestorOrSelf();
	}

	@Override
	public XPathAxisContext withChild() {
		return _withChild();
	}

	@Override
	public XPathAxisContext withDescendant() {
		return _withDescendant();
	}

	@Override
	public XPathAxisContext withDescendantOrSelf() {
		return _withDescendantOrSelf();
	}

	@Override
	public XPathAxisContext withFollowing() {
		return _withFollowing();
	}

	@Override
	public XPathAxisContext withFollowingSibling() {
		return _withFollowingSibling();
	}

	@Override
	public XPathAxisContext withNamespace() {
		return _withNamespace();
	}

	@Override
	public XPathAxisContext withPreceding() {
		return _withPreceding();
	}

	@Override
	public XPathAxisContext withPrecedingSibling() {
		return _withPrecedingSibling();
	}

	@Override
	public XPathNodeContext withParent() {
		return _withParent();
	}

	@Override
	public XPathNodeContext withSelf() {
		return _withSelf();
	}

	@Override
	public XPathAttributeContext withAttribute(String attributeName) {
		return _withAttribute(attributeName);
	}
	
	/*************************************************************************/
	/*                       NodeSetContext @Override's                      */
	/*************************************************************************/

	@Override
	public String buildTheNodeSetToString() {
		return _buildTheNodeSetToString();
	}

	@Override
	public XPathNodeContext wrapAMultiNodeSetContextIntoASingleNodeSetContext() {
		return _wrapAMultiNodeSetContextIntoASingleNodeSetContext();
	}
	
	/*************************************************************************/
	/*                XPathPredicateContextualisers @Override's              */
	/*************************************************************************/

	@Override
	public XPathPredicateContext withCustomPredicate(BuildablePredicate predicate) {
		return _withCustomPredicate(predicate);
	}

}