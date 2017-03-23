package org.sri.javaInterview;


public class removeDuplicates {

	public static void main(String args[])

	{
		int array[] = {2,1,2,3,4,3,3,5};// array of elements
		int size = array.length;

		System.out.println("Size before deletion: " + size);

		for (int i = 0; i < size; i++) 
		{

			for (int j = i + 1; j < size; j++) 
			{

				if (array[i] == array[j]) // checking one element with all the elements
				{
						array[j] = array[size - 1];// shifting the values
						System.out.println(array[j]);
						size--;
						j--;  
					
				}
			}
		}
		System.out.println("Size After deletion: " + size);

		for (int k = 0; k < size; k++) 
		{
			System.out.println(array[k]); // printing the values
		}

	}	
}
