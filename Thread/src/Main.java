public class Main {

    public static void main(String[] args) {
//        String str=new String("aaa");
//        String[] ss={"s1"};
//        changeStr(str,ss);
//        System.out.println(str);
//        System.out.println(ss[0]);
        Account account1=new Account();
        account1.setAccountNo("a1");

        Account account2=new Account();
        account2.setAccountNo("a1");

        System.out.println(account1==account2);
        System.out.println(account1.equals(account2));

        Account account3=new Account();
        account3.setAccountNo("a3");
        account2=account3;
        System.out.println(account2==account3);
        System.out.println(account2.equals(account3));

    }
    public static void changeStr(String str,String[] s){
        str="bbbb";
        s[0]="s2";
    }
}
