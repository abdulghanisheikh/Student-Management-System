package com.student.manage;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionProvider {
    static Connection con;
    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/student_manage";
            con = DriverManager.getConnection(url, username, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) {
        if(createConnection() != null) {
            System.out.println("Connected Successfully");
        } else {
            System.out.println("Oops!");
        }
    }
}
