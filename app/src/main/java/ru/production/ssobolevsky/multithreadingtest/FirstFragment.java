package ru.production.ssobolevsky.multithreadingtest;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements LoaderManager.LoaderCallbacks<Integer> {

    public static final int LOADER_ID = 10000;

    private TextView mTextView;

    private Loader<Integer> mLoader;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.first_tv);
        mLoader = getActivity().getSupportLoaderManager().initLoader(LOADER_ID, null,this);
        mLoader.forceLoad();
    }

    public static final FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public Loader<Integer> onCreateLoader(int id, Bundle args) {
        Loader<Integer> mLoader = null;
        if (LOADER_ID == id) {
            mLoader = new MyLoader(getActivity());
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<Integer> loader, Integer data) {
        mTextView.setTextColor(data);
        mLoader.forceLoad();
    }

    @Override
    public void onLoaderReset(Loader<Integer> loader) {

    }
}
