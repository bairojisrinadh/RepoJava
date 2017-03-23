package org.sri.javaInterview;

public class ThreadImpl implements Runnable {
	private Thread t;
	private String threadName;
	
	public ThreadImpl(String name){
		this.threadName = name;
		System.out.println("Creating :" + threadName);
		System.out.println("MIN_PRIORITY: "+ Thread.MIN_PRIORITY);
	}
	
	public void start(){
		System.out.println("Starting Thread :" +threadName);
		if(t == null){
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
	
	@Override
	public void run() {
		System.out.println("Running " +threadName);
		try{
			for(int i=4; i>0; i--){
				System.out.println("Thread: "+threadName+", "+i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException ie){
			System.out.println("Thread "+threadName+" interrupted.");
		}
		System.out.println("Thread "+threadName+" exiting.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadImpl t1 = new ThreadImpl("Thread-1");
		t1.start();
		ThreadImpl t2 = new ThreadImpl("Thread-2");
		t2.start();

	}

	

}
