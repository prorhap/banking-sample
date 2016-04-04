package com.woowa.biz.pilot.bank.domain;

import com.woowa.biz.pilot.bank.service.TransferResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AccountFunctionalTest {

    private final Account sourceAccount = new Account("123", "first", new Date(), new Date());
    private final Account targetAccount = new Account("456", "second", new Date(), new Date());

    @Before
    public void setUp() throws Exception {
        sourceAccount.setBalance(5000);
        targetAccount.setBalance(3000);
    }

    @Test
    public void transfer() throws Exception {

        TransferResult result = sourceAccount.transfer(targetAccount, 1000);

        assertEquals(TransferResult.SUCCESS, result);
        assertTrue( 4000 == sourceAccount.getBalance() );
        assertTrue( 4000 == targetAccount.getBalance() );
    }

    @Test
    public void transferFailureWhenBalanceOfSourceAccountIsLessThenBalanceOfTargetAccount() throws Exception {

        TransferResult result = sourceAccount.transfer(targetAccount, 8000);

        assertEquals(TransferResult.NOT_ENOUGH_BALANCE, result);
        assertTrue( 5000 == sourceAccount.getBalance() );
        assertTrue( 3000 == targetAccount.getBalance() );
    }
}