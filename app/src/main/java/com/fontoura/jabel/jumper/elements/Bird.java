package com.fontoura.jabel.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.fontoura.jabel.jumper.R;
import com.fontoura.jabel.jumper.engine.Sound;
import com.fontoura.jabel.jumper.graphic.MyColors;
import com.fontoura.jabel.jumper.graphic.Screen;

/**
 * Created by Jabel on 12/26/2016.
 */

public class Bird {

    public static final float X = 200;
    public static final int RADIUS = 60;
    private static final Paint RED = MyColors.geBirdColor();
    private final Bitmap bird;
    private float height;
    private Screen screen;
    private Sound sound;

    public Bird(Screen screen, Context context, Sound sound) {
        this.screen = screen;
        this.sound = sound;
        this.height = 500;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird);
        this.bird = Bitmap.createScaledBitmap(bp, RADIUS * 2, RADIUS * 2, false);
    }

    public void drawOn(Canvas canvas){
        canvas.drawBitmap(bird, X - RADIUS, height - RADIUS, null);
    }

    public void fall() {
        boolean reachGround = height + RADIUS > screen.getHeight();
        
        if(!reachGround) {
            this.height += 15;
        }
    }

    public void jump() {
        if(height - RADIUS > 0) {
            sound.play(Sound.JUMP);
            this.height -= 165;
        }
    }

    public float getHeight() {
        return height;
    }
}
