package com.myLogics;

public class Practice3 extends Thread {

	public static void method1() throws InterruptedException{
		synchronized(String.class){
			System.out.println("In Method1, Lock acquired by "+ Thread.currentThread() +" on String.class Object");
		}
		synchronized(Integer.class){
			System.out.println("In Method1, Lock acquired by "+ Thread.currentThread() +" on Integer.class Object");
		}
	}
	
	public static void method2() throws InterruptedException{
		
		synchronized(Integer.class){
			System.out.println("In Method2, Lock acquired by "+ Thread.currentThread() +" on Integer.class Object");
		}
		synchronized(String.class){
			System.out.println("In Method2, Lock acquired by "+ Thread.currentThread() +" on String.class Object");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try{
				System.out.println("In Thread1 run() method.");
				method1();
				method2();
				}catch(Exception e){
					System.out.println("In Thread1 run() method, catch block");
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try{
				System.out.println("In Thread2 run() method.");
				method2();
				method1();
				}catch(Exception e){
					System.out.println("In Thread2 run() method, catch block");
				}
			}
		});
		t1.setName("Thread t1");
		t2.setName("Thread t2");
		t1.start();
		t2.start();
	}

}
