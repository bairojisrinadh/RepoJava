package core.java;

public class SubClassMethodOverriding extends MethodOverriding{
	
	public SubClassMethodOverriding(){
		System.out.println("In Child Constructor");
	}
	
	public String go(String lastname){
		return lastname;
	}

	public static void main(String[] args) {
		MethodOverriding mo = new SubClassMethodOverriding();
		String oName= mo.go("Bairoji");
		System.out.println(oName);

	}

}
