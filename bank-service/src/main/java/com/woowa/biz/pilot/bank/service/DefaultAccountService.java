package com.woowa.biz.pilot.bank.service;

import com.woowa.biz.pilot.bank.domain.Account;
import com.woowa.biz.pilot.bank.domain.User;
import com.woowa.biz.pilot.bank.dto.AccountAddRequest;
import com.woowa.biz.pilot.bank.repository.AccountRepository;
import com.woowa.biz.pilot.bank.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class DefaultAccountService implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultAccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AccountCreationResult createAccount(AccountAddRequest accountAddRequest) {

        User user = userRepository.findByName(accountAddRequest.getUserName());

        logger.info("found user: {}", user);

        if (isTheAccountNumberExists(accountAddRequest)) {
            return AccountCreationResult.ALREADY_EXIST;
        }
        Account account = new Account(accountAddRequest.getAccountNumber(), accountAddRequest.getDescription(), new Date(), new Date());
        account.setUser(user);

        accountRepository.save(account);

        return AccountCreationResult.OK;
    }

    private boolean isTheAccountNumberExists(AccountAddRequest accountAddRequest) {
        return accountRepository.findByAccountNumber(accountAddRequest.getAccountNumber()).size() > 0;
    }
}
