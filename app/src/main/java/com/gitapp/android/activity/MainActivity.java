package com.gitapp.android.activity;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.gitapp.android.R;

import com.gitapp.android.fragment.LoginDialogFragment;

public class MainActivity extends AppCompatActivity implements LoginDialogFragment.HandleDialog {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button signUp = (Button) findViewById(R.id.sign_up);
        final FragmentManager fragmentManager = getFragmentManager();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDialogFragment loginDialogFragment = new LoginDialogFragment();
                loginDialogFragment.setStyle(DialogFragment.STYLE_NO_FRAME, 0);
                loginDialogFragment.show(fragmentManager, "Login");

            }
        });
    }

    @Override
    public void onDoneButtonClick(String name) {
        Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
