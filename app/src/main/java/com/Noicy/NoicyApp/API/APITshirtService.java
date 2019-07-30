package com.Noicy.NoicyApp.API;

import com.Noicy.NoicyApp.model.TshirtModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APITshirtService {

    //read
    @GET("erbq5")
    Call<TshirtModel>getNoicyTsirt();

}
