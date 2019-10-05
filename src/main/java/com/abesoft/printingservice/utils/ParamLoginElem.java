package com.abesoft.printingservice.utils;

/**
 *
 * @author b.walid
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wbo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ParamLoginElem {

    private String param_password;

    public String getParam_password() {
        return param_password;
    }

    public void setParam_password(String param_password) {
        this.param_password = param_password;
    }
}
