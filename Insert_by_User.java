package jdbc_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert_by_User {

	public static void main(String[] args)throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		Login_through_credentails l = new Login_through_credentails();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		String query = "insert into sunish values(?,?)";
		
		PreparedStatement st = c.prepareStatement(query);
		
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Roll :");
		int roll = sc.nextInt();
		
		st.setInt(1, roll);
		st.setString(2, name);
		
		int rows = st.executeUpdate();
		
		System.out.println(rows + " rows affected");
		
		
		sc.close();
		

	}

}
