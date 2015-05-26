package com.mccorby.paytouchchallenge.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.presentation.model.PresentationWork;

import java.util.List;

/**
 * Created by JAC on 26/05/2015.
 */
public class WorkListAdapter extends RecyclerView.Adapter<WorkListAdapter.ViewHolder> {

    private final Context mContext;
    private final List<PresentationWork> mWorkList;

    public WorkListAdapter(Context context, List<PresentationWork> workList) {
        this.mContext = context;
        this.mWorkList = workList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        PresentationWork work = mWorkList.get(i);

        viewHolder.mTitle.setText(work.getTitle());
        viewHolder.mReleaseDate.setText(String.format("%d", work.getReleaseDate()));
        viewHolder.mPopularity.setText(String.format("%.2f", work.getPopularity()));
        viewHolder.mVotes.setText("" + work.getVoteCount());
    }

    @Override
    public int getItemCount() {
        return mWorkList != null ? mWorkList.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTitle;
        TextView mReleaseDate;
        TextView mPopularity;
        TextView mVotes;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.item_work_image);
            mTitle = (TextView) itemView.findViewById(R.id.item_work_title_tv);
            mReleaseDate = (TextView) itemView.findViewById(R.id.item_work_release_date_tv);
            mPopularity = (TextView) itemView.findViewById(R.id.item_work_popularity_tv);
            mVotes = (TextView) itemView.findViewById(R.id.item_work_votes_tv);
        }
    }
}
