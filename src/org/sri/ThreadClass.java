package org.sri;

import java.io.BufferedReader;
import java.io.FileReader;

public class ThreadClass extends Thread {
	
	@Override
	public void run() {
		synchronized(ThreadClass.class){
			System.out.println("Before Sleep!! " + currentThread().getName());
			try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\Test.txt"));){
				while(br.readLine() != null){
					System.out.println(br.readLine());
					Thread.sleep(5*1000);
				}
				System.out.println("Sleep Completed!! "+ currentThread().getName());
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args){
		Thread t1 = new Thread(new ThreadClass(),"Thread-1");
		Thread t2 = new Thread(new ThreadClass(),"Thread-2");
		t1.start();
		t2.start();

	}

}
