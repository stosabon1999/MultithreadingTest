package ru.production.ssobolevsky.multithreadingtest;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.util.Log;

/**
 * Created by pro on 26.06.2018.
 */

public class MyLoaderThree extends AsyncTaskLoader<String> {

    public MyLoaderThree(Context context) {
        super(context);
    }

    @Override
    public String loadInBackground() {
        try {
            Thread.sleep(Utils.DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf((int) (Math.random() * Utils.MAX_RANDOM));
    }
}
