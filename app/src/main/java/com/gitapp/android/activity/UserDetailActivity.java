package com.gitapp.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.gitapp.android.R;

import com.gitapp.android.fragment.UserDetailFragment;

public class UserDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_deatils);
        getFragmentManager().beginTransaction().add(R.id.main, new UserDetailFragment()).addToBackStack(null).commit();
    }

}
