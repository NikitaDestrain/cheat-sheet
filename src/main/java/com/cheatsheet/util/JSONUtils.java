package com.cheatsheet.util;

public class JSONUtils {
    private static volatile JSONUtils instance;

    private JSONUtils() {
    }

    public static JSONUtils getInstance() {
        JSONUtils localInstance = instance;
        if (localInstance == null) {
            synchronized (JSONUtils.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new JSONUtils();
                }
            }
        }
        return localInstance;
    }
}
