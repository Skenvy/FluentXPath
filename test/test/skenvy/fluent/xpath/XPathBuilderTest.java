package test.skenvy.fluent.xpath;

import static org.junit.Assert.*;

import org.junit.Test;

import com.skenvy.fluent.xpath.XPathBuilder;

import junit.framework.Assert;

public class XPathBuilderTest {

	@Test
	public void testXPathBuilder() {
		XPathBuilder xpb = XPathBuilder.startFromAnyNode();
		Assert.assertNotNull(xpb);
	}

}
