package com.abesoft.printingservice.managers;

import com.abesoft.printingservice.utils.ParametersParser;
import com.abesoft.printingservice.utils.W2WConst;
import com.abesoft.printingservice.utils.XmlParams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class ParamsManager {

    private XmlParams params;
    private JAXBContext context;

    private String pwd;
    private String newPwd;

    public ParamsManager() throws IOException, JAXBException {
        context = JAXBContext.newInstance(XmlParams.class);
        params = ParametersParser.readXMLfile();

        pwd = newPwd = params.getParamLoginElem().getParam_password();
    }

    @PostConstruct
    public void init() {
        try {
            params = ParametersParser.readXMLfile();
        } catch (IOException ex) {
            Logger.getLogger(ParamsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveAbonnementParamToXMLfile() throws JAXBException {
        try {
            //recuperer le ficher Xml des parametre
            File file = getparamsXMl();
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            params.getParamLoginElem().setParam_password(newPwd);
            //enregister les params
            marshaller.marshal(params, file);
            ParametersParser.clearParams();
        } catch (Exception e) {
            Logger.getLogger(ParamsManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private File getparamsXMl() throws IOException {
        File file = new File(W2WConst.getRootFolderPath() + File.separator + W2WConst.PARAMS_FILE);
        if (!file.exists()) {
            File fd = new File(ParametersParser.class.getClassLoader().getResource("params/params.xml").getFile());
            file.createNewFile();
            copyFileParam(fd, file);
        }
        return file;
    }
    //todo to mettre dans une super class

    private void copyFileParam(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {

            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
