package com.example.renuka.githubapp.network;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleySingleton extends Application {

    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mImageLoader = new ImageLoader(getRequestQueue(), new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap>
                    cache = new LruCache<String, Bitmap>(20);
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });

    }

    public ImageLoader getmImageLoader(){
        return mImageLoader;
    }

    public synchronized static VolleySingleton getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        return mRequestQueue;
    }

    public void addRequest(Request request) {
        RequestQueue requestQueue = getRequestQueue();
        requestQueue.add(request);
    }

}
