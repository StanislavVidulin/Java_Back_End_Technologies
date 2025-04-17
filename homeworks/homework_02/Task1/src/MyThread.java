public class MyThread extends Thread {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start");
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (i % 2 == 0) {
                System.out.println("Число " + i + " делится на 2");
            }
        }
        System.out.println(name + " finish");
    }
}
