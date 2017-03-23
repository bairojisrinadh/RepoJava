package org.sri;

import java.io.*;
import java.util.Properties;

public class JdbcPropertyReader {

	private static Properties props = new Properties();
    private static JdbcPropertyReader propFileRdr = null;
    
    public JdbcPropertyReader(){
    	
    	InputStream inStream = null;
        try {
          ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
          inStream = classLoader.getResourceAsStream("jdbc.properties");
          System.out.println("In JdbcPropertyReader, classLoader : " + classLoader);
          System.out.println("In JdbcPropertyReader, inStream : " + inStream);

          props.load(inStream);
          inStream.close();
        } catch (FileNotFoundException fe) {
          System.out.println(fe);        }
        catch (IOException ie) {
          System.out.println(ie);
        } 
    }
    
    public static JdbcPropertyReader getInstance() {
    	if (propFileRdr == null) {
    	      propFileRdr = new JdbcPropertyReader();
    	    }
    	    return propFileRdr;
    }

	public static void main(String[] args) {
		JdbcPropertyReader jdbc = new JdbcPropertyReader();
		Object p = JdbcPropertyReader.getInstance();
		
		
	}

}
