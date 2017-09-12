package com.bar.mvvmapp.model;

import com.bar.mvvmapp.model.Bean.MovieBean;
import com.bar.mvvmapp.net.RequestListener;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;


/**
 * Created by smartzheng on 2017/6/2.
 */

public class MainModel extends BaseModel<MovieBean>{

    public MainModel(RequestListener<MovieBean> mListener) {
        super(mListener);
    }

    @Override
    public Observable<MovieBean> getObservable() {
        Map<String,Object> param = new HashMap<>();
        param.put("start", 0);
        param.put("count", 20);
        return sApi.hot(param);
    }
}
