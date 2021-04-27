package jdbc_Connection;
/**
 * @author Awanish kumar singh
 */

import java.sql.*;

public class Insert_table {

	public static void main(String[] args)throws Exception {
		
		Login_through_credentails l = new Login_through_credentails();
		
		int roll = 6;
		String name = "Marry";
		String branch = "EE";
		
		//Method - 1 : for insertion of values........
		
//		String query = "insert into Student values(" + roll + ",'" + name + "','" + branch +"')";
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
//		Statement st = c.createStatement();
//		
//		int rows = st.executeUpdate(query);
//		
//		System.out.println(rows + " rows affected");
		
		
		//Method-2 : For insertion of values..........
		
		String query = "insert into Student values(?,?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");	// Used to Load The Driver,	
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		
		PreparedStatement st = c.prepareStatement(query);
		st.setInt(1, roll);
		st.setString(2, name);
		st.setString(3, branch);
		int rows = st.executeUpdate();
		System.out.println(rows + " rows affected");
		
		

	}

}
