import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq=new ArrayBlockingQueue<String>(3);
        bq.put("java");
        bq.put("c#");
        bq.put("python");
        System.out.println("python");
        bq.add("jquery");
        System.out.println("hello");
    }
}
