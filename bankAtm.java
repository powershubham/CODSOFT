package bankingSystem;

import java.util.Scanner;

public class bankAtm {
    public bankAtm() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        bankAccount var2 = new bankAccount(1000.0);
        aTm var3 = new aTm(var2);

        while(true) {
            var3.displayMenu();
            System.out.print("Enter your choice: ");
            int var4 = var1.nextInt();
            if (var4 == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                var1.close();
                return;
            }

            var3.handleUserInput(var4);
        }
    }
}
