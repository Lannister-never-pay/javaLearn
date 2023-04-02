package org.emnets.Thread_20230401;

/**
 * @create 2023/4/2 23:52
 * @finish
 * @description:
 */
public class AccountThread {
    public static void main(String[] args) {
        Account account = new Account(0);

        Customer customer1 = new Customer(account, "甲");
        Customer customer2 = new Customer(account, "乙");

        customer1.start();
        customer2.start();
    }
}


class Account {
    private double balance;

    public Account(double b) {
        this.balance = b;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        System.out.println(Thread.currentThread().getName() + "存钱" + amount + "块，余额：" + balance);
    }


}

class Customer extends Thread {

    Account account;

    public Customer(Account a) {
        this.account = a;
    }

    public Customer(Account a, String name) {
        super(name);
        this.account = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.deposit(1000);
        }

    }
}