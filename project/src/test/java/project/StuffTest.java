package project;

import org.junit.Test;

import static org.junit.Assert.*;

public class StuffTest {
	
	/** A JUnit test method to test isqrt. */
	@Test
	public void testStuff() {
		Stuff tester = new Stuff();
		assertEquals(1, tester.isqrt(0));
		assertEquals(1, tester.isqrt(1));
		assertEquals(2, tester.isqrt(2));
		assertEquals(2, tester.isqrt(3));
		assertEquals(10, tester.isqrt(100));
	}

}
