import java.util.concurrent.atomic.AtomicInteger;

public class LatencyMonitor {
    // final относится к значению переменной(а это ссылка на объект),
    // значит значение можно менять, а ссылку мы и так не меняем.
//    private final List <String> list = new ArrayList<>(List.of("qwerty"));

    private final AtomicInteger minLatency = new AtomicInteger(Integer.MAX_VALUE);

    public void updateLatency(int latency) {
        while (true) {
            int currentMin = minLatency.get();

            if (latency >= currentMin) {
                return;
            }
            if (minLatency.compareAndSet(currentMin, latency)) {
                return;
            }

//            if (minLatency.get() >= latency) {
//                minLatency.set(latency);
//                return;
//            } - Error, нет атомарности между проверкой и обновлением
//             Так нельзя, не атомарная операция, каждый поток может влезать и менять значение,
//                  а compareAndSet - атомарная операция, туда никто не влезет
        }
    }

    // 2-ой вариант метода
    public void updateLatency2(int latency) {
        minLatency.updateAndGet(currentMinLatency -> Math.min(currentMinLatency, latency));
    }

    public int getMinLatency() {
        return minLatency.get();
    }
}
