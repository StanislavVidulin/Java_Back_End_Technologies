public class Loader implements Runnable {
    private String name;
    private int nBox;
    private int capacity;
    private Warehouse warehouse;
    private int done = 0;
    private static String firstFinisher = null;
    private static final Object lock = new Object();

    public Loader(String name, int nBox, int capacity, Warehouse warehouse) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (done < nBox) {
            int value = Math.min(nBox - done, capacity);
            warehouse.addValue(value);
            done += capacity;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (lock) {
            if (firstFinisher == null) {
                firstFinisher = name;
            }
        }
        System.out.println(name + " finish. Get: " + done + " boxes");
    }

    public static String getFirstFinisher () {
        return firstFinisher;
    }
}
