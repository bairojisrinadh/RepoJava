package com.sri.completeCoreJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//Important Links

/*
 * Sample Program to read data from the file
 */
public class FileReading {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\Important Links");
		FileReader fd = new FileReader(file);
		BufferedReader br = new BufferedReader(fd);
		String line = null;
		while((line = br.readLine()) != null ){
			StringTokenizer st = new StringTokenizer(line, "-");
			while(st.hasMoreTokens()){
			System.out.println(st.nextElement());
			}
		}
	}

}
