package com.myLogics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		list.add(new Practice2().new Employee("Srinadh",23,11000));
		list.add(new Practice2().new Employee("Srinadh",24,12000));
		list.add(new Practice2().new Employee("Srinadh",23,12000));
		list.add(new Practice2().new Employee("srinadh",21,11000));
		list.add(new Practice2().new Employee("srinadh",24,12000));
		list.add(new Practice2().new Employee("srinadh",21,12000));
		list.add(new Practice2().new Employee("Srinadh",23,11000));
		list.add(new Practice2().new Employee("SRINADH",23,11000));
		list.add(new Practice2().new Employee("Divya",19,13000));
		list.add(new Practice2().new Employee("Ramya",24,12000));
		list.add(new Practice2().new Employee("Manikantha",20,11000));
		list.add(new Practice2().new Employee("Mani",22,10000));
		
		Collections.sort(list);  //Provides Natural Ordering,This sort() of Collections class  implements Comparable interface, So Object/Reference type class should provide implementation for comapareTo() method of Comparable interface. 
		Collections.sort(list, new Practice2().new Employee().new EmployeeOrderByAge());  //Provides Arbitrary Ordering,Here we are sorting using Comparator Interface as second argument object of Collectios.sort(List list, Comparator Object/Implementation).So we have provided implementation for 
																							   //Comparator interface in respective	class and passed that object as an argument.
		Collections.sort(list, new Practice2().new Employee().new EmployeeOrderBySalary());
		for(Employee emp : list){
			System.out.println(emp.toString());
		}
	}

	private class Employee implements Comparable<Employee>{
		private String name;
		private int age;
		private double salary;
		
		public Employee(){
			
		}
		
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
		
		//Can implement Comparable interface and override compareTo() method for natural ordering
		//i.e, if String Objects are considered then return lexicographically, else if primitive types
		//are used then return in ascending order. Also make sure u are not violating equals contract for equal elements/Objects.
		@Override
		public int compareTo(Employee o) {
			int nameDiff = this.getName().compareTo(o.getName());
			if(nameDiff != 0){
			return nameDiff;
			}
			int ageDiff = this.getAge() < o.getAge() ? -1 : (this.getAge() > o.getAge() ? 1 : 0);
			if(ageDiff != 0){
				return ageDiff;
			}
			return this.getSalary() < o.getSalary() ? -1 : (this.getSalary() > o.getSalary() ? 1 : 0);
		}
		
		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + ", salary="
					+ salary + "]";
		}
		
		private class EmployeeOrderByAge implements Comparator<Employee>{

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getAge() < o2.getAge() ? -1 : (o1.getAge() > o2.getAge() ? 1 : 0);
			}
		}
		
		private class EmployeeOrderBySalary implements Comparator<Employee>{

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() < o2.getSalary() ? -1 : (o1.getSalary() > o2.getSalary() ? 1 : 0);
			}
		}
	}
}
