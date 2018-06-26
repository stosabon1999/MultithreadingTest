package ru.production.ssobolevsky.multithreadingtest;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment implements LoaderManager.LoaderCallbacks<String> {

    public static final int LOADER_ID = 100001;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private LinearLayoutManager mManager;
    private Loader<String> mLoader;
    private List<String> mData;
    private Handler mHandler;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.rv_third);
        mHandler = new UIHandler();
        mManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mLoader = getActivity().getSupportLoaderManager().initLoader(LOADER_ID, null, this);
        mLoader.forceLoad();
    }

    public static final ThirdFragment newInstance() {
        ThirdFragment fragment = new ThirdFragment();
        return fragment;
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        Loader<String> mLoader = null;
        if (id == LOADER_ID) {
            mLoader = new MyLoaderThree(getActivity());
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        Message msg = new Message();
        msg.what = Utils.MSG_UPDATE;
        msg.obj = data;
        getHandler().sendMessage(msg);
        mLoader.forceLoad();
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

    public class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Utils.MSG_UPDATE :
                    mAdapter.updateData(msg.obj.toString());
                    break;
            }
        }
    }

    public Handler getHandler() {
        return mHandler;
    }
}
