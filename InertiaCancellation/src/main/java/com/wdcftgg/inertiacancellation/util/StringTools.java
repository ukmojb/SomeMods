package com.wdcftgg.inertiacancellation.util;

public class StringTools {

    public static String ticksToElapsedTime(int ticks) {
        int i = ticks / 20;
        int j = i / 60;
        i %= 60;
        return i < 10 ? j + ":0" + i : j + ":" + i;
    }

    public static String serverI18n(String key) {
        return "{*" + key + "*}";
    }
}
