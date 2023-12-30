package org.campus.banking.service;

/**
 * Provides the basic implementaion for `BankAccount` interface.
 * It is to be used as base of other bank accounts.
 *
 * @author Alireza Dastyar
 */
public abstract class GenericBankAccount implements BankAccount {

    protected String ownerName;
    protected long accountNumber;
    protected final TransactionFactory trxFactory;
    protected long balance = 0;

    public GenericBankAccount(AccountNumberGenerator numberGen, TransactionFactory trxFactory, String ownerName) {
        this.accountNumber = numberGen.generate();
        this.trxFactory = trxFactory;
        this.ownerName = ownerName;
    }

    @Override
    public Transaction withdraw(long amount) {
        return this.trxFactory.newWithdraw(this, amount, this::doWithdraw, this::doDeposit);
    }

    @Override
    public Transaction deposit(long amount) {
        return this.trxFactory.newDeposit(this, amount, this::doDeposit, this::doWithdraw);
    }

    private void doWithdraw(long amount) {
        if (amount > this.balance) {
            throw new InsufficientFoundException();
        }
        this.balance -= amount;
    }

    private void doDeposit(long amount) {
        this.balance += amount;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }
}
