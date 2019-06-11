package com.skenvy.fluent.xpath;

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
	
	public static XPathAxisContext fromAnyNode() {
		return initialiseBuilder("//").swapToAxisContext();
	}
	
	public static XPathAxisContext fromTheRootNode() {
		return initialiseBuilder("/").swapToAxisContext();
	}
	
	public static XPathAxisContext fromTheCurrentContextNode() {
		return initialiseBuilder().swapToAxisContext();
	}
	
	public static XPathNodeContext fromAnyNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder("//"+nodeType).swapToNodeContext();
	}
	
	public static XPathNodeContext fromTheRootNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder("/"+nodeType).swapToNodeContext();
	}
	
	public static XPathNodeContext fromTheCurrentContextNodeOfSpecificNodeType(String nodeType) {
		return initialiseBuilder(nodeType).swapToNodeContext();
	}
	
	public static XPathNodeContext fromAnyNodeOfAnyNodeType() {
		return initialiseBuilder("//*").swapToNodeContext();
	}
	
	public static XPathNodeContext fromTheRootNodeOfAnyNodeType() {
		return initialiseBuilder("/*").swapToNodeContext();
	}
	
	public static XPathNodeContext fromTheCurrentContextNodeOfAnyNodeType() {
		return initialiseBuilder("*").swapToNodeContext();
	}

}
