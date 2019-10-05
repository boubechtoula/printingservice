package com.abesoft.printingservice.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wbo
 */
public class ParametersParser {

    public ParametersParser() {
    }
    private static Logger logger = LoggerFactory.getLogger(ParametersParser.class);
    public static final int UNIT = 1000;

    private static XmlParams xmlConst;

    //params abonnement
    public static String getPASSWORD() throws IOException {
        return readXMLfile().getParamLoginElem().getParam_password();
    }

    public static XmlParams readXMLfile() throws IOException {

        if (xmlConst == null) {
            try {
                File file = new File(W2WConst.getRootFolderPath() + File.separator + W2WConst.PARAMS_FILE);
                if (!file.exists()) {
                    file = new File(ParametersParser.class.getClassLoader().getResource("params/params.xml").getFile());
                }
                Unmarshaller unmarshaller = JAXBContext.newInstance(XmlParams.class, ParamLoginElem.class).createUnmarshaller();

                xmlConst = (XmlParams) unmarshaller.unmarshal(file);
            } catch (JAXBException ex) {
                logger.error("Fichier XML de paramétrage corrompu", ex);
            }
        }

        return xmlConst;
    }

    public static void exportXMLfile() throws IOException {

        try {
            File toFile = new File(W2WConst.getRootFolderPath() + File.separator + W2WConst.PARAMS_FILE);
            if (!toFile.exists()) {
                String from = ParametersParser.class.getClassLoader().getResource("params/params.xml").getPath();
                Files.copy(Paths.get(from), toFile.toPath());
            }
        } catch (IOException ex) {
            logger.error("Fichier XML de param�trage corrompu", ex);
        }
    }

    public static void clearParams() {
        xmlConst = null;
    }

}
