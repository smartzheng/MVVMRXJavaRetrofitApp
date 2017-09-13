package com.bar.mvvmapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.bar.mvvmapp.R;
import com.bar.mvvmapp.databinding.ActivityMainBinding;
import com.bar.mvvmapp.viewmodel.MainViewModel;
import com.zhy.autolayout.AutoLayoutActivity;

public class MainActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = new MainViewModel(binding);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setItemAnimator(new DefaultItemAnimator());
        mainViewModel.getMovies();
    }
}
