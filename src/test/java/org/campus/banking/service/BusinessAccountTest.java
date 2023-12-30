package org.campus.banking.service;

import org.junit.jupiter.api.BeforeEach;

public class BusinessAccountTest extends BankAccountTest implements LoanableTest,InvestmentCapableTest {


    @BeforeEach
    public void setup() {
        this.instance = new BusinessAccount(this.generator, this.trxFactory, "User1");
    }

    @Override
    public Loanable getLoanableAccount() {
        return (BusinessAccount) this.instance;
    }

    @Override
    public InvestmentCapable getInvestmentCapableAccount() {
        return (BusinessAccount) this.instance;
    }



}
