package com.hibernate.learning;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDriver {

	private static SessionFactory sessionFactory;
	public static void main(String[] args) {
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Failed to Create SessionFactory :" +ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		TestDriver t = new TestDriver();
		/*call addEmployee method to add new Employee Details to DB*/
		
		//Integer empID1=t.addEmployee("Benny","Moses",32000);
		
		//System.out.println("Inside main() method,Last Line :" + empID1);
		
		/*call deleteEmployee method to delete Employee Details from DB*/
		t.deleteEmployee("Srinadh");
		
		/*call fetchAllEmployee method to retrieve all Employee Details from DB*/
		t.fetchAllEmployee();
	}
	
	
	@SuppressWarnings("unchecked")
	public void fetchAllEmployee() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<Object[]> emp = session.createSQLQuery("select * FROM employee").list();
			for (Object[] emps : emp){
				String firstName = (String) emps[1];
				String lastName = (String) emps[2];
				BigInteger salary = (BigInteger) emps[3];
				System.out.print("FirstName: " + firstName +"\t");
				System.out.print("LastName: " + lastName+"\t");
				System.out.println("Salary: " + salary );
			}
			/*List<Employee> employees = session.createSQLQuery("select * from public.employee").list();
			for(Iterator<Employee> iterator = employees.iterator();iterator.hasNext();){
				Employee emp = (Employee)iterator.next();
				System.out.print("FirstName: " +emp.getFirstName());
				System.out.print("LastName: " +emp.getLastName());
				System.out.println("Salary: " +emp.getSalary());
			}*/
			
		}catch(HibernateException e){
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}


	public Integer addEmployee(String fname, String lname, int salary) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try{
			tx = session.beginTransaction();
			Employee Employee = new Employee(fname,lname,salary);
			employeeID = (Integer) session.save(Employee);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();;
		}finally{
			session.close();
		}
		return employeeID;
	}
	
	public void deleteEmployee(String fname){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			String query = "delete FROM Employee WHERE firstname = '"+fname+"'";
			Object delete =session.createQuery(query);
			session.delete(delete);
			tx.commit();
			System.out.println("Record " +fname+ " has been deleted.");
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

}
