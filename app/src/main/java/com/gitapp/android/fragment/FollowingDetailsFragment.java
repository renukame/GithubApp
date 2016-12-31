package com.gitapp.android.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
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
import com.gitapp.android.adapter.FollowingAdapter;
import com.gitapp.android.helper.Helper;
import com.gitapp.android.network.Constants;
import com.gitapp.android.network.NetworkManager;
import com.gitapp.android.pojo.FollowingDetails;

import java.util.ArrayList;

/**
 * Created by Renuka on 30-12-2016.
 */

public class FollowingDetailsFragment extends Fragment {

    private String TAG = FollowingDetailsFragment.class.getSimpleName();
    private String mName;
    private RecyclerView mRecyclerView;
    private NetworkManager mNetworkManager;
    private String url ="https://api.github.com/users/";
    private ProgressDialog mProgressDialog;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case Constants.FOLLOWING_DETAIL_FAILURE:
                    break;
                case Constants.FOLLOWING_DETAIL_SUCCESS:
                    Helper.cancelDialog(mProgressDialog);
                    setData((ArrayList<FollowingDetails>) msg.obj);
                    break;
                default:
                    break;
            }
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
        mProgressDialog = new ProgressDialog(getActivity());
        Helper.showLoadingDialog(mProgressDialog,"Loading...");
        mNetworkManager = new NetworkManager(getActivity());
        mNetworkManager.setFollowingData(url+mName+"/following", mHandler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void setData(ArrayList<FollowingDetails> list) {
        FollowingAdapter followingAdapter = new FollowingAdapter(list);
        mRecyclerView.setAdapter(followingAdapter);
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

