package org.sri.javaPrograms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton implements Serializable,Cloneable{
	//volatile key word is used, in order to prevent half initialized instance to access in MultiThreaded environment
	private static volatile Singleton soleInstance;


	private Singleton(){
		//Below if Condition, solution for reflection issue. now we cannot create instance through reflection.
		/*if(soleInstance != null){
			throw new RuntimeException("Cannot Create. Please use getInstance() method");
		}*/
		System.out.println("Creating Instance...");
	}

	public static Singleton getInstance(){
		synchronized(soleInstance){
			if(soleInstance == null){
				soleInstance = new Singleton();
			}
			return soleInstance;
		}
	}

	public static void test(){
		System.out.println("Singleton Instance");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();	
	}

	private Object readResolve() throws ObjectStreamException{
		System.out.println("--- Read Resolve ---");
		return soleInstance;
	}
}

class TestCase {
	public static void print(String name,Singleton obj){
		System.out.println(String.format("Object: %s, Hascode: %d",name,obj.hashCode()));
	}

	public static void useSingleton(){
		Singleton singleton = Singleton.getInstance();
		print("singleton",singleton);
	}
	public static void main(String [] args) throws Exception{
		/*
		 * Note: for using MultiThreaded Execution you need to comment below portion.
		 * 
		 */
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		print("s1",s1);
		print("s2",s2);

		//Using Reflection, we can violate the solo rule for having single instance for singleton pattern
		Class clazz = Class.forName("org.sri.javaPrograms.Singleton");
		Constructor<Singleton> cons = clazz.getDeclaredConstructor();
		cons.setAccessible(true);
		Singleton s3 = cons.newInstance();
		System.out.println("--- Reflection ---");

		print("s3",s3);

		//Using Serialization/De-serialization we can violate this single instance rule
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\serial.ser"));
		oos.writeObject(s2);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\serial.ser"));
		Singleton s4 = (Singleton) ois.readObject();
		System.out.println("--- Serialization/De-serialization ---");
		print("s4",s4);

		//Using Object Cloning we can violate this single instance rule
		Singleton s5 = (Singleton) s2.clone();
		System.out.println("--- Cloneable ---");
		print("s5",s5);

		//Using Multiple Threaded Environment we can violate this single instance rule
		ExecutorService service = Executors.newFixedThreadPool(2);
		System.out.println("--- MultiThread ---");
		service.submit(TestCase::useSingleton);
		service.submit(TestCase::useSingleton);
		service.shutdown();
	}
}
