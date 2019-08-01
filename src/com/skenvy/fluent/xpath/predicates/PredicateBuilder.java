package com.skenvy.fluent.xpath.predicates;

/***
 * The contextless builder. Subclassed by the "context aware" builder facades.
 * There is not any public way to initialise the builder's context classes
 * without the help of the PredicateInitialiser class.
 */
public abstract class PredicateBuilder {
	
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
	private final class PredicateBuilderInner{
		
		/***
		 * The StringBuilder for building the string output fluently
		 */
		/*Package Private*/ final StringBuilder stringBuilder;
		
		/***
		 * Parameterless constructor to make a new empty StringBuilder
		 */
		/*Package Private*/ PredicateBuilderInner(){
			this.stringBuilder = new StringBuilder();
		}
		
		/***
		 * Parameterised constructor to initialise the StringBuilder with an
		 * already existing String.
		 * @param s
		 */
		/*Package Private*/ PredicateBuilderInner(CharSequence chars) {
			this.stringBuilder = new StringBuilder(chars);
		}
		
	}
	
	/***
	 * The instance of the inner class.
	 */
	/*Package Private*/ final PredicateBuilderInner predicateBuilderInner;
	
	/*************************************************************************/
	/*     The super class, and context subclasses, reference variables      */
	/*************************************************************************/
	
	/***
	 * Self referential variable, when a context class is created it can invoke
	 * "this" itself as an instance of this superclass to swap context.
	 */
	/*Package Private*/ final PredicateBuilder predicateBuilder;
	
	/***
	 * Context class instance: The "string" context
	 */
	private PredicateStringContext stringContext;

	/***
	 * Context class instance: The "number" context
	 */
	private PredicateNumberContext numberContext;

	/***
	 * Context class instance: The "boolean" context
	 */
	private PredicateBooleanContext booleanContext;
	
	/***
	 * Context class instance: The "node set" context
	 */
	private PredicateNodeSetContext nodeSetContext;
	
	/*************************************************************************/
	/*  Constructors [mirror all of the inner class', and self referential]  */
	/*************************************************************************/
	
	/***
	 * Construct a new instance with a new inner class and self reference.
	 */
	PredicateBuilder() {
		this.predicateBuilderInner = new PredicateBuilderInner();
		this.predicateBuilder = this;
	}

	/***
	 * Construct a new instance with a parameterised 
	 * inner class and self reference.
	 */
	PredicateBuilder(CharSequence chars) {
		this.predicateBuilderInner = new PredicateBuilderInner(chars);
		this.predicateBuilder = this;
	}

	/***
	 * Construct a new instance which points to the same inner class instance
	 * and uses the same outer class instance to swap between contexts.
	 */
	PredicateBuilder(PredicateBuilder predicateBuilder){
		this.predicateBuilderInner = predicateBuilder.predicateBuilderInner;
		this.predicateBuilder      = predicateBuilder;
	}

	/*************************************************************************/
	/*                            Context Getters                            */
	/*************************************************************************/
	
	/***
	 * Context class getters:  The "string" context class
	 * @return PredicateStringContext
	 */
	private final PredicateStringContext getStringContext() {
		if(this.stringContext == null) {
			this.stringContext = new PredicateStringContext(this);
		}
		return this.stringContext;
	}

	/***
	 * Context class getters:  The "number" context class
	 * @return PredicateNumberContext
	 */
	private final PredicateNumberContext getNumberContext() {
		if(this.numberContext == null) {
			this.numberContext = new PredicateNumberContext(this);
		}
		return this.numberContext;
	}

	/***
	 * Context class getters:  The "boolean" context class
	 * @return PredicateBooleanContext
	 */
	private final PredicateBooleanContext getBooleanContext() {
		if(this.booleanContext == null) {
			this.booleanContext = new PredicateBooleanContext(this);
		}
		return this.booleanContext;
	}
	
	/***
	 * Context class getters:  The "node set" context class
	 * @return PredicateNodeSetContext
	 */
	private final PredicateNodeSetContext getNodeSetContext() {
		if(this.nodeSetContext == null) {
			this.nodeSetContext = new PredicateNodeSetContext(this);
		}
		return this.nodeSetContext;
	}

	/*************************************************************************/
	/*                            Context Swappers                           */
	/*************************************************************************/
	
	/***
	 * Context class swappers:  The "string" context class
	 * @return PredicateStringContext
	 */
	/*Package Private*/ final PredicateStringContext swapToStringContext() {
		return this.predicateBuilder.getStringContext();
	}

	/***
	 * Context class swappers:  The "number" context class
	 * @return PredicateNumberContext
	 */
	/*Package Private*/ final PredicateNumberContext swapToNumberContext() {
		return this.predicateBuilder.getNumberContext();
	}

	/***
	 * Context class swappers:  The "boolean" context class
	 * @return PredicateBooleanContext
	 */
	/*Package Private*/ final PredicateBooleanContext swapToBooleanContext() {
		return this.predicateBuilder.getBooleanContext();
	}
	
	/***
	 * Context class swappers:  The "node set" context class
	 */
	/*Package Private*/ final PredicateNodeSetContext swapToNodeSetContext() {
		return this.predicateBuilder.getNodeSetContext();
	}
	
