package jdbc_Connection;
import java.sql.*;

public class Connect_MySQL {

	public static void main(String[] args)throws Exception {
		Login_through_credentails l = new Login_through_credentails();
		String sql = "select * from Manish";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next() != false) {
			String name = rs.getString(1);
			System.out.println(name);
		}
		
		c.close();
		st.close();
		
		

	}

}
