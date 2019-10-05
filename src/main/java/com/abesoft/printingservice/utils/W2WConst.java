package com.abesoft.printingservice.utils;

/**
 *
 * @author b.walid
 */
import java.io.File;
import java.nio.charset.Charset;
import java.util.Locale;

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
    private static final String USER_HOME_PATH = System.getProperty("user.home");
    private static final String DATA_FOLDER_NAME = "data";
    public static final String PARAMS_FILE = "params.xml";
    private static final String APP_CONFIG_FOLDER = "PrintingConfig";

    public static String getRootFolderPath() {
        File file = new File(USER_HOME_PATH + File.separator + APP_CONFIG_FOLDER);
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(USER_HOME_PATH + File.separator + APP_CONFIG_FOLDER).getPath();
    }
}
