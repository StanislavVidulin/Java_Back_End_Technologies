import java.util.concurrent.atomic.AtomicInteger;

public class LatencyMonitor {
    private final AtomicInteger minLatency = new AtomicInteger(Integer.MAX_VALUE);

    public void updateLatency(double latency) {
        int latencyValue = (int) Double.parseDouble(String.valueOf(latency));

        while (true) {
            int currentLatency = minLatency.get();
            if (latency < currentLatency) {
                if (minLatency.compareAndSet(currentLatency, latencyValue)) {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public int getMinLatency() {
        return minLatency.get();
    }
}
