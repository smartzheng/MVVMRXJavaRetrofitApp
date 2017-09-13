package com.bar.mvvmapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bar.mvvmapp.R;
import com.bar.mvvmapp.databinding.ActivityMainBinding;
import com.bar.mvvmapp.net.RefreshCompletedListener;
import com.bar.mvvmapp.view.adapter.MainAdapter;
import com.bar.mvvmapp.viewmodel.MainViewModel;
import com.zhy.autolayout.AutoLayoutActivity;

public class MainActivity extends AutoLayoutActivity implements SwipeRefreshLayout.OnRefreshListener, RefreshCompletedListener {

    private ActivityMainBinding mBinding;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void init() {
        mBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerview.setItemAnimator(new DefaultItemAnimator());
        MainAdapter adapter = new MainAdapter();
        mBinding.recyclerview.setAdapter(adapter);
        mBinding.refreshLayout.setOnRefreshListener(this);
        mBinding.recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                if (!mBinding.refreshLayout.isRefreshing()
                        && mBinding.recyclerview.getAdapter().getItemCount() == lastVisibleItem + 1) {
                    mMainViewModel.getMoreMovies();
                }
            }
        });
        mMainViewModel = new MainViewModel(adapter, this);
        mBinding.setViewModel(mMainViewModel);
        mBinding.refreshLayout.setRefreshing(true);
        mMainViewModel.getInitMovies();
    }

    @Override
    public void onRefresh() {
        mMainViewModel.getInitMovies();
    }

    @Override
    public void onRefreshCompleted() {
        if (mBinding.refreshLayout.isRefreshing()) {
            mBinding.refreshLayout.setRefreshing(false);
        }
    }
}
