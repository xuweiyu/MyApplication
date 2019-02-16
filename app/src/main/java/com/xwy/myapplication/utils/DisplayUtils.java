package com.xwy.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Administrator on 2019/2/16.
 */

public class DisplayUtils {
    public static DisplayMetrics getDisplayMetrics(@NonNull Activity activity){
        WindowManager windowManager = activity.getWindowManager();
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }
}
