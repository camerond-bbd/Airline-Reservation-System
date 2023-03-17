package co.za.bbd.ars.helpers;

import org.apache.commons.lang3.StringUtils;

public class StringHelper {
    public static boolean isEmptyOrNull(String s) {
        return StringUtils.isEmpty(s);
    }

    public static void checkStringParam(String paramName, String paramValue) {
        if(isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(
                    String.format("Invalid value for params: %s", paramName)
            );
    }
}
