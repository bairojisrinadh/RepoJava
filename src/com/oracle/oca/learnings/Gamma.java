package com.oracle.oca.learnings;

class Alpha {
	String getType() {
		return "alpha";
	}
}

class Beta extends Alpha {
	String getType() {
		return "beta";
		}
	}

public class Gamma extends Beta {
	String getType() {
		return "gamma";
		}
	
	public static void main(String[] args) 
	{
		/*As per question, code was as below - compile time error
		//Gamma g1 = new Alpha(); //compilation error need to type cast to 'Gamma' as it is subclass of 'Alpha'
		//Gamma g2 = new Beta(); //compilation error need to type cast to 'Gamma' as it is subclass of 'Beta'
     	*/
		Alpha g1 = new Alpha();
		Alpha g2 = new Beta();
		System.out.println(g1.getType() + " "+ g2.getType());
		}
	}
