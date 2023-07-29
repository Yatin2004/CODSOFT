import java.util.Scanner;

class bankaccount {
    private double balance;

    public bankaccount(double InitialBalance)
    {
        this.balance = InitialBalance;
    }

    public double getbalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public boolean Withdraw(double amount)
    {
        if (amount > balance)
        {
            return false;
        }
        balance -= amount;
        return true;
    }
}
class ATM
{
    private bankaccount account;
    private Scanner scanner;

    public ATM(bankaccount account)
    {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void run()
    {
        while (true)
        {
            showOptions();
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    deposit();
                    break;
                case 2:
                    CheckBalance();
                    break;
                case 3:
                    Withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM. have a nice day!");
                    return;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        }
    }

    private void showOptions()
    {
        System.out.println("\n== ATM MENU ==");
        System.out.println("1. Deposit");
        System.out.println("2. Check balance");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    private void deposit()
    {
        System.out.print("Enter Amount to deposit: ");
        double Amount = scanner.nextDouble();
        account.deposit(Amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }
    private void CheckBalance()
    {
        System.out.println("Your account balance: " + account.getBalance());
    }
    private void Withdraw()
    {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.Withdraw(amount))
        {
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        }
        else
        {
            System.out.println("Insufficient balance for processing the Transcation");
        }
    }
}
public class Main {
    public static void main(String[] args)
    {
        bankaccount account = new bankaccount(1000);
        ATM atm = new ATM(account);
        ATM.run();
    }
}

