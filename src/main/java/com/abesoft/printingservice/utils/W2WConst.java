package com.abesoft.printingservice.utils;


/**
 *
 * @author b.walid
 */
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author lid
 */
public final class W2WConst {

    private W2WConst() {
    }

    public static final Charset FILE_ENCODING = Charset.forName("ISO-8859-1");
    public static final String FILE_NEW_LINE = "\n";
    public static final Locale LOCALE = Locale.FRENCH;
    private static final String DOMAIN_PATH = System.getProperty("com.sun.aas.instanceRoot");
    private static final String DATA_FOLDER_NAME = "data";

    public static String getRootFolderPath() throws IOException {
        return new ClassPathResource("params/params.xml").getFile().getPath();
    }
}
