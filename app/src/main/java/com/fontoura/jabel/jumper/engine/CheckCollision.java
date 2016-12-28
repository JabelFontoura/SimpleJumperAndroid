package com.fontoura.jabel.jumper.engine;

import com.fontoura.jabel.jumper.elements.Bird;
import com.fontoura.jabel.jumper.elements.Tubes;

/**
 * Created by Jabel on 12/27/2016.
 */
public class CheckCollision {

    private Bird bird;
    private Tubes tubes;

    public CheckCollision(Bird bird, Tubes tubes) {
        this.bird = bird;
        this.tubes = tubes;
    }

    public boolean isCollision() {
        return tubes.isCollision(bird);
    }
}
