package com.Noicy.NoicyApp.view.tshirt;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Noicy.NoicyApp.API.APITshirtEndPoint;
import com.Noicy.NoicyApp.API.APITshirtService;
import com.Noicy.NoicyApp.R;
import com.Noicy.NoicyApp.adapter.TshirtAdapter;
import com.Noicy.NoicyApp.model.ItemTshirtModel;
import com.Noicy.NoicyApp.model.TshirtModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TshirtFragment extends Fragment {
    private TshirtAdapter viewAdapter;
    private List<ItemTshirtModel> mItems = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View myFragment = inflater.inflate(R.layout.fragment_tshirt,container,false);
        final RecyclerView recyclerView = myFragment.findViewById(R.id.feed_id_r);
        viewAdapter = new TshirtAdapter(getContext(), mItems);
        mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
        APITshirtService api = APITshirtEndPoint.getClient().create(APITshirtService.class);
        Call<TshirtModel> call = api.getNoicyTsirt();
        call.enqueue(new Callback<TshirtModel>() {
            @Override
            public void onResponse(Call<TshirtModel> call, Response<TshirtModel> response) {
                mItems = response.body().getItem();
                viewAdapter = new TshirtAdapter(getContext(), mItems);
                recyclerView.setAdapter(viewAdapter);
            }

            @Override
            public void onFailure(Call<TshirtModel> call, Throwable t) {
                Toast.makeText(getContext(), "Tidak Ada Koneksi ! ", Toast.LENGTH_SHORT).show();

            }
        });


        return myFragment;

    }


}


