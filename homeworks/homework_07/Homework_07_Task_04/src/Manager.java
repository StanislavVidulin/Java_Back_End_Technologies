public class Manager implements Runnable {
    private TaskBoard taskBoard;
    private int nTask;

    public Manager(TaskBoard taskBoard, int nTask) {
        this.taskBoard = taskBoard;
        this.nTask = nTask;
    }

    @Override
    public void run() {
        for (int i = 0; i < nTask; i++) {
            int finalI = i;
            taskBoard.setTask(new Runnable() {
                private final String description = "task " + finalI;

                @Override
                public void run() {
                    System.out.println(description);
                }

                @Override
                public String toString() {
                    return description;
                }
            });
        }
    }
}