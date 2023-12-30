package org.campus.banking.service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Manages the transactions for each transactional banking operations.
 *   
 * @author Alireza Dastyar
 */
public interface Transaction {

    /**
     * Contains the diffrent types of transactions,
     *   
     * @author Alireza Dastyar
     */
    public static enum Type {
        DEPOSIT, WITHDRAW, LOAN, LOAN_PAYMENT, INVESTMENT
    }

    /**
     * Contains the diffrent states of transactions,
     *   
     * @author Alireza Dastyar
     */
    public static enum Status {
        COMPLETED, PENDING, CANCELED
    }

    /** 
     * Excutes the transaction.
     * Until this method is called the transaction is in pending state
     * which means that the operation has'nt happened yet.
     * 
    */
    void execute();

    /** 
     * Rollbacks the transaction.
     * This method has effects only if excute is already called and you need
     * to revert the changes of operation.
     * 
    */
    void rollback();
    
    /**
     * Return the transaction id.
     * @return the transaction id.
     */
    long getTransactionId();

    /**
     * Return the underlying account.
     * 
     * @return the underlying account.
     */
    BankAccount getAccount();
    
    /**
     * Return the current state of transaction.
     * 
     * @return the current state of transaction.
     */
    Status getStatus();   
     
    /**
     * Return the type of transaction.
     * 
     * @return the type of transaction.
     */
    Type getType();  
         
    /**
     * Return the date and time of transaction.
     * 
     * @return the date and time of transaction.
     */
    Optional<LocalDateTime> getDate();    
} 