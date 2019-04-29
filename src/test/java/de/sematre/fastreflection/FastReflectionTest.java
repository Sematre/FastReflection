package de.sematre.fastreflection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import de.sematre.fastreflection.util.TestClass;

public class FastReflectionTest {

	@Test
	public void testGetFieldValue() throws Exception {
		TestClass testClass = new TestClass();

		assertEquals("Hello World!", FastReflection.getFieldValue(testClass, "testString"));

		Object testSubClass = FastReflection.getFieldValue(testClass, "testSubClass");
		assertEquals("To be, or not to be, that is the question. ~Shakespeare", FastReflection.getFieldValue(testSubClass, "quote"));
	}

	@Test
	public void testGetStaticFieldValue() throws Exception {
		assertEquals(42, FastReflection.getStaticFieldValue(TestClass.class, "testInteger"));

		String[] testStringArray = (String[]) FastReflection.getStaticFieldValue(TestClass.class, "testStringArray");
		assertArrayEquals(new String[] { "Foo", "Bar" }, testStringArray);
	}

	@Test
	public void testCallMethod() throws Exception {
		TestClass testClass = new TestClass();

		assertEquals(3.14, (double) FastReflection.callMethod(testClass, "getPi"), 0);
		assertNull(FastReflection.callMethod(testClass, "getNull"));
	}

	@Test
	public void testCallStaticMethod() throws Exception {
		assertEquals(5, (int) FastReflection.callStaticMethod(TestClass.class, "getSum", 2, 3));
		assertEquals("Hello World", FastReflection.callStaticMethod(TestClass.class, "join", "Hello", "World"));
	}
}