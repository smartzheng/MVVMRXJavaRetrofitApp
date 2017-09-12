package com.bar.mvvmapp.model;

import com.bar.mvvmapp.net.Constant;
import com.bar.mvvmapp.net.DoubanApi;
import com.bar.mvvmapp.net.RequestListener;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by smartzheng on 2017/9/12.
 */

public abstract class BaseModel<T> {
    private RequestListener<T> mListener;
    public static DoubanApi sApi;

    public BaseModel(RequestListener<T> listener) {
        mListener = listener;
        //初始化retrofit
        if (sApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            sApi = retrofit.create(DoubanApi.class);
        }

    }

    public abstract Observable<T> getObservable();

    public void getData() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mListener.failed("加载失败");
                    }

                    @Override
                    public void onNext(T t) {
                        mListener.success(t);
                    }
                });
    }
}
