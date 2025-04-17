public class Main {
    public static void main(String[] args) {
//        Задача №1
//
//        Реализовать 2 потока:
//        первый поток должен выводить на экран все числа, которые делятся на 2;
//        второй поток должен выводить все числа которые делятся на 3;
//        Main должен запускать оба эти потока, засыпать на 3 секунды и завершать выполнение программы
//              (т.е. оба потока тоже должны прекратить свою работу)

        System.out.println("Main start");

        Thread thread1 = new MyThread(2, 2);
        Thread thread2 = new MyThread(3, 3);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main finish");

    }
}