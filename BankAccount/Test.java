import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
    
    BankAccount account1 = new BankAccount(0,0);

    account1.addAmount("checking", 50);
    System.out.println(account1.getCheckingBalance());

    account1.addAmount("savings", 100);
    System.out.println(account1.getSavingBalance());

    account1.withdrawAmount("checking", 100);
    System.out.println(account1.getCheckingBalance());

    System.out.println(account1.getTotal());

    }


}