package com.example.renuka.githubapp.network;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;


public class VolleyErrorHelper {

    public String getMessage(Object error, Context context) {
        String message = "";
        if (error instanceof TimeoutError) {
            message = "TimeoutError";
        } else if (error instanceof ServerError) {
            message = "ServerError";
        } else if (error instanceof NetworkError) {
            message = "NetworkError";
        } else if (error instanceof ParseError) {
            message = "ParseError";
        } else if (error instanceof NoConnectionError) {
            message = "NoConnectionError";
        } else if (error instanceof AuthFailureError) {
            message = "AuthFailureError";
        }

        return message;
    }
}
