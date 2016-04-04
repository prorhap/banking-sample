package com.woowa.biz.pilot.bank.service;

import com.woowa.biz.pilot.bank.dto.AccountAddRequest;
import com.woowa.biz.pilot.bank.dto.TransferRequest;

public interface AccountService {
    public AccountCreationResult createAccount(AccountAddRequest accountAddRequest);
    public TransferResult transfer(TransferRequest transferRequest);
}
