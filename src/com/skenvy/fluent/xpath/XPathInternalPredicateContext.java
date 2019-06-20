package com.skenvy.fluent.xpath;

import com.skenvy.fluent.NotBuildableContext;
import com.skenvy.fluent.xpath.contextualisers.XPathInternalPredicateContextualisers;
import com.skenvy.fluent.xpath.predicateSubcontexts.BooleanSubcontext;
import com.skenvy.fluent.xpath.predicateSubcontexts.NumberSubcontext;
import com.skenvy.fluent.xpath.predicateSubcontexts.StringSubcontext;

/***
 * A context that handles the self reliant construction of valid internal
 * predicate strings. Implements all "subcontext" interfaces related to the
 * types that can be returned or supplied to any predicate function. Any result
 * of the NodeContext or PredicateContext will be a "node-set", and not
 * exclusively predicate.
 */
public class XPathInternalPredicateContext extends XPathBuilder implements NotBuildableContext, XPathInternalPredicateContextualisers, 
                                                                           BooleanSubcontext, NumberSubcontext, StringSubcontext{
	
	/***
	 * Create a new XPathBuilder subclass, such that it qualifies as an 
	 * XPathBuilder instance when type restricting the methods of the
	 * XPathInternalPredicateContextualisers interface.
	 */
	/*Package Private*/ XPathInternalPredicateContext(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}
	
	//This must be here to stop this being the top
	@Override
	public void whyIsntThisABuildableContext() {
		_whyIsntThisABuildableContext();
	}
	
	

}
