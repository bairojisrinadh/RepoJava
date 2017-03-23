package core.java;

import java.io.IOException;

class Thread1 extends MyThread implements Runnable {

	boolean stop = false;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=1;i<1000000;i++){
			System.out.println(i);
			if(stop)return;
		}
	}

}

  public class MyThread{
		public static void main(String[] args) throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			Thread1 t = new Thread1();
			Thread t1 = new Thread(t);
			System.out.println(Thread.currentThread().getContextClassLoader());
			t1.start();
			System.in.read();
			t.stop= true;
			
		}
	}
