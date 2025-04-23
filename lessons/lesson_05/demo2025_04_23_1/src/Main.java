public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("DE1111", "Jack", 1000);
        Account accountB = new Account("DE2222", "John", 1000);

        Thread thread1 = new Thread(() -> transfer(accountA, accountB, 100), "T1");
        Thread thread2 = new Thread(() -> transfer(accountB, accountA, 500), "T2");
        Thread lockMonitor = new DeadlockDetector();
        lockMonitor.start();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);
    }

    // если убрать synchronised - треды заблокируют друг друга
    public static void transfer(Account from, Account to, double amount){
        Account first = from.hashCode() < to.hashCode()? from : to;
        Account second = from.hashCode() < to.hashCode()? to : from ;

        synchronized (first) {
            // Если закомментировать вывод - то потоки не заблокируют друг друга
            // тред успеет выйти из комнаты и проскочить.
            // А с sout он не успеет проскочить(sout как доп работа для него)
            System.out.println("account " + from + " is locked by " + Thread.currentThread().getName());

            synchronized (second) {
                System.out.println("account " + to + " is locked by " + Thread.currentThread().getName());
                if(from.withdraw(amount)) { // перевод денег from .... to
                    to.deposit(amount);
                }
            }
            System.out.println("account " + to + "is unlocked");
        }
        System.out.println("account " + from + " is unlocked");
        System.out.println("transfer is finish");
    }
}