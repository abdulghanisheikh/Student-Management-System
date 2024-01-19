package com.student.manage;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentOperations {
    
    public static boolean insertIntoDB(Student stu) {
        boolean flag = false;
        try {
            // connection
            Connection con = ConnectionProvider.createConnection();
            String q = "insert into students(sid, sname, scity) values(?,?,?)";
            
            // prepared statement
            PreparedStatement ps = con.prepareStatement(q);

            // setting values of parameter
            ps.setInt(1, stu.getStudentID());
            ps.setString(2, stu.getStudentName());
            ps.setString(3, stu.getStudentCity());
            
            // execute 
            ps.executeUpdate();
            flag = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteFromDB(int userID) {
        boolean flag = false;
        try {
            // connection
            Connection con = ConnectionProvider.createConnection();
            String q = "delete from students where sid = ?";
            
            // prepared statement
            PreparedStatement ps = con.prepareStatement(q);

            // setting values of parameter
            ps.setInt(1, userID);
            
            // execute 
            ps.executeUpdate();
            flag = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void showAllStudents() {
        try {
            Connection con = ConnectionProvider.createConnection();
            String q = "select * from students";
            Statement s = con.createStatement();
            
            ResultSet resultSet = s.executeQuery(q);
            while (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                String city = resultSet.getString("scity");

                System.out.println("ID = " + id);
                System.out.println("Name = " + name);
                System.out.println("City = " + city);
                System.out.println("+++++++++++++++++++");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean updateDB(int userID, String newName, String newCity) {
        boolean flag = false;
        try {
            Connection con = ConnectionProvider.createConnection();
            String q = "update students set sname = ?, scity = ? where sid = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, newName);
            ps.setString(2, newCity);
            ps.setInt(3, userID);

            ps.executeUpdate();
            flag = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
