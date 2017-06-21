package org.sri;

/*
 * Thread Safety Achieved while using multiple JVM's using below stated answer.

You're right that you can't use any type of Thread synchronization to do this.

You'll need to synchronize in some other way.  Lots of options here, all will take some work:
 - Most common is to use a database.
   E.g. Insert a new row in a table with a unique key on (id,name,account) so 2 inserts at the same time will collide and only one succeeds.  Each JVM generates a UUID and inserts it into the table.  Then read back the UUID from the database - all JVMs will see the same UUID on the read back even if a dozen tried to insert at the same time.
 - Use a distributed cache like memcache to do the same sort of thing
 - Use a file in the file system and lock/release that file using file I/O ops to sync
 - Use a messaging protocol to send all generation requests to one JVM

Basically they all use some shared resource that's external to the JVM to resolve the synchronization.
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ThreadClass extends Thread {
	
	@Override
	public void run() {
		//synchronized(ThreadClass.class){
			System.out.println("Started Program by " + currentThread().getName());
			try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\Test.txt"));){
				String line = "";
				while((line = br.readLine()) != null){
					if(line.equalsIgnoreCase("Occupied")){
					System.out.println("Program is in Sleep. Please try after some time.");
				}else{
				BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\Test.txt"));
				bw.write("Occupied");
				bw.newLine();
				bw.close();
				System.out.println("Write Finished, goiog into sleep mode");
				Thread.sleep(2*60*1000);
				System.out.println("Sleep Finished");
				BufferedWriter bw2 = new BufferedWriter(new FileWriter("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\Test.txt"));
				bw2.write("Released");
				bw2.newLine();
				bw2.close();
				}
				}
				System.out.println("Exit the program");
			} catch (Exception e) {
				e.printStackTrace();
			}
		//}
	}

	public static void main(String[] args){
		Thread t1 = new Thread(new ThreadClass(),"Thread-1");
		//Thread t2 = new Thread(new ThreadClass(),"Thread-2");
		t1.start();
		//t2.start();

	}

}
