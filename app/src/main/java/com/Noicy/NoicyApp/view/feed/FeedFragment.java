package com.Noicy.NoicyApp.view.feed;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.Noicy.NoicyApp.model.FeedModel;
import com.Noicy.NoicyApp.R;
import com.Noicy.NoicyApp.adapter.FeedAdapter;


import java.util.ArrayList;

public class FeedFragment extends Fragment {

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View myFragmentView = inflater.inflate(R.layout.fragment_feed, container, false);

        ArrayList<FeedModel> feedModels = new ArrayList<>();
        feedModels.add(new FeedModel(R.drawable.ic_event, "03 Mei 2019      - Pameran Di UNSIL "));
        feedModels.add(new FeedModel(R.drawable.ic_event, "27 Juli 2019     - Buka Stand Di Taman Kota Banjar"));
        feedModels.add(new FeedModel(R.drawable.ic_event, "17 Agustus 2019  - Buka Stand Di Alun-Alun Kota Bandung"));


        mRecycleView = myFragmentView.findViewById(R.id.daily_id_r);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new FeedAdapter(feedModels);

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);

        return myFragmentView;
    }
}
