import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl2 implements TaskBoard {
    private List<String> tasks = new ArrayList<>();

    private Lock lock = new ReentrantLock();
    private Condition managerCondition = lock.newCondition();
    private Condition workerCondition = lock.newCondition();

    @Override
    public void setTask(List<String> tasksList) {
        lock.lock();
        try {
            while (!tasks.isEmpty()) {
                try {
                    managerCondition.await();   // !!!! не wait()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            tasks.addAll(tasksList);
            workerCondition.signal(); // !!!! не notify()
        } finally {
            lock.unlock();
        }

    }

    @Override
    public String getTask() {
        lock.lock();
        try {
            while (tasks.isEmpty()) {
                try {
                    workerCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            String result = tasks.remove(0);
            if (tasks.isEmpty()) {
                managerCondition.signal();
            }
            return result;

        } finally {
            lock.unlock();
        }
    }
}