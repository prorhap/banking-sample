package com.woowa.biz.pilot.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {

    private static final Logger logger = LoggerFactory.getLogger(BankApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Bank Application ...");
        SpringApplication.run(BankApplication.class, args);
    }
}
