package com.sri.completeCoreJava.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectivity {

	public static void main(String... args) throws SQLException{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			statement = connection.createStatement();
			System.out.println(statement.toString());
			//insert(statement);
			//update(statement);
			delete(statement);
			resultSet = statement.executeQuery("select * from employee;");
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" : "+resultSet.getString(2)+", "+resultSet.getString(3));
			}
		}catch(Exception e){
			System.out.println("Any Exception Caught here!!");
			e.printStackTrace();
		}finally{
			if(resultSet != null || statement != null || connection != null){
				resultSet.close();
				statement.close();
				connection.close();
			}

		}
	}

	public static void delete(Statement statement) throws SQLException {
		System.out.println(statement.toString());
		statement.execute("delete from employee where id = 5;");
		System.out.println("Delete Successful");
	}
	
	public static void update(Statement statement) throws SQLException {
		System.out.println(statement.toString());
		statement.execute("update employee set salary = 76568 where id = 5;");
		System.out.println("Update Successful");
	}

	public static void insert(Statement statement) throws SQLException {
		System.out.println(statement.toString());
		statement.execute("insert into employee (id,name,salary) values (6,'blah', 34236);");
		System.out.println("Insert Successful");
	}
}
