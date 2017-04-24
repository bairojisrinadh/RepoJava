package core.java;

public class TheadImpl{
	private static String string1 = "string1";
	private static String string2 = "string2";
	public static void main(String... args) throws InterruptedException{
		Thread t1 = new Thread(){
			public void run(){
				synchronized(string1){
					System.out.println("string1 is locked by thread1");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						System.out.println("Exception in thread1");
					}
					System.out.println("string2 is locked by thread1");
					
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				synchronized(string2){
					System.out.println("string2 is locked by thread2");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						System.out.println("Exception in thread2");
					}
					System.out.println("string1 is locked by thread2");
					
				
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}
