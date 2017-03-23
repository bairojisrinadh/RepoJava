package core.java;

/**
 * 
 * @author bsrinadh
 * 
 * Instance methods can access instance variables and instance methods directly. -- Compiler internally appends 'this' reference.
 * 
 * Instance methods can access class variables and class methods directly.
 * 
 * Class methods can access class variables and class methods directly.
 * 
 * Class methods cannot access instance variables or instance methods directly—they must use an object reference. Also, class methods cannot use the this keyword as there is no instance for this to refer to.
 * 
 * So the answer is yes, non-static methods CAN modify static variables
 *
 */

/* This comment is to check GitHub commit process
 * 
 */


public class HelloSample {
	
	 static String name = "Srinadh";
	 public String last = "Biroji";
	
	public HelloSample(String name){
		this.name = name;
	}

	public static void main(String[] args) {
		System.out.println(name);
		System.out.println("This is to test JVM is backward compatability or not!!");
		HelloSample obj = new HelloSample("Ashwini");
		System.out.println(obj.name);

	}
	
	public void sample(){
	
	}
	
	public static void staticSample1(){
		
	}
	public static void staticSample(){
		name = "staticname";
		staticSample1();
		//last = "newlast";  -- Class methods cannot access instance variables
		//instanceMethod();  -- Class methods cannot access instance Methods
	}
	public void instanceMethod(){
		last="sri"; //Instance methods can access instance variables   -- compiler internally appends 'this' reference
		sample();  //Instance methods can access instance methods
		name="ash"; //Instance methods can access class/static variables
		this.staticSample();  //Instance methods can access class/static methods
	}

}
