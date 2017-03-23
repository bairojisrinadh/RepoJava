package core.java;

public class MethodCallOnNullObject {
	
	public String str2 = "MyName";
	static String str = "Srinadh";
	static String str1 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try{
			System.out.println("In equals try block");
			if(str.equals(str1)){
				System.out.println("str1 value is: "+ str);
			}else{
				System.out.println("Both Strings are not same: "+ str1);
			}
		}catch(NullPointerException e){
			System.out.println("Runtime Exception: Method Call on NULL object is not acceptable");
			e.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try{
			System.out.println("In hashcode try block");
			int x = str1.hashCode();
			System.out.println(x);
		}catch(NullPointerException e){
			System.out.println("Runtime Exception: Method Call on NULL object is not acceptable");
			e.printStackTrace();
		}
	}

}
