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
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public  class RFID extends JFrame{
	private DefaultTableModel model; 
	private JTable table;
	public RFID(){
 			this.JDBCUpdate("create table saveperson(" +
                "savepersonID char(7) not null primary key," +
                "spname char(7) not null," +
                "phone char(11)," +
                "email char(20),"+
                "home char(20))"
               );
		
 			this.JDBCUpdate("create table incharge(" +
                "inchargeID char(7) not null primary key," +
                "icname char(7) not null," +
                "phone char(11)," +
                "email char(20),"+
                "home char(20))"
               );
		
 			this.JDBCUpdate("create table equipment(" +
                "eno char(7) not null primary key," +
                "rno char(7) not null," +
                "ename char(7)," +
                "etype char(7),"+
                "outno char(7),"+
                "place char(7),"+
                "savepersonID char(7),"+
                "inchargeID char(7),"+
                "buytime date,"+
                "foreign key(inchargeID)references incharge(inchargeID)on delete set null on update cascade,"+
                "foreign key(savepersonID)references saveperson(savepersonID)on delete set null on update cascade)"
               );
 			
 			String[] colnames={"设备ID","RFIDID","名称","型号","出厂编号","存放地点","保管人","责任人","购买时间"}; 
 			model=new DefaultTableModel(colnames,100);
 			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


		  GridLayout gl2 = new GridLayout(6, 1);
		  gl2.setVgap(20);
		  table=new JTable();
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
				String inputValue = JOptionPane.showInputDialog("Please input a equipment ID"); 

				String driver = "com.mysql.jdbc.Driver";
		        String url = "jdbc:mysql://127.0.0.1:3306/rfid";
		        String user = "root";
		        String password = "135440";
		        String col="eno";
		        String col1="rno";
		        String col2="ename";
		        String col3="etype";
		        String col4="outno";
		        String col5="place";
		        String col6="savepersonID";
		        String col7="inchargeID";
		        String col8="buytime";
		        int i=0;
		        try {
		            Class.forName(driver);
		            Connection conn = DriverManager.getConnection(url, user, password);
		            if(!conn.isClosed())
		                System.out.println("Succeeded connecting to the Database!");
		            Statement statement = conn.createStatement();
		            String sql = "select * from equipment WHERE eno="+inputValue;
		            ResultSet rs = statement.executeQuery(sql);
		            while(rs.next()) {
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col)),i,0); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col1)),i,1); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col2)),i,2); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col3)),i,3); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col4)),i,4); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col5)),i,5); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col6)),i,6); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col7)),i,7); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col8)),i,8); 

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
				String inputValue = JOptionPane.showInputDialog("Please input a equipment ID"); 

				String driver = "com.mysql.jdbc.Driver";
		        String url = "jdbc:mysql://127.0.0.1:3306/rfid";
		        String user = "root";
		        String password = "135440";
		        String col="eno";
		        String col1="rno";
		        String col2="ename";
		        String col3="etype";
		        String col4="outno";
		        String col5="place";
		        String col6="savepersonID";
		        String col7="inchargeID";
		        String col8="buytime";
		        int i=0;
		        try {
		            Class.forName(driver);
		            Connection conn = DriverManager.getConnection(url, user, password);
		            if(!conn.isClosed())
		                System.out.println("Succeeded connecting to the Database!");
		            Statement statement = conn.createStatement();
		            String sql = "select * from equipment WHERE ename='"+inputValue+"'";
		            ResultSet rs = statement.executeQuery(sql);
		            while(rs.next()) {
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col)),i,0); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col1)),i,1); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col2)),i,2); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col3)),i,3); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col4)),i,4); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col5)),i,5); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col6)),i,6); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col7)),i,7); 
		                RFID.this.table.setValueAt(String.valueOf(rs.getString(col8)),i,8); 

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
				String inputValue = JOptionPane.showInputDialog("Please input a equipment ID"); 
				JBDC delete=new JBDC();
				 String sql = "delete from equipment WHERE eno='"+inputValue+"'";
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
			        String col="eno";
			        String col1="rno";
			        String col2="ename";
			        String col3="etype";
			        String col4="outno";
			        String col5="place";
			        String col6="savepersonID";
			        String col7="inchargeID";
			        String col8="buytime";
			        int i=0;
			        try {
			            Class.forName(driver);
			            Connection conn = DriverManager.getConnection(url, user, password);
			            if(!conn.isClosed())
			                System.out.println("Succeeded connecting to the Database!");
			            Statement statement = conn.createStatement();
			            String sql = "select * from equipment";
			            ResultSet rs = statement.executeQuery(sql);
			            while(rs.next()) {
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col)),i,0); 
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col1)),i,1); 
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col2)),i,2); 
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col3)),i,3); 
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col4)),i,4); 
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col5)),i,5); 
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col6)),i,6); 
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col7)),i,7); 
			                RFID.this.table.setValueAt(String.valueOf(rs.getString(col8)),i,8); 

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
		this.setVisible(true);
		
	}
	
    private void JDBCUpdate(String sql){
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


	class LoginOKAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "添加设备");
		new AddRFID();
	}
	}
}
