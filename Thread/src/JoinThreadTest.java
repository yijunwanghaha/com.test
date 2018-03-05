import java.util.concurrent.TimeUnit;

public class JoinThreadTest extends Thread {
    public JoinThreadTest(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println(getName()+" "+i);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new JoinThreadTest("新线程").start();
        for (int i = 0; i < 50; i++) {
            if(i==20){
                JoinThreadTest jt=new JoinThreadTest("被Join的线程");
                jt.start();
                jt.join();
                System.out.println("被Join的线程 结束");
            }
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        System.out.println("Hello World!");
    }
}
