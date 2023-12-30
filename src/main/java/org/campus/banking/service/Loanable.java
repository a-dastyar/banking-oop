package org.campus.banking.service;

/**
 * Loan features and functionalities for bank accounts.
 *
 * @author Alireza Dastyar
 */
public interface Loanable {

    /**
     * Constructs a transaction object which handles the loan trasnaction.
     * Inorder to complete the loan, you must call {@code execute()} on the returned
     * transaction.
     *```
     * Example: 
     *  var loanTrx = account.loan(100); 
     *  loanTrx.execute();
     *```
     * In case of failure you can always rollback the transaction by using the
     * {@code rollback()} method on transaction object.
     *
     * Example: 
     *  var loanTrx = account.loan(100); 
     *  loanTrx.rollback();
     *
     * @param amount the amount that is to be loaned.
     * @return the transaction that carries the loan.
     */
    Transaction loan(long amount);

    /**
     * Constructs the transaction object which handles the loay payment
     * trasnaction. Inorder to complete the loay payment, you must call
     * {@code execute()} on the returned transaction.
     *
     * Example: var payTrx = account.pay(100); payTrx.execute();
     *
     * In case of failure you can always rollback the transaction by using the
     * {@code rollback()} method on transaction object.
     *
     * Example: var payTrx = account.pay(100); payTrx.rollback();
     *
     * @param amount the amount that is to be payed.
     * @return the transaction that carries the payment.
     */
    Transaction pay(long amount);

    /**
     * Returns total amount of debt.
     *
     * @return the total amount of debt.
     */
    long getTotalDebt();
}
