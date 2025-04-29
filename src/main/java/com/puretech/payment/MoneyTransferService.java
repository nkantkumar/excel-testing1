package com.puretech.payment;


public class MoneyTransferService {

    public static void transfer(Account from, Account to, long amount) {
        // Always lock accounts in the same order to prevent deadlocks
        Account first = from.getId() < to.getId() ? from : to;
        Account second = from.getId() < to.getId() ? to : from;

        first.getLock().lock();
        second.getLock().lock();
        try {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transferred " + amount + " from Account " + from.getId() + " to " + to.getId());
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }

    public static void main(String[] args) {
        Account a = new Account(1, 1000);
        Account b = new Account(2, 500);

        transfer(a, b, 300);
        System.out.println("Account A balance: " + a.getBalance());
        System.out.println("Account B balance: " + b.getBalance());
    }
}