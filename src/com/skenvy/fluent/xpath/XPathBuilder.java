package com.skenvy.fluent.xpath;

public class XPathBuilder {

	private StringBuilder stringBuilder;
	
	public XPathBuilder() {
		stringBuilder = new StringBuilder();
	}
	
	public <S extends CharSequence> XPathBuilder(S s) {
		stringBuilder = new StringBuilder(s);
	}

}
