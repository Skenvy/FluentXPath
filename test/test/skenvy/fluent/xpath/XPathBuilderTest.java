package test.skenvy.fluent.xpath;

import static org.junit.Assert.*;

import org.junit.Test;

import com.skenvy.fluent.xpath.XPathBuilder;

import junit.framework.Assert;

public class XPathBuilderTest {

	@Test
	public void testXPathBuilder() {
		XPathBuilder xpb = new XPathBuilder();
		Assert.assertNotNull(xpb);
	}

	@Test
	public void testXPathBuilderS() {
		//TODO add validation testing on the string actually being a legitimate xpath
		XPathBuilder xpb = new XPathBuilder("Some string");
		Assert.assertNotNull(xpb);
	}

}
