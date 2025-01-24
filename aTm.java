package bankingSystem;

import java.util.Scanner;

public class aTm {
    private final bankAccount account;

    public aTm(bankAccount var1) {
        this.account = var1;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Current balance: " + this.account.getBalance());
    }

    public void deposit() {
        Scanner var1 = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double var2 = var1.nextDouble();
        this.account.deposit(var2);
    }

    public void withdraw() {
        Scanner var1 = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double var2 = var1.nextDouble();
        this.account.withdraw(var2);
    }

    public void handleUserInput(int var1) {
        switch (var1) {
            case 1:
                this.checkBalance();
                break;
            case 2:
                this.deposit();
                break;
            case 3:
                this.withdraw();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }
}
