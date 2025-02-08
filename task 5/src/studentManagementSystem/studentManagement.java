package studentManagementSystem;

import java.util.Scanner;

public class studentManagement {
    static studentClass sClass = new studentClass();
    public void display() {
        System.out.println("1.Add Student");
        System.out.println("2.Remove Student");
        System.out.println("3.Update Student");
        System.out.println("4.Search Student");
        System.out.println("5.Display Student");
        System.out.println("6.Exit");
    }
    public static void handleUserInput(int ch, Scanner sc){
        switch(ch) {
            case 1: addStudent(sc);
                break;
            case 2: removeStudent(sc);
                break;
            case 3: updateStudent(sc);
                break;
            case 4: searchStudent(sc);
                break;
            case 5: displayStudent();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void addStudent(Scanner sc) {
        System.out.println("Enter name of Student: ");
        String name = sc.nextLine();
        System.out.println("Enter Roll Number of Student: ");
        int roll = sc.nextInt();
        System.out.println("Enter Gender: ");
        String gender = sc.next();
        System.out.println("Enter Grade: ");
        char grade= sc.next().charAt(0);
        sClass.add(name, roll, gender, grade);
    }
    public static void removeStudent(Scanner sc) {
        System.out.println("Enter Roll Number of Student which you want to remove: ");
        int roll = sc.nextInt();
        sClass.delete(roll);
    }
    public static void updateStudent(Scanner sc) {
        System.out.println("Enter Roll Number of Student which you want to update: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name of Student: ");
        String name = sc.nextLine();
        System.out.println("Enter Gender: ");
        String gender = sc.next();
        System.out.println("Enter Grade: ");
        char grade = sc.next().charAt(0);
        sClass.edit(roll, name, gender, grade);
    }
    public static void searchStudent(Scanner sc) {
        System.out.println("Enter Roll Number of Student: ");
        int roll = sc.nextInt();
        sClass.search(roll);
    }
    public static void displayStudent() {
        sClass.display();
    }
}
