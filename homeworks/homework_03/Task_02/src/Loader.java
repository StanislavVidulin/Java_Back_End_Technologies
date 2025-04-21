public class Loader implements Runnable {
    private String name;
    private int nBox;
    private int capacity;
    private Warehouse warehouse;
    private Warehouse warehouse2;
    private int done = 0;

    public Loader(String name, int nBox, int capacity, Warehouse warehouse, Warehouse warehouse2) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
        this.warehouse2 = warehouse2;
    }

    @Override
    public void run() {
        while (done < nBox) {
            int value = Math.min(nBox - done, capacity);
            if (value == 2) {
                warehouse.addValue(1);
                warehouse2.addValue(1);
                done += value;
            } else {
                warehouse.addValue(value);
                done += capacity;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(name + " finish. Get: " + done + " boxes");
    }
}
