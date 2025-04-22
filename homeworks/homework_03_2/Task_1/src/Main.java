public class Main {
    private static final int N_BOX = 1000;
    private static final int CAPACITY = 1;

    public static void main(String[] args) {
//        Задача №1
//
//        Давайте возьмем задачу про грузчиков, реализованную на занятие.
//        Теперь,  нам необходимо зафиксировать, кто из грузчиков первый справился с поставленной задачей
//        ( и выдать ему премию). Т.е. в main должна появится запись о том,
//        что грузчик такой то первый закончил свою работу.
//                Можно немного увеличить разбросы результатов, добавив случайную паузу [5-15] миллисекунд,
//                после того, как грузчик отнес коробки т.е. сделал одну итерацию.

                Warehouse warehouse = new Warehouse("#1");
        Thread[] loaders = {
                new Thread(new Loader("Jack", N_BOX, CAPACITY, warehouse)),
                new Thread(new Loader("John", N_BOX, CAPACITY, warehouse)),
                new Thread(new Loader("Nick", N_BOX, CAPACITY, warehouse)),
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

        System.out.println(warehouse);
        System.out.println("Winner: " + Loader.getWinner());
    }
}