package com.Noicy.NoicyApp.model;


public class FeedModel {
    private int mImageResource;
    private String namaGambar;

    public FeedModel(int ImageResource, String namagambar){
        mImageResource = ImageResource;
        namaGambar = namagambar;

    }

    public int getmImageResource(){
        return mImageResource;
    }

    public String getNamaGambar(){
        return namaGambar;
    }

}
