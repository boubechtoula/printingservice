package com.abesoft.printingservice.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author b.walid
 */
@RestController
public class PrintingController {

    @RequestMapping("hi")
    public String hello() {
        return "Hello world ! ";
    }

}
