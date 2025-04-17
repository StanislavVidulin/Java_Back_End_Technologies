public class MyThread extends Thread {

    private final int factor;
    private final int start;

    public MyThread(int factor, int start) {
        this.factor = factor;
        this.start = start;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = start; true; i += factor) {
                System.out.println(name + " на " + factor + ": " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

// Моя домашка
//        for (int i = 1; i < Integer.MAX_VALUE; i++) {
//            if (i % 2 == 0) {
//                System.out.println("Число " + i + " делится на 2");
//            }
//