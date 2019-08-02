package com.skenvy.fluent.xpath.predicates;

/***
 * A collection of interfaces that describe functions that can be applied to 
 * the inner class, while in the context of having the last element of the 
 * inner class' method chained construction be a node set component.
 */
public final class PredicateNodeSetContext extends PredicateBuilder implements BuildablePredicate {
	
	/*************************************************************************/
	/*                    Constructors and "buildToString"                   */
	/*************************************************************************/

	/***
	 * Internal constructor used to instantiate a PredicateNodeSetContext
	 * instance with some initial CharSequence
	 * @param chars
	 */
	private PredicateNodeSetContext(CharSequence chars) {
		super(chars);
	}
	
	/***
	 * Create a new PredicateBuilder subclass that refers to an existing instance
	 * of the PredicateBuilder as the superclass to the context class that brought
	 * us to this context.
	 */
	/*Package Private*/ PredicateNodeSetContext(PredicateBuilder predicateBuilder) {
		super("("+predicateBuilder._buildToString()+")");
	}
	
	@Override
	public String buildToString() {
		return this.buildTheStringBuilder();
	}
	
	/*************************************************************************/
	/*                    Functions (although argumentless)                  */
	/*************************************************************************/
	
	/***
	 * Implements the xpath argumentless function which returns a node-set value:
	 * "comment()". CAN be evaluated as a node(set)
	 * @return PredicateNodeSetContext
	 */
	public PredicateNodeSetContext comment() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("comment()");
		return pnsc;
	}
	
	/***
	 * Implements the xpath argumentless function which returns a node-set value:
	 * "node()". CAN be evaluated as a node(set)
	 * @return PredicateNodeSetContext
	 */
	public PredicateNodeSetContext node() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("node()");
		return pnsc;
	}
	
	/***
	 * Implements the xpath argumentless function which returns a node-set value:
	 * "processing-instruction()". CAN be evaluated as a node(set)
	 * @return PredicateNodeSetContext
	 */
	public PredicateNodeSetContext processingInstruction() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("processing-instruction()");
		return pnsc;
	}
	
	//?:text() | Can be evaluated as a node(set) | Contained in PredicateStringContext
	
	/***
	 * Implements the xpath argumentless function which returns a node-set value:
	 * "name()". Can NOT be evaluated as a node(set)
	 * @return PredicateNodeSetContext
	 */
	public PredicateNodeSetContext name() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("name()");
		return pnsc;
	}
	
	/***
	 * Implements the xpath argumentless function which returns a node-set value:
	 * "position()". Can NOT be evaluated as a node(set)
	 * @return PredicateNodeSetContext
	 */
	public PredicateNodeSetContext position() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("position()");
		return pnsc;
	}
	
	/***
	 * Implements the xpath argumentless function which returns a node-set value:
	 * "last()". Can NOT be evaluated as a node(set)
	 * @return PredicateNodeSetContext
	 */
	public PredicateNodeSetContext last() {
		PredicateNodeSetContext pnsc = new PredicateNodeSetContext("last()");
		return pnsc;
	}

}