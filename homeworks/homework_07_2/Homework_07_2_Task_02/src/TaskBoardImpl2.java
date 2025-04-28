import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskBoardImpl2 implements TaskBoard {
    public static final int QUEUE_CAPACITY = 10;
    private BlockingQueue<String> tasks = new ArrayBlockingQueue<>(QUEUE_CAPACITY);


    @Override
    public void setTask(String task) {
        try {
            this.tasks.put(task);  // метод блокирует поток, если нет места в очереди
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getTask() {
        String result = null;
        try {
            result = tasks.take();   // метод блокирует поток, если нет задач в очереди
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
