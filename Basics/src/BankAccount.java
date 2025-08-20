public class BankAccount {
    final private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber,double initialBalance){
        this.accountNumber=accountNumber;
        this.balance=initialBalance;
    }
    public String getAccountNumber(){
        return  accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit (double amount){
        if (amount >0){
            this.balance+=amount;
            System.out.println("Rs "+amount+ " Deposited Successfully");
        }else{
            System.out.println("Please ! Enter a Correct Amount ");
        }
    }
    public  void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rs "+amount + " Withdraw From your account");
        } else if (amount < 0) {
            System.out.println("Please ! Enter a valid amount");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public static void main(String[] args) {
        BankAccount user1= new BankAccount("231",1000);
        System.out.println("Account Number is"+ user1.getAccountNumber());
        System.out.println("Balance is Rs "+user1.getBalance());
        user1.deposit(100);
        System.out.println("Balance is Rs "+user1.getBalance());
        user1.withdrawal(200);
        System.out.println("Balance is Rs "+user1.getBalance());
        user1.withdrawal(1000);
        System.out.println("Balance is Rs "+user1.getBalance());

    }
}
