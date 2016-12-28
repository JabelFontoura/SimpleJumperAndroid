package com.fontoura.jabel.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;

import com.fontoura.jabel.jumper.engine.Sound;
import com.fontoura.jabel.jumper.graphic.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Jabel on 12/27/2016.
 */

public class Tubes {

    public static final int DISTANCE_BETWEEN_TUBES = 400;
    public static final int AMOUNT_OF_TUBES = 5;
    private final List<Tube> tubes = new ArrayList<Tube>();
    private Screen screen;
    private Score score;
    private Context context;
    private Sound sound;

    public Tubes(Screen screen, Score score, Context context, Sound sound) {
        this.screen = screen;
        this.score = score;
        this.context = context;
        this.sound = sound;
        int position = 400;

        for(int i = 0; i < AMOUNT_OF_TUBES; i++){
            position += DISTANCE_BETWEEN_TUBES;
            Tube tube = new Tube(screen, position, context);
            tubes.add(tube);
        }
    }

    public void drawOn(Canvas canvas) {
        for (Tube tube : tubes) {
            tube.drawOn(canvas);
        }
    }

    public void move(){
        ListIterator<Tube> iterator = tubes.listIterator();
        while(iterator.hasNext()) {
            Tube tube = iterator.next();
            tube.move();

            if (tube.getOutOfScreen()) {
                iterator.remove();
                Tube newTube = new Tube(screen, getMax() + DISTANCE_BETWEEN_TUBES, context);
                iterator.add(newTube);
            }

            if(tube.passTroughtTube()){
                score.add();
                sound.play(Sound.SCORE);
            }
        }
    }

    private int getMax() {
        int max = 0;

        for(Tube tube : tubes) max = Math.max(tube.getPosition(), max);

        return max;
    }

    public boolean isCollision(Bird bird) {
        for(Tube tube : tubes){
            if(tube.isHorizontalCollision(bird) && tube.isVerticalCollision(bird)){
                sound.play(Sound.COLLISION);
                return true;
            }
        }
        return false;
    }
}
