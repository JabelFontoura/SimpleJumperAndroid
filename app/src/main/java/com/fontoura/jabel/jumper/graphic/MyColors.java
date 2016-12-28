package com.fontoura.jabel.jumper.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by Jabel on 12/26/2016.
 */
public class MyColors {

    public static Paint geBirdColor() {
        Paint red = new Paint();
        red.setColor(0xFFFF0000);
        return red;
    }

    public static Paint getTubeColor(){
        Paint green = new Paint();
        green.setColor(0xFF00FF00);
        return green;
    }

    public static Paint getScoreColor() {
        Paint white = new Paint();
        white.setColor(0xFFFFFFFF);
        white.setTextSize(120);
        white.setTypeface(Typeface.DEFAULT_BOLD);
        white.setShadowLayer(3, 5, 5,0xFF000000);
        return white;
    }

    public static Paint getOverColor(){
        Paint over = new Paint();
        over.setColor(0xFFFF2222);
        over.setTextSize(140);
        over.setTypeface(Typeface.DEFAULT_BOLD);
        over.setShadowLayer(3, 5, 5, 0xFF000000);
        return over;
    }
}
