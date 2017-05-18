package com.sri.completeCoreJava;

/*
 * Top level class should always have access modifier as 'public'
 */
public class TopLevelClassCanBePublic {
	/*
	 * Access modifier for below class can be defined as public, protected, private or default
	 * as it is a inner class 
	 */
	protected class InnerClass{
		
	}
}
/*
 * If defining two classes in same Java file then top level class needs to be public
 * second class needs to have default access modifier, else if we needs to be public then define new java file.
 */
class SecondClass{
	
}