	/*************************************************************************/
	/*   Outer class wrapper functionality to interact with the inner class  */
	/*************************************************************************/

	/***
	 * Interactions with the shared inner class: build the StringBuilder
	 * @return String
	 */
	/*Package Private*/ final String buildTheStringBuilder() {
		return this.predicateBuilderInner.stringBuilder.toString();
	}

	/***
	 * Interactions with the shared inner class: Append to the StringBuilder
	 */
	/*Package Private*/ final void appendStringBuilder(CharSequence chars) {
		this.predicateBuilderInner.stringBuilder.append(chars);
	}
	
	/***
	 * Interactions with the shared inner class: Prepend to the StringBuilder
	 */
	/*Package Private*/ final void prependStringBuilder(CharSequence chars){
		this.predicateBuilderInner.stringBuilder.insert(0, chars);
	}
	
	/***
	 * Interactions with the shared inner class: Append to the StringBuilder
	 */
	/*Package Private*/ final void appendStringBuilder(PredicateBuilder pb) {
		this.predicateBuilderInner.stringBuilder.append(pb.predicateBuilderInner.stringBuilder);
	}
	
	/***
	 * Interactions with the shared inner class: Prepend to the StringBuilder
	 */
	/*Package Private*/ final void prependStringBuilder(PredicateBuilder pb){
		this.predicateBuilderInner.stringBuilder.insert(0, pb.predicateBuilderInner.stringBuilder);
	}
	
	/***
	 * Interactions with the shared inner class: Wrap to the StringBuilder
	 */
	/*Package Private*/ final void wrapTheStringBuilder(CharSequence append,
												        CharSequence prepend) {
		prependStringBuilder(prepend);
		appendStringBuilder(append);
	}
	
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
	/*The following is the simple implementation for a variety of predicates.*/
	/*************************************************************************/
	
	private final PredicateBuilder _iterateWrapSeparator(String seperator, PredicateBuilder... builders) {
		appendStringBuilder("(");
		for(int k = 0; k < builders.length-1; k++) {
			appendStringBuilder("("+builders[k]._buildToString()+")"+seperator);
		}
		appendStringBuilder("("+builders[builders.length-1]._buildToString()+"))");
		return this;
	}
	
	private final PredicateBuilder _iterateWrapComparator(String comparator, PredicateBuilder... builders) {
		appendStringBuilder("(");
		for(int k = 0; k < builders.length-1; k++) {
			appendStringBuilder("(("+builders[k]._buildToString()+")"+comparator+"("+builders[k+1]._buildToString()+"))");
		}
		appendStringBuilder(")");
		return this;
	}
	
	protected final PredicateBooleanContext _NOT(PredicateBuilder builder) {
		appendStringBuilder("(not("+builder._buildToString()+"))");
		return swapToBooleanContext();
	}
	
	protected final PredicateBooleanContext _OR(PredicateBuilder... builders) {
		return _iterateWrapSeparator(" or ",builders).swapToBooleanContext();
	}
	
	protected final PredicateBooleanContext _AND(PredicateBuilder... builders) {
		return _iterateWrapSeparator(" and ",builders).swapToBooleanContext();
	}
	
	protected final PredicateBooleanContext _EQUALS(PredicateBuilder... builders) {
		return _iterateWrapComparator("=",builders).swapToBooleanContext();
	}
	
	protected final PredicateBooleanContext _NOTEQUALS(PredicateBuilder... builders) {
		return _iterateWrapComparator("!=",builders).swapToBooleanContext();
	}
	
	protected final PredicateBooleanContext _GREATERTHAN(PredicateBuilder... builders) {
		return _iterateWrapComparator(">",builders).swapToBooleanContext();
	}
	
	protected final PredicateBooleanContext _GREATERTHANOREQUALTO(PredicateBuilder... builders) {
		return _iterateWrapComparator(">=",builders).swapToBooleanContext();
	}
	
	protected final PredicateBooleanContext _LESSTHAN(PredicateBuilder... builders) {
		return _iterateWrapComparator("<",builders).swapToBooleanContext();
	}
	
	protected final PredicateBooleanContext _LESSTHANOREQUALTO(PredicateBuilder... builders) {
		return _iterateWrapComparator("<=",builders).swapToBooleanContext();
	}
	
	protected final PredicateNumberContext _PLUS(PredicateNumberContext... numbers) {
		return _iterateWrapSeparator("+",numbers).swapToNumberContext();
	}
	
	protected final PredicateNumberContext _MINUS(PredicateNumberContext... numbers) {
		return _iterateWrapSeparator("-",numbers).swapToNumberContext();
	}
	
	protected final PredicateNumberContext _MULTIPLY(PredicateNumberContext... numbers) {
		return _iterateWrapSeparator("*",numbers).swapToNumberContext();
	}
	
	protected final PredicateNumberContext _DIVIDE(PredicateNumberContext... numbers) {
		return _iterateWrapSeparator(" div ",numbers).swapToNumberContext();
	}
	
	protected final PredicateNumberContext _MODULO(PredicateNumberContext... numbers) {
		return _iterateWrapSeparator(" mod ",numbers).swapToNumberContext();
	}

}
