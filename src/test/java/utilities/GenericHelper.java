package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GenericHelper {
    private static final Logger oLog = LogManager.getLogger(GenericHelper.class);

    public GenericHelper( ) {
        oLog.debug("GenericHelper : " + Driver.getInstance().getDriver().hashCode());
    }
}
