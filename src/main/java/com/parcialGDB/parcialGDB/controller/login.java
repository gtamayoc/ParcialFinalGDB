package com.parcialGDB.parcialGDB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class login {

    @GetMapping(value = "/")
    public void login(){

    }

}
