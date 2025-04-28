import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl2 implements TaskBoard {
    private Queue<String> tasks = new LinkedList<>();

    private Lock lock = new ReentrantLock();
    private Condition managerCondition = lock.newCondition();
    private Condition workerCondition = lock.newCondition();


    @Override
    public void setTask(String task) {
        lock.lock();

        try {
 /*
            while (this.task != null) {
                try {
                    managerCondition.await();         // !!!! не wait()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

  */
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
            managerCondition.signal();
            return result;

        } finally {
            lock.unlock();
        }

    }
}
