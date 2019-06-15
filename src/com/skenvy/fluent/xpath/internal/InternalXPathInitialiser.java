package com.skenvy.fluent.xpath.internal;

public class InternalXPathInitialiser extends InternalXPathBuilder {

	private InternalXPathInitialiser() {
		super();
	}
	
	private InternalXPathInitialiser(CharSequence chars) {
		super(chars);
	}
	
	private static InternalXPathInitialiser initialiseBuilder() {
		return (new InternalXPathInitialiser());
	}
	
	private static InternalXPathInitialiser initialiseBuilder(CharSequence chars) {
		return (new InternalXPathInitialiser(chars));
	}
	
	//Axis safe (any descendant node)
	//Predicate safe (although useless? Descendants of document node!)
	public static InternalXPathAxisContext fromAnyNode() {
		return initialiseBuilder("//").swapToAxisContext();
	}
	
	//Axis safe (root document node)
	//Predicate safe (although useless? Only invokes "self", equivalent to "/.", "//*[/.]" works, yet is the same as "//*[/./*]", can only chain to "self")
	public static InternalXPathAxisContext fromTheRootNode() {
		return initialiseBuilder("/").swapToAxisContext();
	}
	
	//Axis safe (top level node)
	//Predicate safe (child node)
	public static InternalXPathAxisContext fromTheCurrentContextNode() {
		return initialiseBuilder().swapToAxisContext();
	}
	
	//Axis safe (any descendant node of specific type)
	//Predicate safe (although useless? Descendants of document node!)
	public static InternalXPathNodeContext fromAnyNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder("//"+nodeType).swapToNodeContext();
	}
	
	//Axis safe (root document node of specific type)
	//Predicate safe (although useless? Only invokes "self", equivalent to "/.", "//*[/.]" works, yet is the same as "//*[/./*]", can only chain to "self")
	public static InternalXPathNodeContext fromTheRootNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder("/"+nodeType).swapToNodeContext();
	}
	
	//Axis safe (top level node)
	//Predicate safe (child node)
	public static InternalXPathNodeContext fromTheCurrentContextNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder(nodeType).swapToNodeContext();
	}
	
	//Axis safe (any descendant node of any type)
	//Predicate safe (although useless? Descendants of document node!)
	public static InternalXPathNodeContext fromAnyNodeOfAnyNodeType() {
		return initialiseBuilder("//*").swapToNodeContext();
	}
	
	//Axis safe (root document node of any type)
	//Predicate safe (although useless? Only invokes "self", equivalent to "/.", "//*[/.]" works, yet is the same as "//*[/./*]", can only chain to "self")
	public static InternalXPathNodeContext fromTheRootNodeOfAnyNodeType() {
		return initialiseBuilder("/*").swapToNodeContext();
	}
	
	//Axis safe (top level node)
	//Predicate safe (child node)
	public static InternalXPathNodeContext fromTheCurrentContextNodeOfAnyNodeType() {
		return initialiseBuilder("*").swapToNodeContext();
	}
	
	//TODO: Add for "html/body" and "html/head" ?
	//What is the difference between "//*" every node of any type and "//." every node's self reflection (has a lot more nodes than "every node")
	//TODO: Add "attibute" start

}
