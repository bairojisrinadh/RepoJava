package core.java;

public class JavaPassByValue {
	
	private static int a = 10;
	private static int b = 11;
	
	public static void swap(int a, int b){
		int temp;
		temp = a;
		a = b;
		b = temp;
		
	}
	
	public static void main(String[] args) {
		System.out.print("before swap: ");
		System.out.print(a+" ,");
		System.out.println(b);
		swap(a,b);
		System.out.print("After swap: ");
		System.out.print(a+" ,");
		System.out.println(b);
				
	}

}
