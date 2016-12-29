package com.example.renuka.githubapp.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.renuka.githubapp.pojo.FollowersFollowingDetails;
import com.example.renuka.githubapp.pojo.RepoDetails;
import com.example.renuka.githubapp.pojo.UserDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class NetworkManager {
    private VolleySingleton instance;
    private VolleyErrorHelper errorHelper;
    private Context context;
    private UserDetails userDetails;
    private RepoDetails repoDetails;
    private FollowersFollowingDetails followersFollowingDetails;

    public NetworkManager(Context context) {
        instance = VolleySingleton.getInstance();
        errorHelper = new VolleyErrorHelper();
        this.context = context;

    }

    public void setUserDetails(String serverUrl, final Handler handler) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(serverUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    userDetails = new UserDetails(response.getString("login"),
                            response.getString("avatar_url"),
                            response.getString("followers_url"),
                            response.getString("following_url"),
                            response.getString("repos_url"),
                            response.getString("name"),
                            response.getString("company"),
                            response.getString("location"),
                            response.getString("email"),
                            response.getString("followers"),
                            response.getString("following"),
                            response.getString("created_at"),
                            response.getString("updated_at"),
                            response.getString("bio"),
                            response.getString("public_repos"));


                    Message message = handler.obtainMessage();
                    message.arg1 = Constants.USER_DETAIL_SUCCESS;
                    message.obj = userDetails;
                    handler.sendMessage(message);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = errorHelper.getMessage(error, context);
                Message message = handler.obtainMessage();
                message.arg1 = Constants.USER_DETAIL_FAILURE;
                Bundle bundle = new Bundle();
                bundle.putString("errorMessage", errorMessage);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });
        instance.addRequest(jsonObjectRequest);
    }

    public void setRepoDetails(String serverUrl, final Handler handler) {
        final ArrayList<RepoDetails> list = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(serverUrl, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = response.getJSONObject(i);
                        RepoDetails repoDetails = new RepoDetails(jsonObject.getString("name"),jsonObject.getString("description")
                        ,jsonObject.getString("created_at"),jsonObject.getString("language"),jsonObject.getString("updated_at"));
                        list.add(repoDetails);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Message message = new Message();
                message.arg1 = Constants.REPO_DETAIL_SUCCESS;
                message.obj = list;
                handler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        instance.addRequest(jsonArrayRequest);

    }

    public void setFollowingFollwersData(String serverUrl,Handler handler) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(serverUrl, new Response.Listener<JSONArray>() {
            ArrayList<String> login = new ArrayList<>();
            ArrayList<String> url = new ArrayList<>();
            ArrayList<String> location = new ArrayList<>();
            ArrayList<String> bio = new ArrayList<>();
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = response.getJSONObject(i);
                        login.add(jsonObject.getString("name"));
                        url.add(jsonObject.getString("description"));
                       // setFollowersFollowingInnerData();
                        location.add(jsonObject.getString("created_at"));
                        bio.add(jsonObject.getString("language"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

              //  followersFollowingDetails = new FollowersFollowingDetails()
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        instance.addRequest(jsonArrayRequest);

    }

    public void setFollowersFollowingInnerData(String serverUrl,Handler handler) {

    }
}
