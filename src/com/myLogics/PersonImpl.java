package com.myLogics;

public class PersonImpl {

	public static void main(String[] args) {
		Employee employee = new Employee();
		PersonDo farmer = new Farmer();
		/*try{
			throw new Exception ();
		}catch(Throwable ex){
			ex.printStackTrace();
		}*/
		int[] arr = new int[5];
		int length = arr.length;
		System.out.println(farmer.value);
		System.out.println(employee.value);
		employee.eat();
		farmer.eat();
		employee.work();
		farmer.work();
		((Farmer) farmer).stay();
		employee.hasVehicle();
		farmer.hasVehicle();
	}

}


abstract class PersonDo{
	
	public PersonDo(){
		System.out.println("PersonDo() constrctor");
	}
	
	public String value = "PersonDo";
	public void eat(){
		System.out.println("Person will eat using mouth");
	}
	
	abstract void work();
	
	void hasVehicle(){
		System.out.println("MotorVehicle");
	}
}

class Employee extends PersonDo{

	public String value = "Employee";
	@Override
	void work() {
		System.out.println("Employee will work in office");
	}
	
	void hasVehicle(){
		System.out.println("Bike");
	}
}

class Farmer extends PersonDo{

	public String value = "Farmer";
	@Override
	void work() {
		System.out.println("Farmer will work on field");
	}
	
	void stay(){
		System.out.println("Farmer stay in village");
	}
	
	void hasVehicle(){
		System.out.println("Tractor");
	}
}