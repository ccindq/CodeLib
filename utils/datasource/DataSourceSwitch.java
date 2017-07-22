package com.cc.utils.datasource;

/**
 * @author changcheng
 * @version 2017/7/22
 * @description
 */
public class DataSourceSwitch {
    private static ThreadLocal<String> key = new ThreadLocal<String>();

    public static void setKey(String key_in) {
        key.set(key_in);
    }

    public static String getKey() {
        return key.get();
    }

    public static void clearKey() {
        key.remove();
    }
}
