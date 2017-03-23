/*This class findDuplicate is meant for finding the duplicate no. in Array/List of 1... N Numbers
 * here N=30
 * Logic for this program::
 * In a given list of array elements say, 1 2 3 4.... 30. sum = (n*(n+1))/2 where n=30
 * find the total sum (including duplicate element) 
 * Subtract total - sum will result in the duplicate value.
 * */

package org.sri.javaInterview;

import java.util.*;

public class findDuplicate {

	public static void main(String []args){

		List<Integer> num = new ArrayList<Integer>();
		for(int i=1;i<=30;i++){
			num.add(i);
		}
		num.add(21);
		findDuplicate fd= new findDuplicate();

		System.out.println("Duplicate is :" + fd.duplicate(num));
	}
	
	public int duplicate(List<Integer> num1){
		int highNum= num1.size()-1;
		int value = highNum * (highNum +1)/2;
		int total = getSum(num1);
		int duplicateNumber = total - value;
		
		return duplicateNumber;
	}
	
	public int getSum(List<Integer> numbers){
		int sum=0;
		for(int num : numbers){
			sum +=num; 
		}
		return sum;
	}

}
