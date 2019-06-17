package test.skenvy.fluent.xpath;

import static org.junit.Assert.*;

import org.junit.Test;

import com.skenvy.fluent.xpath.XPathBuilder;
import com.skenvy.fluent.xpath.XPathInitialiser;

import junit.framework.Assert;

public class XPathBuilderTest {

	@Test
	public void testXPathBuilder() {
		XPathBuilder xpb = XPathInitialiser.fromAnyDescendant().nodeOfAnyType().withChild();
		Assert.assertNotNull(xpb);
		System.out.println(XPathInitialiser.fromAnyDescendant().nodeOfAnyType().withChild().nodeOfType("div").buildToString());
		System.out.println(XPathInitialiser.fromAnyDescendant().nodeLineage("L","G","H").withChild().nodeOfType("div").buildToString());
	}

}
