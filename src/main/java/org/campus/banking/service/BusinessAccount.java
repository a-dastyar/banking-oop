package org.campus.banking.service;

/**
 * This class provides the business-class banking features to `BankAccount`
 * such as loaning and investment. 
 *
 * @author Alireza Dastyar
 */
public class BusinessAccount extends GenericBankAccount implements Loanable, InvestmentCapable {

    private short interestRate;
    private long debt;
    private long investment;

    public BusinessAccount(AccountNumberGenerator numberGen, TransactionFactory trxFactory, String ownerName) {
        super(numberGen, trxFactory, ownerName);
    }

    public BusinessAccount(AccountNumberGenerator numberGen, TransactionFactory trxFactory, String ownerName, short interestRate) {
        super(numberGen, trxFactory, ownerName);
        this.interestRate = interestRate;
    }

    @Override
    public Transaction loan(long amount) {
        return this.trxFactory.newLoan(this, amount, this::doLoan, this::doPay);
    }

    private void doLoan(long amount) {
        this.debt += amount;
    }

    @Override
    public Transaction pay(long amount) {
        return this.trxFactory.newLoanPayment(this, amount, this::doPay, this::doLoan);
    }

    private void doPay(long amount) {
        this.debt -= amount;
    }

    @Override
    public long getTotalDebt() {
        return this.debt;
    }

    @Override
    public Transaction invest(long amount) {
        return this.trxFactory.newInvestment(this, amount, this::doInvest, this::revertInvestment);
    }

    private void doInvest(long amount) {
        this.investment += amount;
    }

    private void revertInvestment(long amount) {
        this.investment -= amount;
    }

    @Override
    public long getTotalInvestment() {
        return this.investment;
    }

    public short getInterestRate() {
        return this.interestRate;
    }

}
