package com.fontoura.jabel.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.fontoura.jabel.jumper.R;
import com.fontoura.jabel.jumper.graphic.MyColors;
import com.fontoura.jabel.jumper.graphic.Screen;

/**
 * Created by Jabel on 12/27/2016.
 */

public class Tube {

    private Bitmap topTube;
    private Bitmap bottomTube;
    private int heightBottomTube;
    private int heightTopTube;
    private int position;
    private Screen screen;
    private static final int TUBE_SIZE = 450;
    private static final int TUBE_WIDTH = 170;
    private static final Paint GREEN = MyColors.getTubeColor();

    public Tube(Screen screen, int position, Context context) {
        this.screen = screen;
        this.position = position;
        heightBottomTube = screen.getHeight() - TUBE_SIZE - randomValue();;
        heightTopTube = TUBE_SIZE + randomValue();

        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.tube);
        bottomTube = Bitmap.createScaledBitmap(bp, TUBE_WIDTH, heightBottomTube, false);
        topTube = Bitmap.createScaledBitmap(bp, TUBE_WIDTH, heightTopTube, false);
    }

    public void drawOn(Canvas canvas){
        drawTopTube(canvas);
        drawBottomTube(canvas);
    }

    //É importante o valor da position passar pelo valor de TUBE_WIDTH para somar ao score
    public void move() {
        this.position -= 10;
    }

    private void drawBottomTube(Canvas canvas) {
        canvas.drawBitmap(bottomTube, position, heightBottomTube, null);
    }

    private void drawTopTube(Canvas canvas){
        canvas.drawBitmap(topTube, position, 0, null);

    }

    private int randomValue() {
        return (int) (Math.random() * 300);
    }

    public boolean getOutOfScreen() {
        return position + TUBE_WIDTH < 0;
    }

    public boolean passTroughtTube(){
        return position + TUBE_WIDTH == 200;
    }

    public int getPosition() {
        return position;
    }

    public boolean isHorizontalCollision(Bird bird) {
        return this.position < bird.X + bird.RADIUS;
    }

    public boolean isVerticalCollision(Bird bird) {
        return bird.getHeight() - bird.RADIUS < this.heightTopTube || bird.getHeight() + bird.RADIUS > this.heightBottomTube;
    }
}
