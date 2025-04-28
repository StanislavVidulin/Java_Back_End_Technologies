import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl2 implements TaskBoard {
    public static final int QUEUE_CAPACITY = 10;
    private Queue<String> tasks = new LinkedList<>();

    private Lock lock = new ReentrantLock();
    private Condition managerCondition = lock.newCondition();
    private Condition workerCondition = lock.newCondition();


    @Override
    public void setTask(String task) {
        lock.lock();

        try {

            while (this.tasks.size() >= QUEUE_CAPACITY) {
                try {
                    managerCondition.await();         // !!!! не wait()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


            this.tasks.offer(task);
            workerCondition.signal();   // !!!!  не notify()

        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getTask() {
        lock.lock();
        try {
            while (tasks.size() == 0) {
                try {
                    workerCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String result = tasks.poll();
            if (tasks.size()<QUEUE_CAPACITY) {
                managerCondition.signal();
            }
            return result;

        } finally {
            lock.unlock();
        }

    }
}
