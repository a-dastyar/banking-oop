package org.campus.banking.service;

import java.util.function.Consumer;

/**
 * A singleton implementation of `TransactionFactory`.
 * 
 * @author Alireza Dastyar
 */
public enum TransactionFactoryImpl implements TransactionFactory {
    INSTANCE;
    
    @Override
    public Transaction newWithdraw(BankAccount account, long amount, Consumer<Long> action,
            Consumer<Long> reverse) {
        return new TransactionImpl(account, Transaction.Type.WITHDRAW, amount, action, reverse);
    }

    @Override
    public Transaction newDeposit(BankAccount account, long amount, Consumer<Long> action, Consumer<Long> reverse) {
        return new TransactionImpl(account, Transaction.Type.DEPOSIT, amount, action, reverse);
    }

    @Override
    public Transaction newLoan(BankAccount account, long amount, Consumer<Long> action, Consumer<Long> reverse) {
        return new TransactionImpl(account, Transaction.Type.LOAN, amount, action, reverse);
    }

    @Override
    public Transaction newLoanPayment(BankAccount account, long amount, Consumer<Long> action,
            Consumer<Long> reverse) {
        return new TransactionImpl(account, Transaction.Type.LOAN_PAYMENT, amount, action, reverse);
    }

    @Override
    public Transaction newInvestment(BankAccount account, long amount, Consumer<Long> action,
            Consumer<Long> reverse) {
        return new TransactionImpl(account, Transaction.Type.INVESTMENT, amount, action, reverse);
    }

}
