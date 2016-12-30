package com.gitapp.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.gitapp.android.R;
import com.gitapp.android.network.VolleySingleton;
import com.gitapp.android.pojo.FollowingDetails;

import java.util.ArrayList;

/**
 * Created by Renuka on 30-12-2016.
 */

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.ViewHolder> {

    private ArrayList<FollowingDetails> followingList;
    private ImageLoader imageLoader;
    public FollowingAdapter(ArrayList<FollowingDetails> list){
        this.followingList = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_follow,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        imageLoader = VolleySingleton.getInstance().getmImageLoader();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(followingList.get(position).getName());
        holder.location.setText(followingList.get(position).getLocation());
        holder.login.setText(followingList.get(position).getLogin());
        holder.bio.setText(followingList.get(position).getBio());
        imageLoader.get(followingList.get(position).getAvatar(), ImageLoader.getImageListener(holder.avatar, android.R.drawable.alert_light_frame, android.R.drawable.alert_dark_frame));
        holder.avatar.setImageUrl(followingList.get(position).getAvatar(), imageLoader);
    }

    @Override
    public int getItemCount() {
        return followingList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        NetworkImageView avatar;
        TextView name;
        TextView login;
        TextView location;
        TextView bio;
        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (NetworkImageView) itemView.findViewById(R.id.avatar);
            name = (TextView) itemView.findViewById(R.id.name);
            login = (TextView) itemView.findViewById(R.id.login);
            location = (TextView) itemView.findViewById(R.id.location);
            bio = (TextView) itemView.findViewById(R.id.bio);
        }
    }
}
