package com.abesoft.printingservice.managers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class PdfsManager {

    public String test() {
        return "helow world !";
    }
}
