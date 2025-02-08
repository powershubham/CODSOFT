package studentManagementSystem;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        studentManagement sMan = new studentManagement();
        while(true) {
            sMan.display();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 6) {
                System.out.println("Thank you for using the Student Management System. Goodbye!");
                sc.close();
                return;
            }
            studentManagement.handleUserInput(choice, sc);
        }
    }
}
