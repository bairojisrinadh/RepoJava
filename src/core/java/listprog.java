package core.java;

import java.util.ArrayList;
import java.util.List;

public class listprog {
	
	public static void main(String[] args) {

	 int x=10;
	 int y=0;
	 int c;
	 try{
		
		 c=x/y;
		 System.out.println("Arithmetic exception thrown in try block");
	 }
	catch(ArithmeticException e){
		System.out.println("Stack Trace: " +e);
		y=5;
		c=x/y;
		System.out.println("Value of c:" +c);
	}finally{
		System.out.println("Into Finally block");
	}

	}

}
