package com.highradius;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEmployee{
	public static void main(String... args){
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("ashwini",22, 6000));
		list.add(new Employee("BennyMoses",23, 14000));
		list.add(new Employee("Ash",20, 9000));
		/*sortByAge(list);
		sortBySalary(list);
		sortByName(list);
		sortByAgeWithoutCollectionAPI(list);
		sortBySalaryWithoutCollectionAPI(list);*/
		sortByNameWithoutCollectionAPI(list);
	}

	public static void sortBySalaryWithoutCollectionAPI(List<Employee> list) {
		System.out.println("sortBySalaryWithoutCollectionAPI Method");
		Employee temp = null;
		for(int i= 0; i < list.size(); i++){
			double salary1 = list.get(i).getSalary();
			for(int j=i+1; j< list.size(); j++){
				double salary2 = list.get(j).getSalary();
				if(salary1>salary2){
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		for(Employee emp: list){
			System.out.println(emp.toString());
		}
		System.out.println();
	}

	public static void sortByAgeWithoutCollectionAPI(List<Employee> list) {
		System.out.println("sortByAgeWithoutCollectionAPI Method");
		Employee temp = null;
		for(int i= 0; i < list.size(); i++){
			int age1 = list.get(i).getAge();
			for(int j=i+1; j< list.size(); j++){
				int age2 = list.get(j).getAge();
				if(age1>age2){
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		for(Employee emp: list){
			System.out.println(emp.toString());
		}
		System.out.println();
	}

	public static void sortByNameWithoutCollectionAPI(List<Employee> list) {
		System.out.println("sortByNameWithoutCollectionAPI Method");
		Employee temp = null;
		for(int i = 0; i < list.size(); i++){
			int tmp = 0;
			String emp1 = list.get(i).getName().toLowerCase();
			for(int j = i + 1; j < list.size(); j++){
				String emp2 = list.get(j).getName().toLowerCase();
				int val = emp1.compareTo(emp2);
				//System.out.println(val); --> Use this to print the value of String class overridden method 'compareTo' of Comparable Interface
				if(val >= tmp){
					tmp = val;
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j,temp);
				}
			}
		}
		for(Employee emp : list){
			System.out.println(emp.toString());
		}
		System.out.println();
	}

	public static void sortByName(List<Employee> list) {
		System.out.println("sortByName Method");
		Collections.sort(list, (e1,e2) -> { return e1.getName().compareTo(e2.getName());});
		for(Employee emp : list){
			System.out.println(emp.toString());
		}	
		System.out.println();
	}
	public static void sortByAge(List<Employee> list) {
		System.out.println("sortByAge Method");
		Collections.sort(list, (e1,e2) -> {return e1.getAge()>e2.getAge()? 1 : -1;});
		for(Employee emp : list){
			System.out.println(emp.toString());
		}	
		System.out.println();
	}

	public static void sortBySalary(List<Employee> list) {
		System.out.println("sortBySalary Method");
		Collections.sort(list, (e1,e2) -> {return e1.getSalary()>e2.getSalary()? 1 : -1;});
		for(Employee emp : list){
			System.out.println(emp.toString());
		}
		System.out.println();
	}

}

class Employee{
	private String name;
	private int age;
	private double salary;

	public Employee(String name, int age, double salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary
				+ "]";
	}


}