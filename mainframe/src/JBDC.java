import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JBDC {
	   void JDBCUpdate(String sql){
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
}
