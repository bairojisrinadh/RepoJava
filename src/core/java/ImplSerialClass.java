package core.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ImplSerialClass {

/* Below main method is to write the SerialClass object data into file ImplSerialClass.txt*/
	/*public static void main(String[] args) throws IOException {
		SerialClass s = new SerialClass("Srinadh",401,"Jawahar High School");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\ImplSerialClass.txt");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(s);
		os.flush();
		System.out.println("Success");
	}*/
	

/* Below main method is to read serialized SerialClass object data from file ImplSerialClass.txt*/
	public static void main (String [] args) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\ImplSerialClass.txt");
		ObjectInputStream is = new ObjectInputStream(fis);
		SerialClass s = (SerialClass) is.readObject();
		System.out.println("Name: "+s.getName());
		System.out.println("Roll No.: "+s.getRollNo() );
		System.out.println("School: "+s.getSchool());
	}

}
