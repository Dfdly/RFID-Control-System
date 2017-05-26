/**
 * Created by yangfd on 2016/10/31.
 */
import java.sql.*;
public class JDBCTest {
    public static void main(String[] args){
        JDBCTest jt = new JDBCTest();
        /*
        jt.JDBCUpdate("insert into student values('a132564','杨国福','男','1996-12-02','160.00');");
        jt.JDBCUpdate("insert into student values('a132568','牛国福','女','1996-12-26','180.00');");
        jt.JDBCQuery("student", "sno", "sname", "height");
        jt.JDBCUpdate("delete from student where sname = '牛国福';");
        jt.JDBCQuery("student", "sno", "sname");*/
        jt.JDBCUpdate("create table grade(" +
                "sno char(7) not null," +
                "grade int," +
                " check (grade>=0 and grade <=100)); ");
        jt.JDBCUpdate("insert into grade values('a132568','89');");
        jt.JDBCQuery("grade", "sno");

    }
    private void JDBCUpdate(String sql){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/jschematest";
        String user = "root";
        String password = "IMZZY961226";
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
        String url = "jdbc:mysql://127.0.0.1:3306/jschematest";
        String user = "root";
        String password = "IMZZY961226";
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

