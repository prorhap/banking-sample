package com.woowa.biz.pilot.bank.repository;

import com.woowa.biz.pilot.bank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
