package ru.production.ssobolevsky.multithreadingtest;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment{

    private TextView mTextView;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_second);
    }

    @Override
    public void onResume() {
        super.onResume();
        IntegerDownloadTask task = new IntegerDownloadTask();
        try {
            mTextView.setText(String.valueOf(task.execute().get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static final SecondFragment newInstannce() {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    public class IntegerDownloadTask extends AsyncTask<Void, Void, Integer> {
        @Override
        protected Integer doInBackground(Void... voids) {
            try {
                Thread.sleep(Utils.DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer result = (int) (Math.random() * Utils.MAX_RANDOM);
            return result;
        }
    }

}
