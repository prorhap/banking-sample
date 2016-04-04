package com.woowa.biz.pilot.bank.service;

import com.woowa.biz.pilot.bank.dto.AccountAddRequest;

public interface AccountService {
    public AccountCreationResult createAccount(AccountAddRequest accountAddRequest);
}
