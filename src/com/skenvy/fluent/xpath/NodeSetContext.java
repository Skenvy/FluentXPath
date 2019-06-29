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

}
