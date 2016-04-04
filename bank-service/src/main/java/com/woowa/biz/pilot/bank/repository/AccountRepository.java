package com.woowa.biz.pilot.bank.repository;

import com.woowa.biz.pilot.bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByAccountNumberList(String accountNumber);

    Account findByAccountNumber(String accountNumber);
}
