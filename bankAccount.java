package bankingSystem;

public class bankAccount {
    private double balance;

    public bankAccount(double var1) {
        if (var1 >= 0.0) {
            this.balance = var1;
        } else {
            this.balance = 0.0;
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
        }

    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double var1) {
        if (var1 > 0.0) {
            this.balance += var1;
            System.out.println("Successfully deposited: " + var1);
        } else {
            System.out.println("Deposit amount must be positive.");
        }

    }

    public void withdraw(double var1) {
        if (var1 > 0.0 && var1 <= this.balance) {
            this.balance -= var1;
            System.out.println("Successfully withdrew: " + var1);
        } else {
            if (var1 > this.balance) {
                System.out.println("Insufficient funds for withdrawal.");
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }

        }
    }
}
