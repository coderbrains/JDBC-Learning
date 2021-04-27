package jdbc_Connection;
import java.sql.*;

import java.sql.DriverManager;

public class CreateTable {

	public static void main(String[] args)throws Exception {
		
		Login_through_credentails l = new Login_through_credentails();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		
		String query = "create table Sunish(roll int, name varchar(50))";
		
		Statement st = c.createStatement();
		st.executeUpdate(query);
		
		System.out.println("table created in databases");
		
		c.close();

	}

}
