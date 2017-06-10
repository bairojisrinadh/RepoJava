package com.sri.completeCoreJava;

/*The events that occur during the creation of
a new object are referred to as the instantiation process . The following list of events takes
place when a new object is instantiated:

1. The JVM determines the amount of memory needed for the new object, allocates the
memory on the heap, and zeroes the memory so that it does not contain any garbage data.
2. Explicit initialization of instance variables is performed.
3. The appropriate constructor is invoked, depending on the arguments specified in the
new statement.
4. Before the constructor executes, one of the immediate parent class constructors is
executed.
5. Any instance initializers are executed. If a class has multiple instance initializers, they
are executed in the order they appear in the source file.
6. The body of the constructor executes.
7. The new operator returns a reference to the new object.

Even though the new operator looks like it directly invokes a constructor, the execution
of that constructor occurs at the end of the instantiation process.
*/


public class ObjectInstantiationRule extends SuperClass {

	public String variety = "McIntosh";
	
	{
		System.out.println("Inside the instance initializer of ObjectInstantiationRule Class");
		System.out.println("The Variety at the time of instance initializer is: "+ variety);
	}
	
	public ObjectInstantiationRule(String variety){
		System.out.println("ObjectInstantiationRule constructor is executed!!");
		this.variety = variety;
	}
		
	public static void main(String[] args) {
		ObjectInstantiationRule obj = new ObjectInstantiationRule("Apple");
		System.out.println("After instantiating ObjectInstantiationRule obj: "+obj.variety);
		

	}

}
