package com.gitapp.android.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gitapp.android.R;


public class LoginDialogFragment extends DialogFragment {

    EditText userName;
    Button done;
    String name;
    private HandleDialog handleDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userName = (EditText) view.findViewById(R.id.user);
        done = (Button) view.findViewById(R.id.done);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        handleDialog = (HandleDialog) getActivity();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = userName.getText().toString();
                handleDialog.onDoneButtonClick(name,view);
                // getDialog().dismiss();
            }
        });
    }


    public interface HandleDialog {
        void onDoneButtonClick(String name,View view);
    }

}

