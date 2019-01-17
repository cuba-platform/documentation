package com.company.demo.web;

public class ZeroBalanceException extends RuntimeException {

    public ZeroBalanceException() {
        super("Insufficient funds in your account");
    }
}