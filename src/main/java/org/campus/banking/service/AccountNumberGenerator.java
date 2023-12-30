package org.campus.banking.service;

/**
 * Provides a generator function which can be used to 
 * generate bank account numbers.
 * 
 * @author Alireza Dastyar
 */
public interface AccountNumberGenerator {

    /**
     *  Generates a account number.
     * 
     * @return bank account number
     */
    public long generate();
 }
