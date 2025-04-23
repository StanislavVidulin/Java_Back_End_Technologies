public class Main {
    public static void main(String[] args) {
        LatencyMonitor monitor = new LatencyMonitor();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            double latency = Math.random() * Integer.MAX_VALUE;
            threads[i] = new Thread(() -> monitor.updateLatency(latency));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Min latency: " + monitor.getMinLatency());
    }
}