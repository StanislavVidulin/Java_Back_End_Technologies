public class MyThread extends Thread {

    @Override
    public void run() {
        String name = Thread.currentThread().getName(); // Thread.currentThread() - текущий поток
        System.out.println("Thread " + name + " start");
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " " + i);
            try {
                Thread.sleep(500);   // пауза 1 секунда (поток спит)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Thread " + name + " finish");
    }
}
