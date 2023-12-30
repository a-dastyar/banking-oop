package org.campus.banking.service;

/**
 * The most basic bank account which only does inherted actions
 * such as deposit and withdraw.
 * 
 * @author Alireza Dastyar
 */
public class BasicAccount extends GenericBankAccount {

    public BasicAccount(AccountNumberGenerator numberGen, TransactionFactory trxFactory, String ownerName) {
        super(numberGen, trxFactory, ownerName);
    }


}
