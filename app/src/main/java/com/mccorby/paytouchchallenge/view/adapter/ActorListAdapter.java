package com.mccorby.paytouchchallenge.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.presentation.model.PresentationActor;
import com.mccorby.paytouchchallenge.view.transformation.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by JAC on 26/05/2015.
 */
public class ActorListAdapter extends RecyclerView.Adapter<ActorListAdapter.ViewHolder>{

    private List<PresentationActor> mActorList;
    private OnActorListItemAction mListener;
    private Context mContext;

    public interface OnActorListItemAction {
        void onActorSelected(PresentationActor actor);
    }

    public ActorListAdapter(Context context, List<PresentationActor> actors, OnActorListItemAction listener) {
        this.mContext = context;
        this.mActorList = actors;
        this.mListener = listener;
    }

    public void setActorList(List<PresentationActor> actors) {
        this.mActorList = actors;
    }

    public List<PresentationActor> getActorList() {
        return mActorList;
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
        if (!TextUtils.isEmpty(actor.getProfileImageUrl())) {
            Picasso.with(mContext)
                    .load(actor.getProfileImageUrl())
                    .transform(new CircleTransform())
                    .into(viewHolder.mImageView);
        }
        int textColor;
        if ((i & 1 ) == 0) {
            // Even rows
            textColor  = mContext.getResources().getColor(android.R.color.primary_text_dark);
            viewHolder.mWrapper.setCardBackgroundColor(mContext.getResources().getColor(R.color.even_row_bg));
            viewHolder.mLocationTv
                    .setCompoundDrawablesWithIntrinsicBounds(
                            R.mipmap.pin_white, 0, 0, 0);

        } else {
            // Odd rows
            textColor = mContext.getResources().getColor(android.R.color.primary_text_light);
            viewHolder.mWrapper.setCardBackgroundColor(mContext.getResources().getColor(R.color.odd_row_bg));
            viewHolder.mLocationTv
                    .setCompoundDrawablesWithIntrinsicBounds(
                            R.mipmap.pin_black, 0, 0, 0);

        }
        viewHolder.mDescriptionTv.setTextColor(textColor);
        viewHolder.mNameTv.setTextColor(textColor);
        viewHolder.mPopularityTv.setTextColor(textColor);
        viewHolder.mLocationTv.setTextColor(textColor);
    }

    @Override
    public int getItemCount() {
        return mActorList != null ? mActorList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView mWrapper;
        ImageView mImageView;
        TextView mNameTv;
        TextView mLocationTv;
        TextView mDescriptionTv;
        TextView mPopularityTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mWrapper = (CardView) itemView.findViewById(R.id.card_view);
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
