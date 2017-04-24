package core.java;

class ConstructorImpl extends ConstructorSuper {
	
	public ConstructorImpl(){
		System.out.println("Inside Child Class constructor: ConstructorImpl");
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ConstructorImpl cs = new ConstructorImpl();
		System.out.println(cs.toString());// This line added only to fix the bug, not as code intended.
	}

}
