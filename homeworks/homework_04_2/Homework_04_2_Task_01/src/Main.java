//
//    Компания разрабатывает систему мониторинга производительности веб-сервисов.
//    Один из важных показателей — минимальная задержка ответа (latency) от сервера. Нужно реализовать
//    компонент LatencyMonitor, который отслеживает самое минимальное время отклика, полученное из
//    множества параллельных потоков, поступающих от разных серверов/кластеров.
//            Задержка - случайное целое число (мс), в диапазоне от 0 до Integer.MAX_VALUE.
//    Каждый из N потоков-серверов генерирует это число и вызывает метод updateLatency(int latency)
//    класса LatencyMonitor. Реализация не должна использовать synchronized
//    или блокировки — только атомарные структуры (Atomic*).

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static final int N_THREAD = 3;
    public static final int N_INTS = 5;

    public static void main(String[] args) throws InterruptedException {
        LatencyMonitor latencyMonitor = new LatencyMonitor();

        Thread[] threads = new Thread[N_THREAD];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(
                    () -> {
                        for (int j = 0; j < N_INTS; j++) {
                            int value = ThreadLocalRandom.current().nextInt(100, 1000);
                            latencyMonitor.updateLatency(value);
                            System.out.println(value);
                        }
                    }
            );
        }

        for (Thread thread: threads) {
            thread.start();
        }
        for (Thread thread: threads) {
            thread.join();
        }
        System.out.println("----------------------------");
        System.out.println("Min latency = " + latencyMonitor.getMinLatency());
    }
}