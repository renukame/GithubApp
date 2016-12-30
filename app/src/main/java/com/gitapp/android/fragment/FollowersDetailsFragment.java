package com.gitapp.android.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gitapp.android.R;
import com.gitapp.android.adapter.FollowersAdapter;
import com.gitapp.android.network.NetworkManager;
import com.gitapp.android.pojo.FollowersDetails;

import java.util.ArrayList;


public class FollowersDetailsFragment extends Fragment {

    private String TAG = FollowersDetailsFragment.class.getSimpleName();
    private String mName;
    private RecyclerView mRecyclerView;
    private NetworkManager mNetworkManager;
    private String url ="https://api.github.com/users/";
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setData((ArrayList<FollowersDetails>) msg.obj);
        }
    };
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        mName = getArguments().getString("user_name");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.followList);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mNetworkManager = new NetworkManager(getActivity());
        mNetworkManager.setFollowersData(url+mName+"/followers", mHandler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void setData(ArrayList<FollowersDetails> list) {
        FollowersAdapter followersAdapter = new FollowersAdapter(list);
        mRecyclerView.setAdapter(followersAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

