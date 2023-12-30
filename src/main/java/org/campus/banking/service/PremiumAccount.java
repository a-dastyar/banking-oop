package org.campus.banking.service;

/**
 * This class provides the business-class banking features to `BankAccount`
 * such as investment. 
 * 
 * @author Alireza Dastyar
 */
public class PremiumAccount extends GenericBankAccount implements InvestmentCapable{
    
    private short interstRate = 10;
    private long investment = 0;

    
    public PremiumAccount(AccountNumberGenerator numberGen, TransactionFactory trxFactory, String ownerName) {
        super(numberGen, trxFactory, ownerName);
    }

    @Override
    public Transaction invest(long amount) {
        return this.trxFactory.newInvestment(this,amount,this::doInvest,this::revertInvestment);
    }

    private void doInvest(long amount){
        this.investment += amount;
    }

    private void revertInvestment(long amount){
        this.investment -= amount;
    }

    @Override
    public long getTotalInvestment() {
        return this.investment;
    }

    public short getInterstRate() {
        return interstRate;
    }

    public void setInterstRate(short interstRate) {
        this.interstRate = interstRate;
    }


}
