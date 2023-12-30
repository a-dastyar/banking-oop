package org.campus.banking.service;

/**
 * Investment features and functionalities for bank accounts.
 * 
 * @author Alireza Dastyar
 */
public interface InvestmentCapable {

    /**
     * Constructs a transaction object which handles the investment trasnaction.
     * Inorder to complete the investment, you must call {@code execute()} on the returned transaction.
     * 
     * Example:
     *  var investTrx = account.invest(100);
     *  investTrx.execute();
     * 
     * In case of failure you can always rollback the transaction by using the 
     * {@code rollback()} method on transaction object.
     * 
     * Example:
     *  var investTrx = account.invest(100);
     *  investTrx.rollback();
     * 
     * @param amount the amount that is to be invested.
     * @return the transaction that carries the investment. 
     */
    Transaction invest(long amount);

    /**
     * Returns the total amount of investments.
     * 
     * @return the total amount of investments.
     */
    long getTotalInvestment();
}
