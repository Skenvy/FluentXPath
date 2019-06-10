package com.skenvy.fluent.xpath;

public class XPathInitialiser extends XPathBuilder {

	public XPathInitialiser(XPathBuilder xPathBuilder) {
		super(xPathBuilder);
	}
	
	public XPathAxisContext fromAnyNode() {
		addSequenceToTheStringBuilder("//");
		return swapToAxisContext();
	}
	
	public XPathAxisContext fromTheRootNode() {
		addSequenceToTheStringBuilder("/");
		return swapToAxisContext();
	}
	
	public XPathAxisContext fromTheCurrentContextNode() {
		return swapToAxisContext();
	}
	
	public XPathNodeContext fromAnyNodeOfSpecificNodeType(String nodeType) {
		addSequenceToTheStringBuilder("//"+nodeType);
		return swapToNodeContext();
	}
	
	public XPathNodeContext fromTheRootNodeOfSpecificNodeType(String nodeType) {
		addSequenceToTheStringBuilder("/"+nodeType);
		return swapToNodeContext();
	}
	
	public XPathNodeContext fromTheCurrentContextNodeOfSpecificNodeType(String nodeType) {
		addSequenceToTheStringBuilder(nodeType);
		return swapToNodeContext();
	}
	
	public XPathNodeContext fromAnyNodeOfAnyNodeType() {
		addSequenceToTheStringBuilder("//*");
		return swapToNodeContext();
	}
	
	public XPathNodeContext fromTheRootNodeOfAnyNodeType() {
		addSequenceToTheStringBuilder("/*");
		return swapToNodeContext();
	}
	
	public XPathNodeContext fromTheCurrentContextNodeOfAnyNodeType() {
		addSequenceToTheStringBuilder("*");
		return swapToNodeContext();
	}

}
