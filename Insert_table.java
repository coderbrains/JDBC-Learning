package jdbc_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert_table {

	public static void main(String[] args)throws Exception {
		
		Login_through_credentails l = new Login_through_credentails();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		Statement st = c.createStatement();
		

	}

}
