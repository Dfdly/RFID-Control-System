 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
import java.util.Set;
import java.util.Vector;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public  class MainSvpeople extends JFrame{
	private DefaultTableModel model; 
	private JTable table;
	public MainSvpeople(){
			JBDC jdbc= new JBDC();
			
 			String[] colnames={"保管人ID","姓名","电话","邮箱","住址"}; 
 			model=new DefaultTableModel(colnames,100);
 			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		  GridLayout gl2 = new GridLayout(6, 1);
		  gl2.setVgap(20);
		table=new JTable(model); 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 380));
		getContentPane().add(scrollPane, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setLayout(gl2);
		getContentPane().add(panel, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("findbyID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Please input a ID"); 

				String savepersonID = "12",spname,phone,email,home;
				String driver = "com.mysql.jdbc.Driver";
		        String url = "jdbc:mysql://127.0.0.1:3306/rfid";
		        String user = "root";
		        String password = "135440";
		        String col="savepersonID";
		        String col1="spname";
		        String col2="phone";
		        String col3="email";
		        String col4="home";
		        int i=0;
		        try {
		            Class.forName(driver);
		            Connection conn = DriverManager.getConnection(url, user, password);
		            if(!conn.isClosed())
		                System.out.println("Succeeded connecting to the Database!");
		            Statement statement = conn.createStatement();
		            String sql = "select * from saveperson WHERE savepersonID="+inputValue;
		            ResultSet rs = statement.executeQuery(sql);
		            while(rs.next()) {

		                System.out.print(rs.getString(col) + "\t");
		                System.out.print("\n");
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col)),i,0); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col1)),i,1); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col2)),i,2); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col3)),i,3); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col4)),i,4); 

		                i++;
		            }
		            rs.close();
		            conn.close();
		        } catch(ClassNotFoundException e1) {
		            System.out.println("Sorry,can`t find the Driver!");
		            e1.printStackTrace();
		        } catch(SQLException e1) {
		            e1.printStackTrace();
		        } catch(Exception e1) {
		            e1.printStackTrace();
		        }
			
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("findbyname");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Please input a name"); 

				String savepersonID = "12",spname,phone,email,home;
				String driver = "com.mysql.jdbc.Driver";
		        String url = "jdbc:mysql://127.0.0.1:3306/rfid";
		        String user = "root";
		        String password = "135440";
		        String col="savepersonID";
		        String col1="spname";
		        String col2="phone";
		        String col3="email";
		        String col4="home";
		        int i=0;
		        try {
		            Class.forName(driver);
		            Connection conn = DriverManager.getConnection(url, user, password);
		            if(!conn.isClosed())
		                System.out.println("Succeeded connecting to the Database!");
		            Statement statement = conn.createStatement();
		            String sql = "select * from saveperson WHERE spname='"+inputValue+"'";
		            ResultSet rs = statement.executeQuery(sql);
		            while(rs.next()) {

		                System.out.print(rs.getString(col) + "\t");
		                System.out.print("\n");
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col)),i,0); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col1)),i,1); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col2)),i,2); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col3)),i,3); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col4)),i,4); 

		                i++;
		            }
		            rs.close();
		            conn.close();
		        } catch(ClassNotFoundException e1) {
		            System.out.println("Sorry,can`t find the Driver!");
		            e1.printStackTrace();
		        } catch(SQLException e1) {
		            e1.printStackTrace();
		        } catch(Exception e1) {
		            e1.printStackTrace();
		        }
			
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Please input a ID"); 
				JBDC delete=new JBDC();
				 String sql = "delete from saveperson WHERE savepersonID='"+inputValue+"'";
				delete.JDBCUpdate(sql);
			}
		});
		panel.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("add");
		panel.add(btnNewButton_3);
		
		JButton btnShowall = new JButton("showall");
		btnShowall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String savepersonID = "12",spname,phone,email,home;
				String driver = "com.mysql.jdbc.Driver";
		        String url = "jdbc:mysql://127.0.0.1:3306/rfid";
		        String user = "root";
		        String password = "135440";
		        String col="savepersonID";
		        String col1="spname";
		        String col2="phone";
		        String col3="email";
		        String col4="home";
		        int i=0;
		        try {
		            Class.forName(driver);
		            Connection conn = DriverManager.getConnection(url, user, password);
		            if(!conn.isClosed())
		                System.out.println("Succeeded connecting to the Database!");
		            Statement statement = conn.createStatement();
		            String sql = "select * from saveperson";
		            ResultSet rs = statement.executeQuery(sql);
		            while(rs.next()) {

		                System.out.print(rs.getString(col) + "\t");
		                System.out.print("\n");
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col)),i,0); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col1)),i,1); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col2)),i,2); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col3)),i,3); 
		                MainSvpeople.this.table.setValueAt(String.valueOf(rs.getString(col4)),i,4); 

		                i++;
		            }
		            rs.close();
		            conn.close();
		        } catch(ClassNotFoundException e1) {
		            System.out.println("Sorry,can`t find the Driver!");
		            e1.printStackTrace();
		        } catch(SQLException e1) {
		            e1.printStackTrace();
		        } catch(Exception e1) {
		            e1.printStackTrace();
		        }
			}
		});
		panel.add(btnShowall);
		
		JButton btnNewButton_4 = new JButton("back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mainframe();
				setVisible(false);
			}
		});
		panel.add(btnNewButton_4);
		btnNewButton_3.addActionListener(new LoginOKAction());
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 600) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 400) / 2;
		this.setLocation(w, h);
		this.setSize(620,400);
		this.setTitle("RFID\u7BA1\u7406\u7CFB\u7EDF");
		this.setTitle("保管人");
		this.setVisible(true);
		
	}
    private void JDBCQuery(String tname, String... cols){
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
            String sql = "select * from " + tname;
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                for (String col : cols)
                System.out.print(rs.getString(col) + "\t");
                System.out.print("\n");
            }
            rs.close();
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


	class LoginOKAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "添加保管者");
		new Svpeople();
	}
	}
}
