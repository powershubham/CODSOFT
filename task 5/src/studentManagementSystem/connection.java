package studentManagementSystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
    Connection c;
    Statement s;

    public void Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/studmanagement", "root", "Sharma@#1");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

