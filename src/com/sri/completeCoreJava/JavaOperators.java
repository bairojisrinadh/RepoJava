package com.sri.completeCoreJava;

public class JavaOperators {

	public static void main(String[] args) {
		//compoundOperator();
		//additiveOperator();
		//sampleChar();
		//testSquare();
		shiftOperators();

	}

	public static void shiftOperators() {
		int leftShift = 2 << 2; //1st operand is value, 2nd operand is to how many times does the binary value(1) needs to be shifted to left.
		/*
		 * 8 - 001000
		 * 8 << 2 - 100000 (shifted 2 times to left)
		 */
		System.out.println("2<<2 : "+ leftShift);
		
		int rightShift = 8 >> 2;//1st operand is value, 2nd operand is to how many times does the binary value(1) needs to be shifted to right.
		/*
		 * 8 - 1000
		 * 8 >> 2 - 0010 (shifted 2 times to right)
		 */
		System.out.println("8>>2 : "+ rightShift);
		
		// >>> - this operator is called as 'Zero Filled Right Shift'
		/*
		 * 8 - 001000
		 * 8 >> 2 - 000010 (shifted 2 times to right, and filled with zero's on shifted places)
		 */
		int zeroFilledRightShift = 8 >>> 2;
		System.out.println("8>>>2 : "+ zeroFilledRightShift);
	}

	public static long square(int x) {
		long y = x * (long) x;
		x = -1;
		return y;
	}

	public static void testSquare() {
		int value = 9;
		long result = square(value);
		System.out.println(result);
	}

	public static void sampleChar() {
		char c = 'A';
		for(int i = 1; i <= 10; i++){
			System.out.print(c++ + " ");
		}
		System.out.println(c);

		int y = 5;
		int result = y-- * 3 / --y;
		System.out.println("y = " + y);
		System.out.println("result = " + result);
	}

	public static void additiveOperator() {
		/*If the operands are of different types, the smaller operand is promoted to the larger. At a
		minimum, the operands are promoted to int's.*/
		short s1 = 10, s2 = 12;
		//short s = s1 + s2; //this wont compile as s1 s2 are up casted to int.
		short s = (short) (s1 + s2); //compiles fine with loss of precision
		System.out.println(s);
		
		byte b = 60, b2= 60;
		byte res = (byte)(b * b2); //value of res is 16, but not 3600, since byte size is 8 bits.
		//binary representation of 3600 is 111000010000, considered only 8 bits 00010000 = 16;
		System.out.println(res);
	}

	public static void compoundOperator() {
		long m = 1000;
		//double m = 100.879; 
		int n = 5; //in double case, n is up casted to double, while at compound assignment, double is down casted to int
		// n = n * m; This line of code will results in compile time error
		/*
		 * As n * m is int times of long, internally int is promoted to long, hence result is long.
		 * we can't assign long value to int. so we need to down cast it to int like (int) n * m; 
		 */
		n *= m; //using compound operators we can remove this casting. in this case m is casted to int before multiplication occurs.
		System.out.println(n);
	}

}
