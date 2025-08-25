// import java.util.*;

// class Account {
//     String username;
//     String password;
//     double balance;
//     ArrayList<String> transactions = new ArrayList<>();

//     public Account(String username, String password, double balance) {
//         this.username = username;
//         this.password = password;
//         this.balance = balance;
//     }

//     void deposit(double amount) {
//         balance += amount;
//         transactions.add("Deposited ₹" + amount);
//     }

//     boolean withdraw(double amount) {
//         if (amount > 0 && amount <= balance) {
//             balance -= amount;
//             transactions.add("Withdrew ₹" + amount);
//             return true;
//         }
//         return false;
//     }

//     void showTransactions() {
//         if (transactions.isEmpty()) {
//             System.out.println("No transactions yet.");
//         } else {
//             System.out.println("----- Transaction History -----");
//             for (String t : transactions) {
//                 System.out.println(t);
//             }
//         }
//     }
// }

// public class OnlineBankingSystem {
//     private static Map<String, Account> accounts = new HashMap<>();
//     private static Scanner sc = new Scanner(System.in);

//     public static void main(String[] args) {
//         int choice;
//         do {
//             System.out.println("\n===== Online Banking System =====");
//             System.out.println("1. Add Account");
//             System.out.println("2. Login");
//             System.out.println("3. Exit");
//             System.out.print("Enter your choice: ");
//             choice = sc.nextInt();
//             sc.nextLine(); // consume newline

//             switch (choice) {
//                 case 1:
//                     addAccount();
//                     break;
//                 case 2:
//                     login();
//                     break;
//                 case 3:
//                     System.out.println("Exiting... Thank you!");
//                     break;
//                 default:
//                     System.out.println("Invalid choice! Try again.");
//             }
//         } while (choice != 3);
//     }

//     // ✅ Add new account
//     private static void addAccount() {
//         System.out.print("Enter username: ");
//         String username = sc.nextLine();
//         if (accounts.containsKey(username)) {
//             System.out.println("Account already exists!");
//             return;
//         }
//         System.out.print("Enter password: ");
//         String password = sc.nextLine();
//         System.out.print("Enter initial deposit: ");
//         double balance = sc.nextDouble();
//         sc.nextLine();

//         accounts.put(username, new Account(username, password, balance));
//         System.out.println("Account created successfully!");
//     }

//     // ✅ Login to account
//     private static void login() {
//         System.out.print("Enter username: ");
//         String username = sc.nextLine();
//         System.out.print("Enter password: ");
//         String password = sc.nextLine();

//         Account acc = accounts.get(username);
//         if (acc != null && acc.password.equals(password)) {
//             System.out.println("\nLogin successful. Welcome, " + username + "!");
//             accountMenu(acc);
//         } else {
//             System.out.println("Invalid username or password.");
//         }
//     }

//     // ✅ Account Menu
//     private static void accountMenu(Account acc) {
//         int choice;
//         do {
//             System.out.println("\n----- Dashboard -----");
//             System.out.println("1. Check Balance");
//             System.out.println("2. Deposit Money");
//             System.out.println("3. Withdraw Money");
//             System.out.println("4. Transaction History");
//             System.out.println("5. Logout");
//             System.out.print("Enter your choice: ");
//             choice = sc.nextInt();

//             switch (choice) {
//                 case 1:
//                     System.out.println("Balance: ₹" + acc.balance);
//                     break;
//                 case 2:
//                     System.out.print("Enter deposit amount: ");
//                     double dep = sc.nextDouble();
//                     acc.deposit(dep);
//                     System.out.println("₹" + dep + " deposited successfully!");
//                     break;
//                 case 3:
//                     System.out.print("Enter withdrawal amount: ");
//                     double w = sc.nextDouble();
//                     if (acc.withdraw(w)) {
//                         System.out.println("₹" + w + " withdrawn successfully!");
//                     } else {
//                         System.out.println("Invalid amount or insufficient balance.");
//                     }
//                     break;
//                 case 4:
//                     acc.showTransactions();
//                     break;
//                 case 5:
//                     System.out.println("Logged out from " + acc.username);
//                     break;
//                 default:
//                     System.out.println("Invalid choice! Try again.");
//             }
//         } while (choice != 5);
//     }
// }

import java.io.*;
import java.util.*;

class Account implements Serializable {
    String username;
    String password;
    double balance;
    ArrayList<String> transactions = new ArrayList<>();

    public Account(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited ₹" + amount);
    }

    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew ₹" + amount);
            return true;
        }
        return false;
    }

    void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("----- Transaction History -----");
            for (String t : transactions) {
                System.out.println(t);
            }
        }
    }
}

public class OnlineBankingSystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static final String FILE_NAME = "accounts.dat";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadAccounts();  // load data at startup
        int choice;
        do {
            System.out.println("\n===== Online Banking System =====");
            System.out.println("1. Add Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    saveAccounts();  // save before exit
                    System.out.println("Exiting... Accounts saved. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);
    }

    // ✅ Add new account
    private static void addAccount() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        if (accounts.containsKey(username)) {
            System.out.println("Account already exists!");
            return;
        }
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter initial deposit: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        accounts.put(username, new Account(username, password, balance));
        saveAccounts(); // save immediately after creation
        System.out.println("Account created successfully!");
    }

    // ✅ Login to account
    private static void login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        Account acc = accounts.get(username);
        if (acc != null && acc.password.equals(password)) {
            System.out.println("\nLogin successful. Welcome, " + username + "!");
            accountMenu(acc);
            saveAccounts(); // save after session
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    // ✅ Account Menu
    private static void accountMenu(Account acc) {
        int choice;
        do {
            System.out.println("\n----- Dashboard -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + acc.balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    System.out.println("₹" + dep + " deposited successfully!");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double w = sc.nextDouble();
                    if (acc.withdraw(w)) {
                        System.out.println("₹" + w + " withdrawn successfully!");
                    } else {
                        System.out.println("Invalid amount or insufficient balance.");
                    }
                    break;
                case 4:
                    acc.showTransactions();
                    break;
                case 5:
                    System.out.println("Logged out from " + acc.username);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    // ✅ Save accounts to file
    private static void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    // ✅ Load accounts from file
    private static void loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (HashMap<String, Account>) ois.readObject();
            System.out.println("Accounts loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No previous accounts found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}
