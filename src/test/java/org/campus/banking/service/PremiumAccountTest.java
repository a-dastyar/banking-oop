package org.campus.banking.service;

import org.junit.jupiter.api.BeforeEach;

public class PremiumAccountTest extends BankAccountTest implements InvestmentCapableTest {

    @BeforeEach
    public void setup() {
        this.instance = new PremiumAccount(this.generator, this.trxFactory, "User1");
    }

    @Override
    public InvestmentCapable getInvestmentCapableAccount() {
        return (PremiumAccount)this.instance;
    }

}
