package org.campus.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public interface InvestmentCapableTest{

    @Test
    default void invest(){
        var amount = 100L;
        this.getInvestmentCapableAccount().invest(amount).execute();
        assertEquals(this.getInvestmentCapableAccount().getTotalInvestment(), amount);
    }

    @Test
    default void totalInvestment(){
        assertEquals(this.getInvestmentCapableAccount().getTotalInvestment(), 0L);
    }

    InvestmentCapable getInvestmentCapableAccount();
}