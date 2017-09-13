package com.bar.mvvmapp.model;

import com.bar.mvvmapp.model.Bean.MovieBean;
import com.bar.mvvmapp.net.RequestListener;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;


/**
 * Created by smartzheng on 2017/6/2.
 */

public class MainModel extends BaseModel<MovieBean, Map<String, Object>> {


    private Map<String, Object> mMap;
    private int mStart = 0;

    public MainModel(RequestListener<MovieBean> mListener) {
        super(mListener);
        mMap = new HashMap<>();
    }

    @Override
    public Observable<MovieBean> getObservable(Map<String, Object> param) {
        return sApi.hot(param);//根据不同的泛型和API可以扩展为返回不同的数据
    }

    @Override
    protected Map<String, Object> getMoreParam() {
        mStart += 20;
        mMap.put("start", mStart);
        return mMap;
    }

    @Override
    protected Map<String, Object> getInitParam() {
        mStart = 0;
        mMap.put("start", mStart);
        mMap.put("count", 20);
        return mMap;
    }
}
