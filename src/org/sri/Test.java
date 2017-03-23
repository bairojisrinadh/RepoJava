package org.sri;




public class Test {
	
	
	public static void main(String[] args) {
	
		SubAction obj1= new SubAction();
		String str1= obj1.generateURL();
		System.out.println(str1);
		int val = obj1.getID();
		System.out.println(val);
	/*	
		String str1=obj.generateURL();
		System.out.println(str1);
		double maxD = Double.parseDouble("999999999999.99");
		double maxF = Float.parseFloat("999999999999.99");
		System.out.println(maxD);
		System.out.println(maxF);*/
		
		String str = "string";
		Test obj = new Test();
		
		if ((str instanceof Object) && (obj instanceof Test) ){
			System.out.println("Yes");
		}else
		{
			System.out.println("No");
		}
	}

}
