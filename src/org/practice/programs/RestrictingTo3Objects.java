package org.practice.programs;

public class RestrictingTo3Objects {

	public static int count = 0;
	
	public RestrictingTo3Objects() throws Exception{
		count++;
		if(count <= 3){
			System.out.println("object creation successfull");
		}
		else throw new Exception("Object creation can't be done more than 3 times");
	}
	
	public static void main(String[] args) {
		try{
			RestrictingTo3Objects obj1 = new RestrictingTo3Objects();
			RestrictingTo3Objects obj2 = new RestrictingTo3Objects();
			RestrictingTo3Objects obj3 = new RestrictingTo3Objects();
			RestrictingTo3Objects obj4 = new RestrictingTo3Objects();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
