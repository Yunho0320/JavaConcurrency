package chapter1_fundamentals;

// This demonstrates common locking convention via bank account example
public class C_CommonLockingConventionExample {
    // Static utility method that synchronizes on both accounts
    public static void transfer(BankAccount from, BankAccount to, int amount) {
        synchronized (from) {
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }
}
class BankAccount {
    private int balance = 0;  // This is shared mutable state and must be protected.
                              // Therefore, all methods that access or modify it are synchronized on the object's intrinsic lock (`this`).

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public synchronized int getBalance() {
        return balance;
    }

}
