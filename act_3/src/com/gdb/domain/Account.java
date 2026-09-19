package com.gdb.domain;

public class Account {
    private String accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private String pin;

    public Account(String accountNumber, String name, int age, double balance, String accountType, String status, String pin) {
        if (age < 18) {
            throw new IllegalArgumentException("Account holder must be at least 18 years old");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        if (pin == null || !pin.matches("\\d{4}")) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits");
        }

        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.accountType = accountType;
        this.status = status;
        this.pin = pin;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount, String enteredPin) {
        if (!validatePin(enteredPin)) {
            return false;
        }

        if (!"ACTIVE".equals(status)) {
            return false;
        }

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public boolean validatePin(String inputPin) {
        return inputPin != null && !inputPin.isEmpty() && inputPin.equals(pin);
    }

    public boolean changePin(String oldPin, String newPin) {
        if (!validatePin(oldPin)) {
            return false;
        }

        if (newPin == null || !newPin.matches("\\d{4}")) {
            return false;
        }

        pin = newPin;
        return true;
    }

    public void suspend() {
        status = "SUSPENDED";
    }

    public void activate() {
        status = "ACTIVE";
    }

    public void close() {
        status = "CLOSED";
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}