package org.campus.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public abstract class BankAccountTest {

    BankAccount instance;
    AccountNumberGenerator generator = BasicAccountNumberGenerator.INSTANCE;
    TransactionFactory trxFactory = TransactionFactoryImpl.INSTANCE;

    @Test
    void deposit() {
        var amount = 100L;
        instance.deposit(amount).execute();
        assertEquals(amount, instance.getBalance());
    }

    @Test
    void withdraw() {
        var amount = 100L;
        instance.deposit(amount).execute();
        instance.withdraw(amount).execute();
        assertEquals(0L, instance.getBalance());
    }

    @Test
    void withdraw_insuficentFunds() {
        var amount = 100L;
        var trx = instance.withdraw(amount);
        var ex = assertThrows(InsufficientFoundException.class, trx::execute);
        assertNotNull(ex);
    }

    @Test
    void getBalance() {
        assertEquals(0L, instance.getBalance());
    }
}
