package org.campus.banking.app;

import org.campus.banking.service.BankAccount;
import org.campus.banking.service.BasicAccount;
import org.campus.banking.service.BasicAccountNumberGenerator;
import org.campus.banking.service.BusinessAccount;
import org.campus.banking.service.InsufficientFoundException;
import org.campus.banking.service.InvestmentCapable;
import org.campus.banking.service.Loanable;
import org.campus.banking.service.PremiumAccount;
import org.campus.banking.service.TransactionFactoryImpl;

/**
 *
 * @author Alireza Dastyar
 */
public class Banking {

    public static void main(String[] args) {
        checkBasicAccounts();
        checkPremiumAccounts();
        checkBusinessAccounts();
    }

    private static void checkBasicAccounts() {
        var baiscGenerator = BasicAccountNumberGenerator.INSTANCE;
        var trxFactory = TransactionFactoryImpl.INSTANCE;
        
        var account1 = new BasicAccount(baiscGenerator, trxFactory, "User1");
        var account2 = new BasicAccount(baiscGenerator, trxFactory, "User2");
        long amount = 100;

        System.out.println("------- Checking basic functionlity for BasicAccount ----------\n");
        checkBasicFunctionality(amount, account1, account2);
    }

    private static void checkPremiumAccounts() {
        var baiscGenerator = BasicAccountNumberGenerator.INSTANCE;
        var trxFactory = TransactionFactoryImpl.INSTANCE;
        
        var account1 = new PremiumAccount(baiscGenerator, trxFactory, "User1");
        var account2 = new PremiumAccount(baiscGenerator, trxFactory, "User2");
        long amount = 100;

        System.out.println("------- Checking basic functionlity for PremiumAccount ----------\n");
        checkBasicFunctionality(amount, account1, account2);
        System.out.println("------- Checking investment functionlity for PremiumAccount ----------\n");
        checkInvestmentFunctionality(amount,account1);
    }

    private static void checkBusinessAccounts() {
        var baiscGenerator = BasicAccountNumberGenerator.INSTANCE;
        var trxFactory = TransactionFactoryImpl.INSTANCE;
        
        var account1 = new BusinessAccount(baiscGenerator, trxFactory, "User1");
        var account2 = new BusinessAccount(baiscGenerator, trxFactory, "User2");
        long amount = 100;

        System.out.println("------- Checking basic functionlity for BusinessAccount ----------\n");
        checkBasicFunctionality(amount, account1, account2);
        System.out.println("------- Checking investment functionlity for BusinessAccount ----------\n");
        checkInvestmentFunctionality(amount,account1);
        System.out.println("------- Checking loan functionlity for BusinessAccount ----------\n");
        checkLoanFunctionality(amount,account1);
    }

    private static void addFunds(BankAccount account, long amount) {
        account.deposit(amount).execute();
        System.out.println("Deposit completed\n");
    }

    private static void withdrawFunds(BankAccount account, long amount) {
        account.withdraw(amount).execute();
        System.out.println("Withdraw completed\n");
    }

    private static void transactionalTransfer(BankAccount from, BankAccount to, long amount) {
        var trx1 = from.withdraw(amount);
        var trx2 = to.deposit(amount);
        try {
            trx1.execute();
            trx2.execute();
            System.out.println("Transfer completed\n");
        } catch (InsufficientFoundException e) {
            trx1.rollback();
            trx2.rollback();
            System.out.println("Insufficient founds!!!\n");
        }
    }

    private static void checkBasicFunctionality(long amount, BankAccount account1, BankAccount account2) {
        System.out.printf("Deposit %d$ to account1\n", amount);
        addFunds(account1, amount);
        
        System.out.printf("Transfer %d$ from account1 to account2\n", amount);
        transactionalTransfer(account1, account2, amount);
        
        System.out.printf("Transfer %d$ from account1 to account2 again! \n", amount);
        transactionalTransfer(account1, account2, amount);
        
        System.out.printf("Withdraw %d$ from account2\n", amount);
        withdrawFunds(account2, amount);
    }

    private static void checkInvestmentFunctionality(long amount, InvestmentCapable account1) {
        System.out.printf("Investing %d$ to account1\n", amount);
        account1.invest(amount).execute();
        System.out.printf("Total investment for account1: %d$ \n\n", account1.getTotalInvestment());
    }

    private static void checkLoanFunctionality(long amount, Loanable account1) {
        System.out.printf("Loaning %d$ to account1\n", amount);
        account1.loan(amount).execute();
        System.out.printf("Total debt for account1: %d$ \n", account1.getTotalDebt());
        System.out.printf("Paying %d$ as loan payemnt from account1\n", amount/2);
        account1.pay(amount).execute();
        System.out.printf("Total debt for account1: %d$ \n\n", account1.getTotalDebt());

    }
}
