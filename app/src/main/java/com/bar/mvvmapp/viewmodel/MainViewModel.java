package com.bar.mvvmapp.viewmodel;

import com.bar.mvvmapp.adapter.MainAdapter;
import com.bar.mvvmapp.databinding.ActivityMainBinding;
import com.bar.mvvmapp.model.BaseModel;
import com.bar.mvvmapp.model.Bean.MovieBean;
import com.bar.mvvmapp.model.MainModel;
import com.bar.mvvmapp.net.RequestListener;

/**
 * Created by smartzheng on 2017/9/12.
 */

public class MainViewModel implements RequestListener<MovieBean>{
    private final BaseModel mModel;
    private ActivityMainBinding mBinding;

    public MainViewModel(ActivityMainBinding binding) {
        mBinding = binding;
        mModel = new MainModel(this);
    }

    @Override
    public void success(MovieBean data) {
       mBinding.setMovie(data);
        mBinding.recyclerview.setAdapter(new MainAdapter(data.getSubjects()));
    }

    @Override
    public void failed(String msg) {

    }
    public void getMovies(){
        mModel.getData();
    }
}
