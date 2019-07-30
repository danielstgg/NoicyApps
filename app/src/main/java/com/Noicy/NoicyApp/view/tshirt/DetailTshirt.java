package com.Noicy.NoicyApp.view.tshirt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.Noicy.NoicyApp.R;
import com.bumptech.glide.Glide;

public class DetailTshirt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tshirt);

        String nama_produk = getIntent().getExtras().getString("nama_produk");
        String deskripsi_produk = getIntent().getExtras().getString("deskripsi_produk");
        String harga_produk = getIntent().getExtras().getString("harga_produk");
//        String berat_produk = getIntent().getExtras().getString("berat_produk");
        String stok_produk = getIntent().getExtras().getString("stok_produk");
        String gambar_produk = getIntent().getExtras().getString("gambar_produk");

        ImageView gambar_baju = (ImageView)findViewById(R.id.gambarbaju);
        TextView nama_baju = (TextView)findViewById(R.id.nama_baju);
        TextView harga_baju = (TextView)findViewById(R.id.harga_baju);
//        TextView berat_baju = (TextView)findViewById(R.id.berat_baju);
        TextView stok_baju = (TextView)findViewById(R.id.stok_baju);
        TextView deskripsi_baju = (TextView)findViewById(R.id.deskripsi_baju);


        nama_baju.setText(nama_produk);
        harga_baju.setText(harga_produk);
//        berat_baju.setText(berat_produk);
        stok_baju.setText(stok_produk);
        deskripsi_baju.setText(deskripsi_produk);
        Glide.with(this).load(gambar_produk).into(gambar_baju);

    }
}
