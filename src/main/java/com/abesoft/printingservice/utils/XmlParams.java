package com.abesoft.printingservice.utils;


/**
 *
 * @author b.walid
 */
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wbo
 */
@XmlRootElement(name = "xmlParams")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlParams implements Serializable {

    public final static int MILISEC = 1000;

    @XmlElement(name = "paramLoginElem")
    private ParamLoginElem paramLoginElem;

    public XmlParams() {
    }

    public ParamLoginElem getParamLoginElem() {
        return paramLoginElem;
    }

    public void setParamLoginElem(ParamLoginElem paramLoginElem) {
        this.paramLoginElem = paramLoginElem;
    }

}
