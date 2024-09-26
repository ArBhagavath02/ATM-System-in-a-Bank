import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private Map<String, Account> accounts;
    private Account currentAccount;
    private Scanner scanner;

    public ATM() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);

        // Adding a default user for testing
        User user = new User("user1", "1234");
        accounts.put(user.getUserId(), new Account(user, 1000.0));
        user = new User("user2", "4321");
        accounts.put(user.getUserId(), new Account(user, 1000.0));
    }

    public void start() {
        System.out.println("Welcome to the ATM System");
        if (login()) {
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Balance");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        showTransactionHistory();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        System.out.println(currentAccount.getBalance());;
                        break;
                    case 6:
                         exit = true;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        System.out.println("Thank you for using the ATM System!");
    }

    private boolean login() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter user PIN: ");
        String userPin = scanner.nextLine();

        Account account = accounts.get(userId);
        if (account != null && account.getUser().getUserPin().equals(userPin)) {
            currentAccount = account;
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid credentials. Please try again.");
        return false;
    }

    private void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : currentAccount.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful! New balance: " + currentAccount.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        currentAccount.deposit(amount);
        System.out.println("Deposit successful! New balance: " + currentAccount.getBalance());
    }

    private void transfer() {
        System.out.print("Enter recipient user ID: ");
        String recipientUserId = scanner.nextLine();
        Account recipientAccount = accounts.get(recipientUserId);

        if (recipientAccount != null) {
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            if (currentAccount.transfer(recipientAccount, amount)) {
                System.out.println("Transfer successful! New balance: " + currentAccount.getBalance());
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Recipient user ID not found.");
        }
    }
}
