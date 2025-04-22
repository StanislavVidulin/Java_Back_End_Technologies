public class Account {
    private final String iban;
    private final String owner;
    private double balance;
    private final Object lock = new Object();

    public Account(String iban, String owner, double balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        synchronized (lock) {
            if (getBalance() >= amount) {
                balance -= amount;
            }
        }
    }

    public double getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    @Override
    public String toString() {
        synchronized (lock) {
            return "Account{" +
                    "iban='" + iban + '\'' +
                    ", owner='" + owner + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }
}
