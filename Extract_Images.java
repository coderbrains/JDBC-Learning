package jdbc_Connection;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Extract_Images {

	public static void main(String[] args) {
		new frame();
		
	}

}

@SuppressWarnings("serial")
class frame extends JFrame{
	
	frame(){
		Container c = getContentPane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		setBounds(200, 100, 800, 600);
		
		Font f = new Font("arial", Font.BOLD, 20);
		
		JTextField j = new JTextField();
		j.setFont(f);
		j.setBounds(200, 100, 150, 50);
		add(j);
		
		JButton j1 = new JButton();
		j1.setText("Show Images");
		j1.setBounds(370, 100, 150, 50);
		add(j1);
		
		JLabel l = new JLabel();
		l.setBounds(100, 200, 600, 400);
		add(l);
		
		j1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(j.getText().toString()); 
				String query = "select pic from images where id = ?";
				Login_through_credentails l1 = new Login_through_credentails();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection(l1.url, l1.user, l1.pass);
					PreparedStatement st = c.prepareStatement(query);
					ImageIcon icon = null;
					st.setInt(1, id);
					ResultSet rs = st.executeQuery();
					
					if(rs.next()) {
						Blob b = rs.getBlob("pic");
						InputStream fs = b.getBinaryStream();
						Image image = ImageIO.read(fs);
						icon = new ImageIcon(image);
						
						l.setIcon(icon);
						
					}else {
						l.setIcon(null);
						JOptionPane.showMessageDialog(null, "No Image with this Id");
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
		setVisible(true);
		c.revalidate();
	}
}
