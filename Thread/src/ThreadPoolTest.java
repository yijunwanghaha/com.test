import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Runnable target = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        };
        es.submit(target);
        es.submit(target);
        es.shutdown();
    }
}
