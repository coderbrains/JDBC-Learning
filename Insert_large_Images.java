package jdbc_Connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Insert_large_Images {

	public static void main(String[] args)throws Exception {
		
		Login_through_credentails l = new  Login_through_credentails();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection(l.url, l.user, l.pass);
		
		String query = "insert into images(pic)values(?)";
		
		PreparedStatement st = c.prepareStatement(query);
		
		JFileChooser file = new JFileChooser();
		
		file.showOpenDialog(null);
		
		java.io.File files = file.getSelectedFile();
		
		FileInputStream fs = new FileInputStream(files);
		
		st.setBinaryStream(1, fs);
		
		st.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Success");

	}

}
