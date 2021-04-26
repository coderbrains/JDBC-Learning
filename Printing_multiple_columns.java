package jdbc_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Printing_multiple_columns {

	public static void main(String[] args) throws Exception{
		
		Login_through_credentails l = new Login_through_credentails();
		String sql = "select * from Student";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(sql);
		String student = "";
		
		while(rs.next()) {
			student = rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3);
			System.out.println(student);
		}
		
		
		st.close();
		c.close();
		
		

	}

}
