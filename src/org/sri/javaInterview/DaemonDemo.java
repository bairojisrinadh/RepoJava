package org.sri.javaInterview;

public class DaemonDemo implements Runnable{
	private Thread t;
	private String threadName;
	
	public DaemonDemo(String name){
		this.threadName = name;
		System.out.println("Creating Thread :" +threadName);
	}
	

	public void start() {
		if(t == null){
			t = new Thread(this,threadName);
			t.setDaemon(true);
			t.start();
		}
		
	}
	@Override
	public void run() {
		System.out.println("Running Thread :"+threadName);
		while(true){
			try{
				System.out.println("Thread :"+threadName);
				Thread.sleep(50);
			}catch(InterruptedException e){
				System.out.println("Thread "+threadName+" interrupted.....");
			}finally{
				System.out.println("In finally method :" + threadName);
			}
			
		}
		
	}
	public static void main(String[] args) {
		DaemonDemo t1 = new DaemonDemo("Thread-1");
		t1.start();
		System.out.println("Main method exit");
		

	}



	

}
