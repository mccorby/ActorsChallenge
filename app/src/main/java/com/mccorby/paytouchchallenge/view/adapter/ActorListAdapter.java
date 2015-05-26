package com.mccorby.paytouchchallenge.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.presentation.model.PresentationActor;

import java.util.List;

/**
 * Created by JAC on 26/05/2015.
 */
public class ActorListAdapter extends RecyclerView.Adapter<ActorListAdapter.ViewHolder>{

    private List<PresentationActor> mActorList;
    private OnActorListItemAction mListener;

    public interface OnActorListItemAction {
        void onActorSelected(PresentationActor actor);
    }

    public ActorListAdapter(List<PresentationActor> actors, OnActorListItemAction listener) {
        this.mActorList = actors;
        this.mListener = listener;
    }

    public void setActorList(List<PresentationActor> actors) {
        this.mActorList = actors;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actor_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        PresentationActor actor = mActorList.get(i);
        viewHolder.mPopularityTv.setText(String.format("%.2f", actor.getPopularity()));
        viewHolder.mDescriptionTv.setText(actor.getDescription());
        viewHolder.mLocationTv.setText(actor.getLocation());
        viewHolder.mNameTv.setText(actor.getName());
    }

    @Override
    public int getItemCount() {
        return mActorList != null ? mActorList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mNameTv;
        TextView mLocationTv;
        TextView mDescriptionTv;
        TextView mPopularityTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.item_actor_list_image);
            mNameTv = (TextView) itemView.findViewById(R.id.item_actor_list_name_tv);
            mLocationTv = (TextView) itemView.findViewById(R.id.item_actor_list_location_tv);
            mDescriptionTv = (TextView) itemView.findViewById(R.id.item_actor_list_description_tv);
            mPopularityTv = (TextView) itemView.findViewById(R.id.item_actor_list_popularity_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onActorSelected(mActorList.get(getAdapterPosition()));
                }
            });
        }
    }

}
