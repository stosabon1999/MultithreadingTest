package ru.production.ssobolevsky.multithreadingtest;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl_first, FirstFragment.newInstance())
                .add(R.id.fl_second, SecondFragment.newInstannce())
                .add(R.id.fl_third, ThirdFragment.newInstance())
                .commit();
    }
}
