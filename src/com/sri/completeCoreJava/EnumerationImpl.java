package com.sri.completeCoreJava;

public class EnumerationImpl {
	public static void main(String[] args) {
		EnumDeclaration obj = new EnumDeclaration();
		obj.size = EnumDeclaration.coffeeSize.BIG;
	}
}

class EnumDeclaration{
	public enum coffeeSize { BIG, SMALL, MEDUIM };
	coffeeSize size;
}

//Conceptual Example for Enum Declaration say public enum coffeeSize{BIG, SMALL, MEDIUM};

class coffeeSize{
	public coffeeSize(String enumName, int index){
		System.out.println(enumName);
	}
	public static final coffeeSize BIG = new coffeeSize("BIG",0);
	public static final coffeeSize SMALL = new coffeeSize("SMALL",1);
	public static final coffeeSize MEDIUM = new coffeeSize("MEDIUM",0);
}