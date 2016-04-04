package com.woowa.biz.pilot.bank.controller;

import com.google.common.collect.ImmutableMap;
import com.woowa.biz.pilot.bank.dto.AccountAddRequest;
import com.woowa.biz.pilot.bank.service.AccountCreationResult;
import com.woowa.biz.pilot.bank.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value="account", method= RequestMethod.POST)
    public @ResponseBody ImmutableMap registerAccount(@RequestBody AccountAddRequest accountAddRequest) {

        logger.info("-c-> registerAccount: {}", accountAddRequest);
        AccountCreationResult result = accountService.createAccount(accountAddRequest);

        return ImmutableMap.of("result", result);
    }
}
