
//creating data type called order
public class BankAccount {
    //member variables always private
    private double checkingBalance;
    private double savingBalance; 
    // want it to be public so it can be global and accessable.
    public static int members = 0;
    public static double total = 0;

    // constructor
    public BankAccount(double checkingBalance, double savingBalance){
    this.checkingBalance = checkingBalance;
    this.savingBalance = savingBalance;
    members++;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public void addAmount(String account, double amount){
        if(amount > 0){
        if (account == "checking"){
            this.checkingBalance += amount;
        total += amount;
        }
        if (account == "savings"){
            this.savingBalance += amount;
        total += amount;
        }
        }
    }

    public void withdrawAmount (String account, double amount){
        if(amount > 0){
        if (account == "checking" && amount < this.checkingBalance){
            this.checkingBalance -= amount;
        total -=amount;
        }
        if (account == "checking" && amount < this.checkingBalance){
            this.checkingBalance -= amount;
        total -=amount;
        }
        }
    }

    public double getTotal(){
        double checking = this.getCheckingBalance();
        double saving = this.getSavingBalance();
        double total = saving + checking;
        
        return total;
    }

// cannot have static and this at same time

    }



