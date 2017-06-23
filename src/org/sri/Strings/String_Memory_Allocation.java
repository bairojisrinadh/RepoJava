package org.sri.Strings;

public class String_Memory_Allocation {

	public static void main(String[] args) {
		String string_literal = "Srinadh"; // pointing to object in string pool
		String literal_2 = "Srinadh"; // pointing to same object in string pool
		String literal_3 = new String("Srinadh");//pointing to object in heap space
		String literal_4 = new String("Srinadh").intern(); // pointing to same object in string pool
		
//		Even If the 2 new Literals are created, both have same value. when you call hashCode() on these
//		Literals will give single value (conclusion: no duplicate created, 2 references poiniting to single memory object in string pool.)
		System.out.println(string_literal.hashCode());
		System.out.println(literal_2.hashCode());
		System.out.println(literal_3.hashCode());
		System.out.println(literal_4.hashCode());
	}

}
