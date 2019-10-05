package com.abesoft.printingservice.managers;

import com.abesoft.printingservice.managers.JobsManager;
import com.abesoft.printingservice.utils.ParametersParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class JobsManager {

    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public String test() {
        try {
            String test = ParametersParser.getPASSWORD();
            return test;
        } catch (IOException ex) {
            Logger.getLogger(JobsManager.class.getName()).log(Level.SEVERE, null, ex);
            return "Rien";
        }
    }
    

    public Object[] lists() {
        Map<String, String> map = new HashMap<>();
        map.put("dsd", "12212");
        map.put("dsod", "1");
        map.put("ds1d", "3");
        map.put("1dsd", "65");
        map.put("dsd1", "33");
        map.put("d1sd", "568");
        return map.entrySet().toArray();
    }
}
