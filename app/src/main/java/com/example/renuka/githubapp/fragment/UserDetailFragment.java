package com.example.renuka.githubapp.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.renuka.githubapp.R;
import com.example.renuka.githubapp.adapter.DetailsAdapter;
import com.example.renuka.githubapp.network.Constants;
import com.example.renuka.githubapp.network.NetworkManager;
import com.example.renuka.githubapp.network.VolleySingleton;
import com.example.renuka.githubapp.pojo.RepoDetails;
import com.example.renuka.githubapp.pojo.UserDetails;

import java.util.ArrayList;


public class UserDetailFragment extends Fragment implements DetailsAdapter.OnCardViewClickListener {

    private String TAG = UserDetailFragment.class.getSimpleName();
    private String mName;
    private String mServerUrl = "https://api.github.com/users/";
    private RecyclerView mRecyclerView;
    private NetworkImageView mAavatar;
    private TextView mUserName;
    private TextView mId;
    private TextView mLocation;
    private TextView mUpdated;
    private TextView mEmail;
    private TextView mCompany;
    private UserDetails userDetails;
    private RepoDetails repoDetails;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    private DetailsAdapter detailsAdapter;
    private NetworkManager networkManager;
    private ImageLoader mImageLoader;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case Constants.USER_DETAIL_FAILURE:
                    break;
                case Constants.USER_DETAIL_SUCCESS:
                    userDetails = (UserDetails) msg.obj;
                    setData();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_detail, container, false);
        Log.d(TAG, "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        initializeView(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        networkManager = new NetworkManager(getActivity());
        //   mName = getIntent().getStringExtra("name");
        networkManager.setUserDetails(mServerUrl + "petrhosek", mHandler);
        Log.d(TAG, "onActivityCreated");
    }

    public void initializeView(View view) {
        Log.d(TAG, "initializeView");
        mAavatar = (NetworkImageView) view.findViewById(R.id.avatar);
        mUserName = (TextView) view.findViewById(R.id.name);
        mId = (TextView) view.findViewById(R.id.user_id);
        mLocation = (TextView) view.findViewById(R.id.location);
        mUpdated = (TextView) view.findViewById(R.id.created);
        mEmail = (TextView) view.findViewById(R.id.email);
        mCompany = (TextView) view.findViewById(R.id.company);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.details_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();
    }

    public void setData() {
        Log.d(TAG, "setData");
        mUserName.setText(userDetails.getName());
        mId.setText(userDetails.getLogin());
        mLocation.setText(userDetails.getLocation());
        mUpdated.setText("Joined on " + userDetails.getCreatedAt());
        mEmail.setText(userDetails.getEmail());
        mCompany.setText("Works at " + userDetails.getCompany());
        mImageLoader = VolleySingleton.getInstance().getmImageLoader();
        mImageLoader.get(userDetails.getAvatarUrl(), ImageLoader.getImageListener(mAavatar, android.R.drawable.alert_light_frame, android.R.drawable.alert_dark_frame));
        mAavatar.setImageUrl(userDetails.getAvatarUrl(), mImageLoader);
        list1.add(userDetails.getNoOfFollowers());
        list1.add(userDetails.getNoOfFollowing());
        list1.add(userDetails.getPublicRepos());
        list2.add(userDetails.getFollowersUrl());
        list2.add(userDetails.getFollowingUrl());
        //  setRepoData(userDetails.getReposUrl());
        list2.add(userDetails.getReposUrl());
        detailsAdapter = new DetailsAdapter(list1, list2);
        detailsAdapter.setOnCardViewClickListener(this);
        mRecyclerView.setAdapter(detailsAdapter);

    }

    @Override
    public void onCardViewClick(View view, int position) {
        Log.d(TAG, "onCardViewClick");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main, new RepoDetailsFragment())
                .addToBackStack(null).commit();
    }
}
