package org.practice.programs;

public class ConstructorChaining {
	private int a,b;
	
	public ConstructorChaining(){
		this(1,2);
		System.out.println("Default Constructor");
	}
	
	
	public ConstructorChaining(int i, int j) {
		this(1,2,3);
		a = i;
		b = j;
		System.out.println("Two Argument Constructor");
	}


	public ConstructorChaining(int i, int j, int k) {
		System.out.println("Three Argument Constructor");
	}


	public static void main(String[] args) {
		ConstructorChaining obj = new ConstructorChaining();
		System.out.println(obj.a);
		System.out.println(obj.b);
	}

}
