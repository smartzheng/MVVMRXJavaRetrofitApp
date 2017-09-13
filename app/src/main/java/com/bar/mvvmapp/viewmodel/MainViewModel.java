package com.bar.mvvmapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.bar.mvvmapp.model.BaseModel;
import com.bar.mvvmapp.model.Bean.MovieBean;
import com.bar.mvvmapp.model.MainModel;
import com.bar.mvvmapp.net.RefreshCompletedListener;
import com.bar.mvvmapp.net.RequestListener;
import com.bar.mvvmapp.view.adapter.MainAdapter;

/**
 * Created by smartzheng on 2017/9/12.
 */

public class MainViewModel extends BaseObservable implements RequestListener<MovieBean> {
    private final BaseModel mModel;
    private MainAdapter mAdapter;
    public ObservableField<MovieBean> mMovieBean = new ObservableField<>();
    public ObservableInt mLoadMoreVisibility = new ObservableInt(View.GONE);
    private  RefreshCompletedListener mListener;

    public MainViewModel(MainAdapter adapter, RefreshCompletedListener listener) {
        mModel = new MainModel(this);
        mAdapter = adapter;
        mListener = listener;
    }

    @Override
    public void success(MovieBean data) {
        mMovieBean.set(data);//这里实际只使用到了title，实际开发使用的数据量较大
        mAdapter.addMovieSubjects(data.getSubjects());
        mListener.onRefreshCompleted();
        mLoadMoreVisibility.set(View.GONE);
    }

    @Override
    public void failed(String msg) {
        mListener.onRefreshCompleted();
        mLoadMoreVisibility.set(View.GONE);
        //加载失败的处理，也可以利用databingding在xml文件中根据data返回值处理
    }

    public void getInitMovies() {
        if (mLoadMoreVisibility !=null&&!(mLoadMoreVisibility.get()==View.VISIBLE)){
            mAdapter.clearMovieSubjects();
            mModel.initData();
        }
    }
    public void getMoreMovies() {
        if (mLoadMoreVisibility !=null&&!(mLoadMoreVisibility.get()==View.VISIBLE)){
            mLoadMoreVisibility.set(View.VISIBLE);
            mModel.getMoreData();
        }
    }
}
