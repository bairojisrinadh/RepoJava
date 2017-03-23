package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class PredicateImpl {

	public static final int age = 20;
	
	public static void main(String[] args) {
		
		
		Employee e1 = new  Employee(1, "Srinadh",'M',24);
		Employee e2 = new  Employee(2, "Ramya",'M',18);
		Employee e3 = new  Employee(3, "Mani",'M',46);
		Employee e4 = new  Employee(4, "Divya",'F',31);
		Employee e5 = new  Employee(5, "Ash",'F',20);
		Employee e6 = new  Employee(6, "Benny",'M',55);
		
		List<Employee> employees = new ArrayList<>();
		employees.addAll(Arrays.asList(e1,e2,e3,e4,e5,e6));
		
		System.out.println("Adult Male Employees: "+EmployeePredicate.filterEmployee(employees,EmployeePredicate.isAdultMale()));
		System.out.println("Adult Female Employees: "+EmployeePredicate.filterEmployee(employees,EmployeePredicate.isAdultFemale()));
		System.out.println("Employees, Age > "+age+": "+EmployeePredicate.filterEmployee(employees,EmployeePredicate.isAgeMoreThan(age)));
		System.out.println("Employees, Age < "+age+": "+EmployeePredicate.filterEmployee(employees,EmployeePredicate.isAgeMoreThan(age).negate()));
		
	}

}

class Employee{
	private Integer id;
	private String name;
	private Character gender;
	private Integer age;
	
	
	public Employee(Integer id, String name, Character gender, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "[Name=" + name + ",  age=" + age + "]";
	}
		
}

class EmployeePredicate{	
	
	public static Predicate<Employee> isAdultMale(){
		return p -> p.getAge()>18 && p.getGender().equals('M');
	}
	
	public static Predicate<Employee> isAdultFemale(){
		return p -> p.getAge()>18 && p.getGender().equals('F');
	}
		
	public static Predicate<Employee> isAgeMoreThan(Integer age){
		return p -> p.getAge()>age;
	}
	
	public static List<Employee> filterEmployee(List<Employee> employees,Predicate<Employee> predicate){
		return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
	}
}