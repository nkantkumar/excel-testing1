package com.puretech.payment;

import java.util.concurrent.locks.ReentrantLock;

class Account {
    private int id;
    private long balance;
    private ReentrantLock lock = new ReentrantLock();

    public Account(int id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void withdraw(long amount) {
        if (balance < amount) throw new RuntimeException("Insufficient funds");
        balance -= amount;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public long getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
