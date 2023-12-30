package org.campus.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public interface LoanableTest {

    @Test
    default void loan() {
        var amount = 100L;
        this.getLoanableAccount().loan(amount).execute();
        assertEquals(this.getLoanableAccount().getTotalDebt(), amount);
    }

    @Test
    default void pay() {
        var amount = 100L;
        var payed = 10L;
        this.getLoanableAccount().loan(amount).execute();
        this.getLoanableAccount().pay(payed).execute();
        assertEquals(this.getLoanableAccount().getTotalDebt(), amount-payed);
    }

    @Test
    default void totalDebt() {
        assertEquals(this.getLoanableAccount().getTotalDebt(), 0L);
    }

    Loanable getLoanableAccount();
}
