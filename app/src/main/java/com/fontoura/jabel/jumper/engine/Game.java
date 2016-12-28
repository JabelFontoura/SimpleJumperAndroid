package com.fontoura.jabel.jumper.engine;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build.VERSION_CODES;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

import com.fontoura.jabel.jumper.R;
import com.fontoura.jabel.jumper.elements.Bird;
import com.fontoura.jabel.jumper.elements.Score;
import com.fontoura.jabel.jumper.elements.Tubes;
import com.fontoura.jabel.jumper.graphic.Screen;

/**
 * Created by Jabel on 12/26/2016.
 */

public class Game extends SurfaceView implements Runnable, OnTouchListener{

    private Sound sound;
    private Screen screen;
    private Context context;
    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Bird bird;
    private Bitmap back;
    private Bitmap backgroung;
    private Tubes tubes;
    private Score score;


    @TargetApi(VERSION_CODES.LOLLIPOP)
    public Game(Context context) {
        super(context);
        this.context = context;

        screen = new Screen(context);
        sound =  new Sound(context);

        initElements();
        setOnTouchListener(this);
    }

    private void initElements() {
        bird = new Bird(screen, context, sound);
        score = new Score();
        tubes = new Tubes(screen, score, context, sound);

        back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        backgroung = Bitmap.createScaledBitmap(back, back.getWidth(), screen.getHeight(), false);
    }

    @Override
    public void run() {
        while (isRunning){
            if(!holder.getSurface().isValid()) continue;

            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(backgroung, 0, 0, null);

            bird.drawOn(canvas);
            bird.fall();

            tubes.drawOn(canvas);
            tubes.move();

            score.drawOn(canvas);

            if(new CheckCollision(bird, tubes).isCollision()){
                score.drawOnGameOver(canvas);
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void init() {
        isRunning = true;
    }

    public void pause() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        bird.jump();
        return false;
    }
}
