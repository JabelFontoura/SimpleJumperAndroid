package com.fontoura.jabel.jumper.engine;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;

import com.fontoura.jabel.jumper.R;

/**
 * Created by Jabel on 12/27/2016.
 */

public class Sound {

    private AudioAttributes aa;
    private SoundPool sp;
    private Context context;
    public static int JUMP;
    public static int COLLISION;
    public static int SCORE;

    @RequiresApi(api = VERSION_CODES.LOLLIPOP)
    public Sound(Context context) {
        this.context = context;

        if(VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
            aa = new Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).setUsage(AudioAttributes.USAGE_GAME).build();

            sp = new SoundPool.Builder().setMaxStreams(3).setAudioAttributes(aa).build();
        }else{
            sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 1);
        }

        JUMP = sp.load(context, R.raw.jump, 1);
        COLLISION = sp.load(context, R.raw.collision, 1);
        SCORE = sp.load(context, R.raw.score, 1);
    }

    public void play(int sound){
        sp.play(sound, 1, 1, 1, 0, 1);
    }
}
