package org.sri;

public class ThreadClass extends Thread {
	
	

	public static void main(String[] args){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Before Sleep");
				try {
					Thread.sleep(5*60*1000);
					System.out.println("Sleep Completed!!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();

	}

}
