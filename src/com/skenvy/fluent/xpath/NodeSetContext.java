package com.skenvy.fluent.xpath;

/***
 * The interface to be implemented by any of the "node set contexts" which have
 * the potential to be "built", as such, that they are a valid node set context
 */
public interface NodeSetContext {
	
	/***
	 * Build the contents of the fluent construction of the inner class for
	 * this fluent interface. Should behave the same as the normal builder,
	 * simply rebranded to allow for easy type parsing in the predicate node
	 * set wrapping.
	 */
	String buildTheNodeSetToString();
	
	/***
	 * Wraps the entire current node expression in "(*)". If the node/predicate
	 * context prior to the wrapping was returning "multiple" "node sets", then
	 * it will now be returning a single node set which is the combination of
	 * all multiple matching node sets of the wrapped xpath. This is mainly to
	 * suffice being able to evaluate a positional element across multiple sets
	 * rather than many positional elements across multiple sets. A specific
	 * example is the difference between "//div[1]" and "(//div)[1]", where the
	 * first returns the first div of all nodes which contain divs, while the
	 * second returns the first of all divs in the entire document.
	 * @param n
	 * @return
	 */
	XPathNodeContext wrapAMultiNodeSetContextIntoASingleNodeSetContext();

}
