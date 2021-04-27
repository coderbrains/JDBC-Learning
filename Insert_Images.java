package jdbc_Connection;

import java.io.FileInputStream;
import java.sql.*;

public class Insert_Images {

	public static void main(String[] args)throws Exception {
		
		Login_through_credentails l = new Login_through_credentails();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		
		String sql = "insert into images(pic) values(?)";
		
		PreparedStatement st = c.prepareStatement(sql);
		
		FileInputStream f = new FileInputStream("D:\\new\\a.jpg");
		
		st.setBinaryStream(1, f, f.available());
		
		st.executeUpdate();
		
		System.out.println("Done....");
		
		c.close();

	}

}
