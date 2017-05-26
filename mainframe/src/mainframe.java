import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class mainframe extends JFrame{
	public mainframe() {
		JBDC jbdc=new JBDC();
		jbdc.JDBCUpdate("create table saveperson(" +
                "savepersonID char(7) not null primary key," +
                "spname char(7) not null," +
                "phone char(11)," +
                "email char(20),"+
                "home char(20))"
               );
		
		jbdc.JDBCUpdate("create table incharge(" +
                "inchargeID char(7) not null primary key," +
                "icname char(7) not null," +
                "phone char(11)," +
                "email char(20),"+
                "home char(20))"
               );
		
		jbdc.JDBCUpdate("create table equipment(" +
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
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblRfid = new JLabel("RFID\u7BA1\u7406\u5E73\u53F0");
		panel.add(lblRfid);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("RFID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RFID();
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("保管人");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainSvpeople();
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("责任人");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainIncharge();
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton_2);
		  GridLayout gl2 = new GridLayout(5, 1);
		  gl2.setVgap(3);
			panel_1.setLayout(gl2);
			int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 405) / 2;
			int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 195) / 2;
			this.setLocation(w, h);
			this.setVisible(true);
			this.setSize(405, 195);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		  
	}
	
	public static void main(String[] args) {
		mainframe mainframe=new mainframe();
	}
}
