package com.gitapp.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gitapp.android.R;

import com.gitapp.android.pojo.RepoDetails;

import java.util.ArrayList;


public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {
    ArrayList<RepoDetails> repoDetailsList;

    public RepoAdapter(ArrayList<RepoDetails> list) {
        repoDetailsList = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView repoName;
        TextView createdAt;
        TextView language;
        TextView description;
        TextView updatedAt;

        public ViewHolder(View itemView) {
            super(itemView);
            repoName = (TextView) itemView.findViewById(R.id.reponame);
            createdAt = (TextView) itemView.findViewById(R.id.createdAt);
            language = (TextView) itemView.findViewById(R.id.language);
            description = (TextView) itemView.findViewById(R.id.description);
            updatedAt = (TextView) itemView.findViewById(R.id.updatedAt);
        }
    }

    @Override
    public RepoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_repo_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RepoAdapter.ViewHolder holder, int position) {
        holder.repoName.setText(repoDetailsList.get(position).getRepoName());
        holder.createdAt.setText(repoDetailsList.get(position).getCreatedAt());
        holder.updatedAt.setText(repoDetailsList.get(position).getUpdatedAt());
        holder.language.setText(repoDetailsList.get(position).getLanguage());
        holder.description.setText(repoDetailsList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return repoDetailsList.size();
    }
}
