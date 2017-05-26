import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Svpeople extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public Svpeople() {
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnOk = new JButton("OK");
		panel_2.add(btnOk);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ID");
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("电话");
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("邮箱");
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("住址");
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);
		btnOk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				this.JDBCUpdate("INSERT INTO saveperson VALUES" +"("+textField.getText()+
		                ",'" +textField_1.getText()+
		                "'," +textField_2.getText()+
		                ",'" +textField_3.getText()+
		                "','"+textField_4.getText()+
		                "')"
		               );

				setVisible(false);
			}

			private void JDBCUpdate(String sql) {
				// TODO Auto-generated method stub

			        String driver = "com.mysql.jdbc.Driver";
			        String url = "jdbc:mysql://127.0.0.1:3306/rfid";
			        String user = "root";
			        String password = "135440";
			        try {
			            Class.forName(driver);
			            Connection conn = DriverManager.getConnection(url, user, password);
			            if(!conn.isClosed())
			                System.out.println("Succeeded connecting to the Database!");
			            Statement statement = conn.createStatement();
			            statement.execute(sql);
			            System.out.println("Update Successfully!");
			            conn.close();
			        } catch(ClassNotFoundException e) {
			            System.out.println("Sorry,can`t find the Driver!");
			            e.printStackTrace();
			        } catch(SQLException e) {
			            e.printStackTrace();
			        } catch(Exception e) {
			            e.printStackTrace();
			        }
			    }
			


			});
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 625) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 148) / 2;
		this.setLocation(w, h);
		this.setVisible(true);
		this.setSize(625, 148);
	}

	
}
