package de.sematre.fastreflection.util;

public class TestClass {

	public static int testInteger = 42;
	private static String[] testStringArray = new String[] { "Foo", "Bar" };

	public String testString = "Hello World!";
	private TestSubClass testSubClass = new TestSubClass();

	public TestClass() {}

	public double getPi() {
		return 3.14D;
	}

	private Object getNull() {
		return null;
	}

	public static int getSum(Integer a, Integer b) {
		return a + b;
	}

	private static String join(String a, String b) {
		return String.join(" ", a, b);
	}
}