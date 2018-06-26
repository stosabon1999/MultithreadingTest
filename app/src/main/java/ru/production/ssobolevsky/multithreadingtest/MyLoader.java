package ru.production.ssobolevsky.multithreadingtest;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Color;

import java.util.Random;

/**
 * Created by pro on 25.06.2018.
 */

public class MyLoader extends android.support.v4.content.AsyncTaskLoader<Integer> {

    public MyLoader(Context context) {
        super(context);
    }

    @Override
    public Integer loadInBackground() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getRandomColor();
    }

    private Integer getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
