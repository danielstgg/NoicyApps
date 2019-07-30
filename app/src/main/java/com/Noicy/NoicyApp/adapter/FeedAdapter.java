package com.Noicy.NoicyApp.adapter;



import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Noicy.NoicyApp.model.FeedModel;
import com.Noicy.NoicyApp.R;

import java.util.ArrayList;


public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.DailyViewHolder> {

    private ArrayList<FeedModel> mFeedModel;
    public static class DailyViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView namaGambar;

        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.dailyGambar);
            namaGambar = itemView.findViewById(R.id.namaDailyGambar);
        }
    }

    public FeedAdapter(ArrayList<FeedModel> dailyList){

        mFeedModel = dailyList;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item_d,viewGroup,false);
        DailyViewHolder Da = new DailyViewHolder(v);
        return Da;
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder dailyViewHolder, int position) {
        FeedModel currentItem = mFeedModel.get(position);
        dailyViewHolder.mImageView.setImageResource(currentItem.getmImageResource());
        dailyViewHolder.namaGambar.setText(currentItem.getNamaGambar());
    }

    @Override
    public int getItemCount() {

        return mFeedModel.size();
    }



}
