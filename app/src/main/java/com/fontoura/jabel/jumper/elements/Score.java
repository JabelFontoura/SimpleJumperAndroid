package com.fontoura.jabel.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.fontoura.jabel.jumper.graphic.MyColors;

/**
 * Created by Jabel on 12/27/2016.
 */

public class Score {

    private static final Paint WHITE = MyColors.getScoreColor();
    private static final Paint OVER = MyColors.getOverColor();
    private int score = 0;

    public void drawOn(Canvas canvas) {
        canvas.drawText(String.valueOf(score), 100, 100, WHITE);
    }

    public void drawOnGameOver(Canvas canvas){
        canvas.drawText("Game Over", 200, 1000, OVER);
    }

    public void add() {
        score += 1;
    }
}
