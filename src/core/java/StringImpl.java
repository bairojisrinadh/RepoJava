package core.java;

import java.util.StringTokenizer;

public class StringImpl {

	public static void main(String[] args) {
		String s1 = "srinadh";
		String s2 = "srinadh";
		String s3 = new String("srinadh").intern();
		System.out.println(s1==s3?true:false);
		System.out.println(s2.indexOf("adh"));
		
		StringTokenizer st = new StringTokenizer("Biroji. Srinadh", ".");
		System.out.println("count: "+st.countTokens());
		String value="";
		
		while(st.hasMoreTokens()){
			value +=st.nextElement();
			
		}
		System.out.println(value);
	}
}
