package jdbc_Connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Update_Table {

	public static void main(String[] args) throws Exception {
		
		Login_through_credentails l = new Login_through_credentails();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		String sql = "update student set roll = ?, name = ?, branch = ? where roll = ?";
		PreparedStatement st = c.prepareStatement(sql);
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter roll : ");
		int roll = Integer.parseInt(buffer.readLine());
		
		System.out.println("Enter name : ");
		String name = buffer.readLine();
		
		System.out.println("Enter branch : ");
		String branch = buffer.readLine();
		
		st.setInt(1	, roll);
		st.setString(2, name);
		st.setString(3, branch);
		
		System.out.println("Enter roll where you want to update : ");
		int roll1 =  Integer.parseInt(buffer.readLine());
		
		st.setInt(4, roll1);
		
		st.executeUpdate();
		
		System.out.println("Success.....");
		
		c.close();
		
		
	}

}
