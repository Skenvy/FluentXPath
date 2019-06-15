package test.skenvy.fluent.xpath;

import static org.junit.Assert.*;

import org.junit.Test;

import com.skenvy.fluent.xpath.external.XPathBuilder;
import com.skenvy.fluent.xpath.external.XPathInitialiser;

import junit.framework.Assert;

public class XPathBuilderTest {

	@Test
	public void testXPathBuilder() {
		XPathBuilder xpb = XPathInitialiser.fromAnyNode().nodeOfAnyType().withChild();
		Assert.assertNotNull(xpb);
		System.out.println(XPathInitialiser.fromAnyNode().nodeOfAnyType().withChild().nodeOfType("div").buildToString());
	}

}
