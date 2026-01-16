import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class BankTransaction {
    public static void main(String[] args) throws InterruptedException{
        BankAccount userAccount1 = new BankAccount(1710, 2000);
        System.out.println("Balance at the begining of transaction : "+userAccount1.getBalance()+"rs.");
        Transaction opTransaction =  new Transaction(userAccount1);
        Thread thread1 = new Thread(() ->opTransaction.operation("Withdraw", 500));
        Thread thread2 = new Thread(() ->opTransaction.operation("Deposit", 1000));
        Thread thread3 = new Thread(() ->opTransaction.operation("Deposit", 700));
        Thread thread4 = new Thread(() ->opTransaction.operation("Withdraw", 500));

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            double balance = userAccount1.getBalance();
            System.out.println("Balance after all transaction: "+balance);
            
        }   
    }
    class Transaction{
        BankAccount user;
    public Transaction(BankAccount userAccount){
        user = userAccount;
    }
        public void operation(String opString, double amount){
                if(opString == "Withdraw"){
                        user.setBalance(user.withdraw(amount));
                } else if(opString == "Deposit"){
                    user.setBalance(user.deposit(amount));
                }
        }

}
class BankAccount{
    private int accID;
    private double accBalance;
    public BankAccount(int accID, double accBalance){
        this.accID= accID;
        this.accBalance= accBalance;
    }
    public int getAccountID(){
        return this.accID;
    }
    public double getBalance(){
        return this.accBalance;
    }
    public void setBalance(double balance){
        this.accBalance = balance;
    }
    private Lock lock = new ReentrantLock();
        public double withdraw(double amount){
        double balance=0;
        System.out.println("Withdrawing using "+ Thread.currentThread().getName()+", amount of "+ amount );
        lock.lock();
        try {
                    balance = getBalance();
                    balance -= amount;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return balance;
    }
        public double deposit(double amount){
            double balance= 0;
            System.out.println("Depositing using "+ Thread.currentThread().getName()+", amount of "+ amount );
            lock.lock();
            try {
                    balance = getBalance();
                    balance += amount;
        }catch (Exception e) {
                e.printStackTrace();
            } finally{
                lock.unlock();
            }
            return balance;
        }
}