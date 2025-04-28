import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskBoardImpl2 implements TaskBoard {
    public static final int QUEUE_CAPACITY = 10;
    private BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(QUEUE_CAPACITY);


    @Override
    public void setTask(Runnable task) {
        try {
            this.tasks.put(task);  // метод блокирует поток, если нет места в очереди
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Runnable getTask() {
        Runnable result = null;
        try {
            result = tasks.take();   // метод блокирует поток, если нет задач в очереди
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
