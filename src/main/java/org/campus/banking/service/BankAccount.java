package org.campus.banking.service;

/**
 * Manages the core functionality for all types of bank accounts.
 * Functionalities such as deposit and withdraw.
 * 
 * @author Alireza Dastyar
 */
public interface BankAccount {

    /**
     * Constructs a transaction object which handles the withdraw trasnaction.
     * Inorder to complete the withdraw, you must call {@code execute()} on the returned transaction.
     * 
     * Example:
     *  var withdrawTrx = account.withdraw(100);
     *  withdrawTrx.execute();
     * 
     * In case of failure you can always rollback the transaction by using the 
     * {@code rollback()} method on transaction object.
     * 
     * Example:
     *  var withdrawTrx = account.withdraw(100);
     *  withdrawTrx.rollback();
     * 
     * @param amount the amount that is to be withdrawn.
     * @return the transaction that carries the withdraw. 
     */
    Transaction withdraw(long amount);


    /**
     * Constructs a transaction object which handles the deposit trasnaction.
     * Inorder to complete the deposit, you must call {@code execute()} on the returned transaction.
     * 
     * Example:
     *  var depositTrx = account.deposit(100);
     *  depositTrx.execute();
     * 
     * In case of failure you can always rollback the transaction by using the 
     * {@code rollback()} method on transaction object.
     * 
     * Example:
     *  var depositTrx = account.deposit(100);
     *  depositTrx.rollback();
     * 
     * @param amount the amount that is to deposit.
     * @return the transaction that carries the deposit. 
     */
    Transaction deposit(long amount);

    /**
     * Returns the current balance of the account.
     * 
     * @return balance of the account.
     */
    long getBalance();

    /**
     * Returns the account owner's name.
     * 
     * @return the account owner's name.
     */
    String getOwnerName();

    /**
     * Returns the account number.
     * 
     * @return the account number.
     */
    long getAccountNumber();

}
