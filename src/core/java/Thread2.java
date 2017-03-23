package core.java;

public class Thread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reserve r = new Reserve(3);
		Thread t1 = new Thread(r);
		t1.setName("1st Person");
		Thread t2 = new Thread(r);
		t2.setName("2nd Person");
		Thread t3 = new Thread(r);
		t3.setName("3rd Person");
		Thread t4 = new Thread(r);
		t4.setName("4th Person");
		t1.setPriority(3);
		t2.setPriority(1);
		t3.setPriority(7);
		t4.setPriority(10);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}



class Reserve implements Runnable{
	int available = 10;
	int wanted;
	
	public Reserve(int i){
		this.wanted = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		synchronized (this) {
		System.out.println("Available Berths: "+ available);
		
		if(available>= wanted){
			
			System.out.println(wanted+" Bearths have been reserved by "+name);
			try{
				Thread.sleep(1000);
				available -= wanted;
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}else{
			System.out.println("Sorry "+name+", No Berths available. :-(");
		}
	}

	}	
}
