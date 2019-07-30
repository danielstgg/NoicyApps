package com.Noicy.NoicyApp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.Noicy.NoicyApp.model.ItemTshirtModel;
import com.Noicy.NoicyApp.R;
import com.Noicy.NoicyApp.view.tshirt.DetailTshirt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class TshirtAdapter extends RecyclerView.Adapter<TshirtAdapter.MyHolder> {

    List<ItemTshirtModel> mList;
    Context ctx;

    public TshirtAdapter(Context ctx,List<ItemTshirtModel> mList) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item_f,viewGroup, false);
        final MyHolder holder = new MyHolder(layout);

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ctx, DetailTshirt.class);

                i.putExtra("nama_produk",mList.get(holder.getAdapterPosition()).getNama_produk());
                i.putExtra("harga_produk",mList.get(holder.getAdapterPosition()).getHarga_produk());
//                i.putExtra("stok_produk",mList.get(holder.getAdapterPosition()).getStok_produk());
//                i.putExtra("berat_produk",mList.get(holder.getAdapterPosition()).getBerat_produk());
//                i.putExtra("deskripsi_produk",mList.get(holder.getAdapterPosition()).getDeskripsi_produk());
                i.putExtra("gambar_produk",mList.get(holder.getAdapterPosition()).getFoto_produk());

                ctx.startActivity(i);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        ItemTshirtModel tshirtList = mList.get(i);
        myHolder.nama_produk.setText(tshirtList.getNama_produk());

        myHolder.harga_produk.setText(tshirtList.getHarga_produk());

//        myHolder.stok_produk.setText(tshirtList.getStok_produk());

//        myHolder.berat_produk.setText(tshirtList.getBerat_produk());
//
//        myHolder.deskripsi_produk.setText(tshirtList.getDeskripsi_produk());

        Glide.with(ctx).load(tshirtList.getFoto_produk()).apply(new RequestOptions().override(350,550)).into(myHolder.gambar_produk);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }




    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nama_produk, harga_produk;
        ImageView gambar_produk;
        Button btnDetail;
        public MyHolder(View v)
        {
            super(v);

            nama_produk  = (TextView) v.findViewById(R.id.nameTshirtGambar);

            harga_produk = (TextView) v.findViewById(R.id.hargaTshirt);

//            stok_produk = (TextView) v.findViewById(R.id.stokTshirt);

//            deskripsi_produk = (TextView) v.findViewById(R.id.deskripsi_baju);
//
//            berat_produk = (TextView) v.findViewById(R.id.berat_baju);

            gambar_produk = (ImageView) v.findViewById(R.id.tshirtGambar);

            btnDetail = (Button) v.findViewById(R.id.btn_detail);


        }

    }
}
