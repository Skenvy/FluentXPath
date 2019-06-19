package com.skenvy.fluent;

/***
 * The interface to be implemented by any of the "subclass contexts" which have
 * the potential to be "built", as such, that they are a valid terminal context
 */
public interface BuildableContext {

	/***
	 * Build the contents of the fluent construction of the inner class for
	 * this fluent interface.
	 */
	String buildToString();
	
}