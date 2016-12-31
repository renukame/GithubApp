package com.gitapp.android.helper;

import android.app.ProgressDialog;

/**
 * Created by Renuka on 31-12-2016.
 */

public class Helper {

    public static void showLoadingDialog(ProgressDialog progressDialog,String message) {
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public static void cancelDialog(ProgressDialog progressDialog){
        if(progressDialog != null){
            progressDialog.cancel();
        }
    }

}
