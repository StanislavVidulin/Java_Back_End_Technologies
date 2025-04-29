/* 1. Возьмите за основу код, написанный на занятие (проект про постановку задач).
Ваша задача: сделать так, чтобы можно было поместить сразу несколько задач на TaskBoard

*/


public class Main {
    private final static int N_TASKS = 10;
    private final static int N_WORKERS = 5;

    public static void main(String[] args) throws InterruptedException {
        TaskBoard taskBoard = new TaskBoardImpl2();

        Thread manager = new Thread(new Manager(taskBoard, N_TASKS));

        Thread[] threads = new Thread[N_WORKERS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker(taskBoard, "jack- " + i));
            threads[i].setDaemon(true);
            threads[i].start();
        }

        manager.start();
        Thread.sleep(1000);
        manager.join();
    }
}