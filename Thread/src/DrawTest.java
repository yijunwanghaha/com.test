public class DrawTest {
    public static void main(String[] args) {
        Account account=new Account("12345",1000);
        new DrawThread("甲",account,800).start();
        new DrawThread("乙",account,800).start();
    }
}
