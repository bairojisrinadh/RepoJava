package com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamsWithEmpObjects {

	public static void main(String[] args) {
		StreamsWithEmpObjects.Employee emp1 = new StreamsWithEmpObjects.Employee("Srinadh",24,50000);
		StreamsWithEmpObjects.Employee emp2 = new StreamsWithEmpObjects.Employee("Chethana",24,75000);
		StreamsWithEmpObjects.Employee emp3 = new StreamsWithEmpObjects.Employee("Mani",21,55000);
		StreamsWithEmpObjects.Employee emp4 = new StreamsWithEmpObjects.Employee("Benny",23,150000);
		StreamsWithEmpObjects.Employee emp5 = new StreamsWithEmpObjects.Employee("Rammi",20,65000);
		
		List<StreamsWithEmpObjects.Employee> list = Arrays.asList(emp1,emp2,emp3,emp4,emp5);
		Collections.sort(list);
		double totalSalary = list.stream().filter(e -> e.getSalary() > 70000)
							 .mapToDouble(e -> e.getSalary())
							 .sum();
		System.out.println(totalSalary);
	}	

	private static class Employee implements Comparable<Employee>{
		private String empName;
		private int age;
		private double salary;
		
		public Employee(String empName, int age, double salary) {
			super();
			this.empName = empName;
			this.age = age;
			this.salary = salary;
		}
		
		public double getSalary(){
			return this.salary;
		}
		
		@Override
		public String toString(){
			return "Emp[ Name = " + this.empName + ", Age = " + this.age +", Salary = "+
					+ this.salary + "]";
		}

		@Override
		public int compareTo(Employee o) {
			if(o instanceof Employee){
				Employee e = (Employee) o;
				return this.empName.compareTo(e.empName);
			}
			return 0;
		}
	}
}
