package com.fontoura.jabel.jumper.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Jabel on 12/27/2016.
 */

public class Screen {

    private final DisplayMetrics metrics;

    public Screen(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        metrics = new DisplayMetrics();

        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);
    }

    public int getHeight(){
        return metrics.heightPixels;
    }

}
