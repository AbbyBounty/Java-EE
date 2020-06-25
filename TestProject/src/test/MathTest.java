package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.Math;

class MathTest {

	@Test
	public void testSum( ) {
		Math math = new Math( );
		int result = math.sum(100, 20);
		assertEquals(120, result);
	}
	@Test
	public void testSub( ) {
		Math math = new Math( );
		int result = math.sub(100, 20);
		assertEquals(80, result);
	}
	@Test
	public void testGetArray( ) {
		Math math = new Math( );
		int[] arr1 =  math.getArray();
		int[] arr2 = new int[ ] { 1,2,3};
		assertArrayEquals(arr2, arr1);
	}
	@Test
	public void testGetString() {
		Math math = new Math( );
		String s1 = math.getString();
		String s2 = math.getString();
		assertSame(s1, s2);
		//assertNotSame(s1, s2);
	}
	@Test
	public void testGetNumber() {
		Math math = new Math( );
		Number number = math.getNumber();
		assertNull(number);
		//assertNotNull(number);
	}
	
}
