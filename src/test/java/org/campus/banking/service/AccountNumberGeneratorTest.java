package org.campus.banking.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public abstract class AccountNumberGeneratorTest {

    AccountNumberGenerator instance;

    @Test
    void generate() {
        var number = this.instance.generate();
        assertTrue(number >= 0L);
    }

}
