package studentManagementSystem;

import java.sql.*;

public class studentClass {

    public void add(String name, int roll, String gender, char grade){
        try {
            connection conn = new connection();
            conn.Conn();
            String query = "INSERT INTO student (name, rollno, gender, grade) VALUES (?, ?, ?, ?)";

            PreparedStatement myStmt = conn.c.prepareStatement(query);

            myStmt.setString(1, name);
            myStmt.setInt(2, roll);
            myStmt.setString(3, gender);
            myStmt.setString(4, String.valueOf(grade));

            int rowsAffected = myStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student with Roll Number " + roll + " has been added successfully.");
            } else {
                System.out.println("Failed to add student. Please try again.");
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
        }
    }

    public void delete(int roll){
        try {
            connection conn = new connection();
            conn.Conn();
            String query = "DELETE FROM student WHERE rollno = ?";
            PreparedStatement myStmt = conn.c.prepareStatement(query);
            myStmt.setInt(1, roll);

            int rowsAffected = myStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student with Roll Number " + roll + " has been deleted successfully.");
            } else {
                System.out.println("No student found with Roll Number " + roll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int roll, String name, String gender, char grade){
        try {
            connection conn = new connection();
            conn.Conn();
            String query = "UPDATE student SET name = ?, gender = ?, grade = ? WHERE rollno = ?";
            PreparedStatement myStmt = conn.c.prepareStatement(query);

            myStmt.setString(1, name);
            myStmt.setString(2, gender);
            myStmt.setString(3, String.valueOf(grade));
            myStmt.setInt(4, roll);

            int rowsAffected = myStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student with Roll Number " + roll + " has been updated successfully.");
            } else {
                System.out.println("No student found with Roll Number " + roll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void search(int roll){
        try {
            connection conn = new connection();
            conn.Conn();
            String query = "SELECT * FROM student WHERE rollno = ?";
            PreparedStatement myStmt = conn.c.prepareStatement(query);
            myStmt.setInt(1, roll);

            ResultSet rs = myStmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int rollNo = rs.getInt("rollno");
                String gender = rs.getString("gender");
                String grade = rs.getString("grade");
                System.out.println("Student Found: ");
                System.out.println("Name: " + name);
                System.out.println("Roll Number: " + rollNo);
                System.out.println("Gender: " + gender);
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("No student found with Roll Number " + roll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void display(){
        try {
            connection conn = new connection();
            conn.Conn();
            String query = "SELECT * FROM student";
            Statement stmt = conn.s;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                int roll = rs.getInt("rollno");
                String gender = rs.getString("gender");
                String grade = rs.getString("grade");

                System.out.println("Name: " + name + ", Roll Number: " + roll + ", Gender: " + gender + ", Grade: " + grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
