class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(String person, int amount) {
        if (balance >= amount) {
            System.out.println(person + " is trying to withdraw " + amount);
            try {
		  Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(person + " successfully withdrew " + amount);
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println(person + " tried to withdraw " + amount + " but insufficient balance!");
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    private String person;
    private int amount;

    WithdrawThread(BankAccount acc, String name, int amt) {
        account = acc;
        person = name;
        amount = amt;
    }

    public void run() {
        account.withdraw(person, amount);
    }
}

public class Bank{
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        WithdrawThread t1 = new WithdrawThread(account, "Alice", 700);
        WithdrawThread t2 = new WithdrawThread(account, "Bob", 500);

        t1.start();
        t2.start();
    }
}

