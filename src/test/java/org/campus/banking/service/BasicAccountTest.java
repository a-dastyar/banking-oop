package org.campus.banking.service;

import org.junit.jupiter.api.BeforeEach;

public class BasicAccountTest extends BankAccountTest {

    @BeforeEach
    public void setup() {
        this.instance = new BasicAccount(this.generator, this.trxFactory, "User1");
    }

}
