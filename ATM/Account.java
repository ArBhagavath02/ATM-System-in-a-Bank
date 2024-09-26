import java.util.ArrayList;
import java.util.List;
public class Account{
    private User user;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(User user, double balance) {
        this.user = user;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdraw", amount));
        return true;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        toAccount.deposit(amount);
        transactionHistory.add(new Transaction("Transfer to " + toAccount.getUser().getUserId(), amount));
        return true;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
