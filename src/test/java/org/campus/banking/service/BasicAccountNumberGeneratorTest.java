package org.campus.banking.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicAccountNumberGeneratorTest extends AccountNumberGeneratorTest {

    @BeforeEach
    public void setup(){
        this.instance = BasicAccountNumberGenerator.INSTANCE;
    }

    @Test
    void generateBasic(){
        var number=this.instance.generate();
        assertTrue(number >= 140300000);
    }
}