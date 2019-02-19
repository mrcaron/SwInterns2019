package com.example.solidworks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolidworksSpringApplicationTests {
	SolidworksMethods sm=new SolidworksMethods();
	@Test
	public void testReverse() {
		
		assertEquals(sm.reverse("bad"),("dab"));
	}
	@Test
	public void testPalindrome() {
		assertTrue(sm.isPalindrome("malayalam"));
	}
	@Test
	public void testFifthChar() {
		assertEquals(sm.fifthChar("biology"),'o');
	}
	@Test
	public void testSplit() {
		assertEquals(sm.stringSplit("once upon a time", " ").length,4);
	}
	

}
