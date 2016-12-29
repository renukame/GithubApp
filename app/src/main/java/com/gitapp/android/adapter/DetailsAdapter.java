package com.gitapp.android.adapter;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.com.gitapp.android.R;

import java.util.ArrayList;


public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    public ArrayList<String> list1;
    public ArrayList<String> list2;
    public OnCardViewClickListener mOnCardViewClickListener;

    public DetailsAdapter(ArrayList<String> list1, ArrayList<String> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public void setOnCardViewClickListener(Fragment fragment) {
        this.mOnCardViewClickListener = (OnCardViewClickListener) fragment;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView count;
        public TextView description;

        public ViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            count = (TextView) itemView.findViewById(R.id.count);
            description = (TextView) itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnCardViewClickListener.onCardViewClick(view, getLayoutPosition());

                }
            });
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_user_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0) {
            holder.name.setText("Followers");
        } else if (position == 1) {
            holder.name.setText("Following");
        } else {
            holder.name.setText("Repo");
        }
        holder.count.setText(list1.get(position));
        holder.description.setText(list2.get(position));

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public interface OnCardViewClickListener {
        void onCardViewClick(View view, int position);
    }
}
