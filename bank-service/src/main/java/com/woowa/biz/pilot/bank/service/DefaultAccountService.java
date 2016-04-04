package com.woowa.biz.pilot.bank.service;

import com.google.common.collect.ImmutableMap;
import com.woowa.biz.pilot.bank.domain.Account;
import com.woowa.biz.pilot.bank.dto.AccountAddRequest;
import com.woowa.biz.pilot.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class DefaultAccountService implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountCreationResult createAccount(AccountAddRequest accountAddRequest) {

        if (isTheAccountNumberExists(accountAddRequest)) {
            return AccountCreationResult.ALREADY_EXIST;
        }

        Account account = new Account(accountAddRequest.getAccountNumber(), accountAddRequest.getDescription(), new Date(), new Date());
        accountRepository.save(account);

        return AccountCreationResult.OK;
    }

    private boolean isTheAccountNumberExists(AccountAddRequest accountAddRequest) {
        return accountRepository.findByAccountNumber(accountAddRequest.getAccountNumber()).size() > 0;
    }
}
