public class MyRunnable implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start");
        for (int i = 1; i < 30; i++) {
            if (i % 3 == 0) {
                System.out.println("Число " + i + " делится на 3");
            }
        }
        System.out.println(name + " finish");
    }
}