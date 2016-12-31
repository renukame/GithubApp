package com.gitapp.android.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.gitapp.android.R;
import com.gitapp.android.fragment.FollowersDetailsFragment;
import com.gitapp.android.fragment.FollowingDetailsFragment;
import com.gitapp.android.fragment.RepoDetailsFragment;
import com.gitapp.android.fragment.UserDetailFragment;

public class UserDetailActivity extends AppCompatActivity implements UserDetailFragment.HandleListClick {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle bundle;
    Transition changeTransform;
    Transition explodeTransform;
    UserDetailFragment userDetailFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_deatils);
        changeTransform = TransitionInflater.from(this).
                inflateTransition(R.transition.transition_fragment);
        explodeTransform = TransitionInflater.from(this).
                inflateTransition(android.R.transition.explode);
        String name = getIntent().getStringExtra("name");
        bundle = new Bundle();
        bundle.putString("user_name", name);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        userDetailFragment = new UserDetailFragment();
        userDetailFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.main, userDetailFragment).commit();
    }

    @Override
    public void onHandleListClick(View view, int position) {

        if (position == 0) {
            FollowersDetailsFragment followersFragment = new FollowersDetailsFragment();
            followersFragment.setArguments(bundle);
            followersFragment.setSharedElementEnterTransition(changeTransform);
            followersFragment.setEnterTransition(explodeTransform);
            userDetailFragment.setExitTransition(explodeTransform);
            getFragmentManager().beginTransaction().replace(R.id.main, followersFragment)
                    .addSharedElement(view,"transition2").addToBackStack(null).commit();
        }
        if (position == 1) {
            FollowingDetailsFragment followingFragment = new FollowingDetailsFragment();
            followingFragment.setArguments(bundle);
            followingFragment.setSharedElementEnterTransition(changeTransform);
            followingFragment.setEnterTransition(explodeTransform);
            userDetailFragment.setExitTransition(explodeTransform);
            followingFragment.setSharedElementReturnTransition(changeTransform);
            getFragmentManager().beginTransaction().replace(R.id.main, followingFragment)
                    .addSharedElement(view,"transition2").addToBackStack(null).commit();
        }
        if (position == 2) {
            RepoDetailsFragment repoDetailsFragment = new RepoDetailsFragment();
            repoDetailsFragment.setArguments(bundle);
            repoDetailsFragment.setSharedElementEnterTransition(changeTransform);
            repoDetailsFragment.setEnterTransition(explodeTransform);
            userDetailFragment.setExitTransition(explodeTransform);
            getFragmentManager().beginTransaction().replace(R.id.main, repoDetailsFragment)
                    .addSharedElement(view,"transition2").addToBackStack(null).commit();
        }
    }
}
