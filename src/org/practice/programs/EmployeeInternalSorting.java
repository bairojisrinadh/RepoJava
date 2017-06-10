package org.practice.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EmployeeInternalSorting {

	public static void main(String[] args) {
		/*List<Employee> list = new ArrayList<>();
		list.add(new Employee("Mom",52938,29));
		list.add(new Employee("Mom",12138,30));
		list.add(new Employee("Che",75938,20));
		list.add(new Employee("Che",75938,19));
		list.add(new Employee("Dad",50038,21));
		list.add(new Employee("Srinadh",52938,25));
		
		//Iterator<Employee> it = set.iterator();
		Collections.sort(list);*/
		Set<Employee> set = new HashSet<>();
		set.add(new Employee("Mom",52938,29));
		set.add(new Employee("Mom",12138,30));
		set.add(new Employee("Che",75938,20));
		set.add(new Employee("Che",75938,19));
		set.add(new Employee("Dad",50038,21));
		set.add(new Employee("Srinadh",52938,25));
		
		
		List<Employee> list = new ArrayList<>(set);
		Collections.sort(list);
		Iterator<Employee> it = list.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}

}

class Employee implements Comparable<Employee>{
	private String name;
	private double salary;
	private int age;
	
	public Employee(String name, double salary, int age){
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Employee o) {
		int nameDiff = this.name.compareTo(o.name);
		if(nameDiff !=0){
			System.out.println("Name: "+nameDiff);
			return nameDiff;
		}else if(o.salary >= 0.0 && this.salary != o.salary){
			System.out.println("Salary: "+(this.salary < o.salary ? -1 : (this.salary > o.salary ? 1 : 0)));
			return this.salary < o.salary ? -1 : (this.salary > o.salary ? 1 : 0);
		}else if(o.age > 0 && this.age != o.age){
			System.out.println("Age: "+(this.age < o.age ? -1 : (this.age > o.age ? 1 : 0)));
			return this.age < o.age ? -1 : (this.age > o.age ? 1 : 0);
		}
		return 0;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age
				+ "]";
	}
	
}