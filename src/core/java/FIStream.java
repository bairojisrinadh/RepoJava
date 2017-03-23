package core.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIStream {

	public static void main(String[] args) throws IOException {
		int ch;
		FileOutputStream output = null;
		try(FileInputStream input = new FileInputStream("C://Ddrive//demo.txt")){
			//output = new FileOutputStream("D://demo1.txt");
			while((ch = input.read()) > 0){
				System.out.print((char)ch);	
				//output.write(ch);
			}
			System.out.println("\nCopied Successfully");
		}finally{
			/*if(output != null)
				output.close();*/
		}
	/*try(FileInputStream input = new FileInputStream("D://demo.txt")){
		int ch;
		while( (ch=input.read()) != -1){
		System.out.println((char)ch);
		}
		}
		catch(IOException ioe){
		ioe.printStackTrace();
		}*/

}
}