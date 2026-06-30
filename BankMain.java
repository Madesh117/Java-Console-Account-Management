import java.util.Scanner;

class Account {

    private int accountNumber;
    private String customerName;
    protected double balance;

    Account(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid Deposit Amount");
            return;
        }

        balance += amount;

        System.out.println("Amount Deposited Successfully");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {

        if(amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        balance -= amount;

        System.out.println("Amount Withdrawn Successfully");
    }

    public void displayAccount() {

        System.out.println("--------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Balance        : " + balance);
    }
}

//Saving 
class SavingsAccount extends Account {

    SavingsAccount(int accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {

        if(amount > balance) {
            throw new InsufficientBalanceException("Low Balance in Savings Account");
        }

        balance -= amount;

        System.out.println("Withdraw Successful From Savings Account");
    }
}


// CurrentAccount


class CurrentAccount extends Account {

    CurrentAccount(int accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {

        if(amount > balance + 5000) {
            throw new InsufficientBalanceException("Overdraft Limit Exceeded");
        }

        balance -= amount;

        System.out.println("Withdraw Successful From Current Account");
    }
}

// InsufficientBalanceException
class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank.java


class Bank {

    Account accounts[] = new Account[100];

    int count = 0;

    // CREATE ACCOUNT
    public void createAccount(Account acc) {

        accounts[count] = acc;

        count++;

        System.out.println("Account Created Successfully");
    }

    // SEARCH ACCOUNT
    public Account searchAccount(int accNo) {

        for(int i = 0; i < count; i++) {

            if(accounts[i].getAccountNumber() == accNo) {
                return accounts[i];
            }
        }

        return null;
    }

    // DISPLAY ALL ACCOUNTS
    public void displayAllAccounts() {

        if(count == 0) {
            System.out.println("No Accounts Found");
            return;
        }

        for(int i = 0; i < count; i++) {

            accounts[i].displayAccount();
        }
    }
}

// Main.java


class BankMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");

            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Search Account");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter Account Number : ");
                    int sAccNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Customer Name : ");
                    String sName = sc.nextLine();

                    System.out.print("Enter Initial Balance : ");
                    double sBal = sc.nextDouble();

                    SavingsAccount sa =
                        new SavingsAccount(sAccNo, sName, sBal);

                    bank.createAccount(sa);

                    break;

                case 2:

                    System.out.print("Enter Account Number : ");
                    int cAccNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Customer Name : ");
                    String cName = sc.nextLine();

                    System.out.print("Enter Initial Balance : ");
                    double cBal = sc.nextDouble();

                    CurrentAccount ca =
                        new CurrentAccount(cAccNo, cName, cBal);

                    bank.createAccount(ca);

                    break;

                case 3:

                    System.out.print("Enter Account Number : ");
                    int dAccNo = sc.nextInt();

                    Account dAcc = bank.searchAccount(dAccNo);

                    if(dAcc != null) {

                        System.out.print("Enter Deposit Amount : ");
                        double dep = sc.nextDouble();

                        dAcc.deposit(dep);

                    } else {

                        System.out.println("Account Not Found");
                    }

                    break;

                case 4:

                    System.out.print("Enter Account Number : ");
                    int wAccNo = sc.nextInt();

                    Account wAcc = bank.searchAccount(wAccNo);

                    if(wAcc != null) {

                        System.out.print("Enter Withdraw Amount : ");
                        double amt = sc.nextDouble();

                        try {

                            wAcc.withdraw(amt);

                        } catch(InsufficientBalanceException e) {

                            System.out.println(e.getMessage());
                        }

                    } else {

                        System.out.println("Account Not Found");
                    }

                    break;

                case 5:

                    System.out.print("Enter Account Number : ");
                    int searchNo = sc.nextInt();

                    Account found = bank.searchAccount(searchNo);

                    if(found != null) {

                        found.displayAccount();

                    } else {

                        System.out.println("Account Not Found");
                    }

                    break;

                case 6:

                    bank.displayAllAccounts();

                    break;

                case 7:

                    System.out.println("Thank You");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while(choice != 7);
    }
}