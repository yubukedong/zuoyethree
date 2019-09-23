package com.example.daytwozuoyethree.api;

import com.example.daytwozuoyethree.bean.Beanone;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Mysevice {
    String s="http://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<Beanone> getData();
}
