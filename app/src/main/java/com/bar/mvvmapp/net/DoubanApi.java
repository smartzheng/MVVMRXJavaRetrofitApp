package com.bar.mvvmapp.net;

import com.bar.mvvmapp.model.Bean.MovieBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by smartzheng on 2017/4/4.
 *
 */

public interface DoubanApi {
    @GET(Constant.MOVIE_HOT)
    Observable<MovieBean> hot(@QueryMap Map<String, Object> params);


   // @GET(Constant.MUSIC)
    //Observable<ReadBean> music(@QueryMap Map<String, Object> params);

}
