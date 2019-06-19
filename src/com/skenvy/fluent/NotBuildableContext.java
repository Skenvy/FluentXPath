package com.skenvy.fluent;

/***
 * The interface to be implemented by any of the "subclass contexts" which do
 * not have the potential to be "built", as such, that they are an invalid 
 * terminal context
 */
public interface NotBuildableContext {

	/***
	 * Yield some explanation to a log, console, or other output, as to why
	 * the current context cannot be built, and which contexts can be built.
	 */
	void whyIsntThisABuildableContext();
	
}