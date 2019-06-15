package com.skenvy.fluent.xpath.external;

public class XPathInitialiser extends XPathBuilder {

	private XPathInitialiser() {
		super();
	}
	
	private XPathInitialiser(CharSequence chars) {
		super(chars);
	}
	
	private static XPathInitialiser initialiseBuilder() {
		return (new XPathInitialiser());
	}
	
	private static XPathInitialiser initialiseBuilder(CharSequence chars) {
		return (new XPathInitialiser(chars));
	}
	
	//Axis safe (any descendant node)
	//Predicate safe (although useless? Descendants of document node!)
	public static XPathAxisContext fromAnyNode() {
		return initialiseBuilder("//").swapToAxisContext();
	}
	
	//Axis safe (root document node)
	//Predicate safe (although useless? Only invokes "self", equivalent to "/.", "//*[/.]" works, yet is the same as "//*[/./*]", can only chain to "self")
	public static XPathAxisContext fromTheRootNode() {
		return initialiseBuilder("/").swapToAxisContext();
	}
	
	//Axis safe (top level node)
	//Predicate safe (child node)
	public static XPathAxisContext fromTheCurrentContextNode() {
		return initialiseBuilder().swapToAxisContext();
	}
	
	//Axis safe (any descendant node of specific type)
	//Predicate safe (although useless? Descendants of document node!)
	public static XPathNodeContext fromAnyNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder("//"+nodeType).swapToNodeContext();
	}
	
	//Axis safe (root document node of specific type)
	//Predicate safe (although useless? Only invokes "self", equivalent to "/.", "//*[/.]" works, yet is the same as "//*[/./*]", can only chain to "self")
	public static XPathNodeContext fromTheRootNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder("/"+nodeType).swapToNodeContext();
	}
	
	//Axis safe (top level node)
	//Predicate safe (child node)
	public static XPathNodeContext fromTheCurrentContextNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder(nodeType).swapToNodeContext();
	}
	
	//Axis safe (any descendant node of any type)
	//Predicate safe (although useless? Descendants of document node!)
	public static XPathNodeContext fromAnyNodeOfAnyNodeType() {
		return initialiseBuilder("//*").swapToNodeContext();
	}
	
	//Axis safe (root document node of any type)
	//Predicate safe (although useless? Only invokes "self", equivalent to "/.", "//*[/.]" works, yet is the same as "//*[/./*]", can only chain to "self")
	public static XPathNodeContext fromTheRootNodeOfAnyNodeType() {
		return initialiseBuilder("/*").swapToNodeContext();
	}
	
	//Axis safe (top level node)
	//Predicate safe (child node)
	public static XPathNodeContext fromTheCurrentContextNodeOfAnyNodeType() {
		return initialiseBuilder("*").swapToNodeContext();
	}
	
	//TODO: Add for "html/body" and "html/head" ?
	//What is the difference between "//*" every node of any type and "//." every node's self reflection (has a lot more nodes than "every node")
	//TODO: Add "attibute" start

}
