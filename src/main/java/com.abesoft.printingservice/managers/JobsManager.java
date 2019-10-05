package com.abesoft.printingservice.managers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class JobsManager {

    public String test() {
        String test = "null";
        return test;
    }
}
