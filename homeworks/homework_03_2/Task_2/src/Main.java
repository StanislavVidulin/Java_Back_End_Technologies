public class Main {
    private static final int N_BOX = 1000;
    private static final int CAPACITY = 2;

    public static void main(String[] args) {
//        Задача №2
//
//        Давайте доработаем задачку про грузчиков написанную на занятие.
//        Давайте добавим второй склад, и теперь грузчик должен брать 2 коробки за раз,
//        но одну отвозить на один склад, а вторую на второй. Т.е. за одну итерацию!

                Warehouse[] warehouses = {new Warehouse("#1"), new Warehouse("#2")};

        Thread[] loaders = {
                new Thread(new Loader("Jack", N_BOX, CAPACITY, warehouses)),
                new Thread(new Loader("John", N_BOX, CAPACITY, warehouses)),
                new Thread(new Loader("Nick", N_BOX, CAPACITY, warehouses)),
        };

        for (Thread thread : loaders) {
            thread.start();
        }

        for (Thread thread : loaders) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (Warehouse warehouse: warehouses) {
            System.out.println(warehouse);
        }
    }
}