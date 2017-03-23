package core.java;

public class MethodOverriding {

	public String name = "Srinadh";
	
	public MethodOverriding(){
		System.out.println("In Parent Constructor");
	}
	
	public String go(String name){
	      System.out.println("In Parent go method");
	      return this.name;
	}
}
