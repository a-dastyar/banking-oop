package org.campus.banking.service;

import java.util.function.Consumer;

/**
 * Constructs the `Transaction` objects for each transaction type.
 * 
 * @author Alireza Dastyar
 */
public interface TransactionFactory {
    Transaction newWithdraw(BankAccount account, long amount, Consumer<Long> action, Consumer<Long> reverse);

    Transaction newDeposit(BankAccount account, long amount, Consumer<Long> action, Consumer<Long> reverse);

    Transaction newLoan(BankAccount account, long amount, Consumer<Long> action, Consumer<Long> reverse);

    Transaction newLoanPayment(BankAccount account, long amount, Consumer<Long> action, Consumer<Long> reverse);

    Transaction newInvestment(BankAccount account, long amount, Consumer<Long> action, Consumer<Long> reverse);
}
