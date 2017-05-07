package com.myLogics;

public class Practice9 {
	public static void main(String... args){
		new Practice9().foo(null);
	}

	public void foo(Object s) {
		System.out.println("Object");
	}
	
	public void foo(Integer s) {
		System.out.println("Integer");
	}
	
	public void foo(Number s){
		System.out.println("Number");
	}

}
