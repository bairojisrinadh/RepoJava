package com.sri.completeCoreJava;

/*
 * 1. How to declare array references
   2. How to instantiate array objects
   3. How to access the elements of an array
   4. Multidimensional arrays
   5. Array initializers
   6. What arrays look like in memory
 * 
 */

import java.util.GregorianCalendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Arrays.
 */
/*Array References:
 * An array reference is a reference that denotes the data type of the values to be stored in the
   array, using square brackets to denote the array reference. For example, the following code
   declares three array references:

   int [] finishTimes;
   String lastNames [];
   GregorianCalendar [] july;
 * 
 * The finishTimes reference can point to any array of ints. Similarly, lastNames
	can point to any array of String references and july can point to any array of
	GregorianCalendar references. Notice I didn’t use the term “ objects ” when referring to
	the elements of the array. The array is the object, but the contents of the array are either
	primitive types or references
 */
public class Arrays {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		/*
		
		//Array References are below
		int[] finishTimes;
		String lastNames[];
		GregorianCalendar [] july;

		//Array instantiation
		finishTimes = new int[20];
		lastNames = new String[100];//Array of 100 String references not objects. At this time of instantiation, all the array elements are zeroed or null referenced.
		july = new GregorianCalendar [30]; //Array of 30 GregorianCalendar references not objects
		
		 */
		
		double [] cubics = new double[10];
		for(int i = 0 ; i < cubics.length ; i++){
			int value = i + 1;
			cubics[i] = value * value * value;
		}
		
		double [] temp = cubics;
		temp[5] = -1;
		System.out.println(cubics[5]);
		cubics = null;
		System.out.print("double type array elements of temp Array Object: ");
		for(double value : temp){
			System.out.print(value+ " ");
		}
		
		temp = new double[20];
		
		
		//Array Initializers
		/*An array initializer is a shorthand notation for declaring an array and fi lling it with values,
		all in a single statement. Array initializers are convenient for quickly creating smaller
		arrays. Instead of using the new keyword, you list the elements of the array in curly braces
		separated by commas.*/
		
		int [] amps = {5,34,232,1,23};
		System.out.println();
		for(int element : amps){
			System.out.print(element+" ");
		}		
	}

}
