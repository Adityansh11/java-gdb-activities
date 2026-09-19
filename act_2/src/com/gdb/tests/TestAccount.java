package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
    public static void main(String[] args) {
        System.out.println("=== Activity 2: Test Account Suite ===");

        Account acc = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE");

        boolean test1 = acc.getBalance() == 5000.0;
        System.out.println("Test 1 (Initial Balance 5000.0): " + (test1 ? "[PASS]" : "[FAIL]"));

        boolean depositResult = acc.deposit(2000.0);
        boolean test2 = depositResult && acc.getBalance() == 7000.0;
        System.out.println("Test 2 (Deposit 2000.0 -> Balance 7000.0): " + (test2 ? "[PASS]" : "[FAIL]"));

        boolean negativeDepositResult = acc.deposit(-500.0);
        boolean test3 = !negativeDepositResult && acc.getBalance() == 7000.0;
        System.out.println("Test 3 (Negative Deposit -> Rejected): " + (test3 ? "[PASS]" : "[FAIL]"));

        boolean withdrawalResult = acc.withdraw(3000.0);
        boolean test4 = withdrawalResult && acc.getBalance() == 4000.0;
        System.out.println("Test 4 (Withdraw 3000.0 -> Balance 4000.0): " + (test4 ? "[PASS]" : "[FAIL]"));

        boolean excessiveWithdrawalResult = acc.withdraw(10000.0);
        boolean test5 = !excessiveWithdrawalResult && acc.getBalance() == 4000.0;
        System.out.println("Test 5 (Exceeding Withdrawal -> Rejected): " + (test5 ? "[PASS]" : "[FAIL]"));

        boolean negativeWithdrawalResult = acc.withdraw(-100.0);
        boolean test6 = !negativeWithdrawalResult && acc.getBalance() == 4000.0;
        System.out.println("Test 6 (Negative Withdrawal -> Rejected): " + (test6 ? "[PASS]" : "[FAIL]"));

        System.out.println("=== Complete Activity 2 unit tests and verify output ===");
    }
}