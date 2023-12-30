package org.campus.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
public abstract class TransactionTest {
    Transaction instance;

    @Test
    void execute(){
        this.instance.execute();
        assertEquals(Transaction.Status.COMPLETED, this.instance.getStatus());
    }

    @Test
    void rollback(){
        this.instance.execute();
        this.instance.rollback();
        assertEquals(Transaction.Status.CANCELED, this.instance.getStatus());
        assertEquals(0L, this.instance.getAccount().getBalance());
    }

    @Test
    void rollback_withoutExecute(){
        this.instance.rollback();
        assertEquals(Transaction.Status.PENDING, this.instance.getStatus());
    }
  
}