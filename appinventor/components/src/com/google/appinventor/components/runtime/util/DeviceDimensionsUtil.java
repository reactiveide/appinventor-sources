package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.util.TypedValue;

public class DeviceDimensionsUtil {
    public static int getDisplayWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean isPortrait(Context context) {
        return getDisplayWidth(context) < getDisplayHeight(context);
    }

    public static int getDisplayHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float convertDpToPixel(float dp, Context context) {
        return TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    public static float convertPixelsToDp(float px, Context context) {
        return px / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }
}
