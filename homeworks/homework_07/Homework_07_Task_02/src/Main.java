/*

2. Реализуйте таким образом, что бы между менеджером и работником была очередь задач. Важно
 1) чтобы работники отрабатывали задачи именно по-очереди
 2) возможное количество задач в очереди должно быть ограничено , и если в очереди нет места, Manager должен ждать
подсказка: BlockingQueue

*/


public class Main {
    private final static int N_TASKS = 30;
    private final static int N_WORKERS = 5;

    public static void main(String[] args) throws InterruptedException {
        TaskBoard taskBoard = new TaskBoardImpl2();

        Thread manager = new Thread(new Manager(taskBoard, N_TASKS));

        Thread[] threads = new Thread[N_WORKERS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker(taskBoard, "jack - " + i));
            threads[i].setDaemon(true);
            threads[i].start();
        }

        manager.start();
        Thread.sleep(1000);
        manager.join();

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }
}