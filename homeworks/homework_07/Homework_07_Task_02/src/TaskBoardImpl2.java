import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class TaskBoardImpl2 implements TaskBoard {
    private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

    @Override
    public void setTask(List<String> tasksList) {
        for (String task : tasksList) {
            try {
                blockingQueue.put(task);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getTask() {
        try {
            Thread.sleep(500);
            if (blockingQueue.isEmpty()) {
                return null;
            }
            return blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}