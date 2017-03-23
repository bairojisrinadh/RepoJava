package pac.jdbc;
//Directly connecting to databse
import java.sql.*;  
class MySql{
	
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://20.198.218.29:3306/amar","root","Rkumar@33");  
  
//here sonoo is database name, root is username and password  
  
Statement stmt=con.createStatement();  
  
ResultSet rs=stmt.executeQuery("select * from employee");  
  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  ");  
  
con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}
