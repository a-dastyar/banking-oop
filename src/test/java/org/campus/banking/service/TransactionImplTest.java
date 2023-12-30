package org.campus.banking.service;

import org.junit.jupiter.api.BeforeEach;

public class TransactionImplTest extends TransactionTest {

    @BeforeEach
    public void setup() {
        var generator = BasicAccountNumberGenerator.INSTANCE;
        var factory = TransactionFactoryImpl.INSTANCE;
        var account = new BusinessAccount(generator, factory, "User1");
        var amount = 100L;
        this.instance = account.deposit(amount);
    }
}
