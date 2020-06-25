package main;

public class Math {
	public int sum( int num1, int num2 ) {
		return num1 + num2;
	}
	public int sub( int num1, int num2 ) {
		return num1 - num2;
	}
	public int[] getArray( ) {
		int[] arr = new int[ ] { 1,2,3};
		return arr;
	}
	public String getString( ) {
		//return new String("Java EE Online");
		return "Java EE Online";
	}
	public Number getNumber() {
		Number number = new Integer(0);
		return number;
	}
}
