package com.sri.completeCoreJava;

/*
 * We can't guarantee that when will the objects would be garbage collected once called System.gc()
 * it all depends on JVM
 */
import java.util.List;
import java.util.Vector;

public class GarbageCollectorTest {

	public static void main(String[] args) {
		Mobile moto = new Mobile("Moto");
		Mobile mi = new Mobile("Mi");
		
		List<Mobile> vector = new Vector<>();
		vector.add(moto);
		vector.add(mi);
		
		moto = null;
		System.out.println("System.GC called once..");
		System.gc();
		
		vector = null;
		System.out.println("System.GC called twice..");
		System.gc();
		
		mi = null;
		System.out.println("System.GC called again..");
		System.gc();
		System.out.println("End of main..");
	}

}


class Mobile{
	private String name;
	
	public Mobile(String name){
		this.name = name;
	}
	
	public void finalize() throws Throwable{
		System.out.println(name+" has been garbage collected !!");
		super.finalize();
	}
}