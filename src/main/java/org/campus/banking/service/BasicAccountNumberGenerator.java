package org.campus.banking.service;

/**
 * Provides a very baisc implementation for `AccountNumberGenerator`.
 * Which uses the 4-digits of the year (hardcoded to be changed) followed by 5 zeros 
 * as the starting point and keeps incrementing it.
 * 
 * @author Alireza Dastyar
 */
public enum BasicAccountNumberGenerator implements AccountNumberGenerator {
    INSTANCE;

    private long counter = 1;
    private final long prefix = 140300000;

    @Override
    public long generate() {
        return prefix + counter++;
    }
}
