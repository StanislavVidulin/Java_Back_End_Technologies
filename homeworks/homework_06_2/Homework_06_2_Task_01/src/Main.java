import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("DE1111", "Jack", 1000);
        Account accountB = new Account("DE2222", "John", 1000);

        Thread thread1 = new Thread(() -> transfer(accountA, accountB, 100), "T1");
        Thread thread2 = new Thread(() -> transfer(accountB, accountA, 500), "T2");
        Thread lockMonitor = new DeadlockDetector();


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);

    }
    /*
            boolean block1 = tryLock ......
            boolean block2 = tryLock .....

            try{
               if (block1&&bloc2){
                    /// перевод
               }
            } finally {
                if(block1) from.getLock().unlock();
                if(block2) to.getLock().unlock();
            }
     */


    public static void transfer(Account from, Account to, double amount) {

        String threadName = Thread.currentThread().getName();
        try {
            if (from.getLock().tryLock(1, TimeUnit.SECONDS)){
                // получили блокировку from
                try {
                    System.out.println(threadName + ": получил блокировку from " + from.getIban());
                    if(to.getLock().tryLock(1, TimeUnit.SECONDS)){
                        // получили блокировку to   обе блокировки есть
                        try {
                            System.out.println(threadName + ": получил блокировку to " + to.getIban());
                            if(from.withdraw(amount)) {  // перевод денег from .... to
                                to.deposit(amount);
                                System.out.printf("%s: перевод from %s to %s на сумму %f выполнен%n",
                                        threadName,from.getIban(),to.getIban(),amount);
                            } else {
                                System.out.println(threadName + ": не хватило денег, операция отклонена");
                            }

                        } finally {
                            to.getLock().unlock();
                        }
                   } else {
                        // не смогли получить блокировку to
                        System.out.println(threadName+ ": не смогли получить блокировку to");

                   }

                } finally {
                    System.out.println(threadName + ": сняли блокировку from " + from.getIban());
                    from.getLock().unlock();
                }

            } else {
                // не смогли получить блокировку from
                System.out.println(threadName+ ": не смогли получить блокировку from");
            }


        } catch (InterruptedException e) {
            System.out.println("interrupt");
            throw new RuntimeException(e);
        }

    }

}