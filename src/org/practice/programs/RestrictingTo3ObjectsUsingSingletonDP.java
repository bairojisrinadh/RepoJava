package org.practice.programs;

public class RestrictingTo3ObjectsUsingSingletonDP {

	private static RestrictingTo3ObjectsUsingSingletonDP obj;
	public static int count = 0;
		
	private RestrictingTo3ObjectsUsingSingletonDP(){
		System.out.println("Private Constructor invoked");
		count++;
	}
	
	public static RestrictingTo3ObjectsUsingSingletonDP getInstance(){
		if(count < 3){
			obj = new RestrictingTo3ObjectsUsingSingletonDP();
		}
		return obj;		
	}
	public static void main(String[] args) {
		
			RestrictingTo3ObjectsUsingSingletonDP obj1 = getInstance();
			RestrictingTo3ObjectsUsingSingletonDP obj2 = getInstance();
			RestrictingTo3ObjectsUsingSingletonDP obj3 = getInstance();
			RestrictingTo3ObjectsUsingSingletonDP obj4 = getInstance();
			RestrictingTo3ObjectsUsingSingletonDP obj5 = getInstance();
		
			System.out.print(obj1.hashCode()+ " " +obj2.hashCode()+ " " +obj3.hashCode()+ " " +
					obj4.hashCode()+ " " +
					obj5.hashCode());
	}

}
