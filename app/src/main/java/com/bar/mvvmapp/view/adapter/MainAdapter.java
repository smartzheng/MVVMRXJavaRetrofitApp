package com.bar.mvvmapp.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bar.mvvmapp.R;
import com.bar.mvvmapp.databinding.ItemMovieBinding;
import com.bar.mvvmapp.model.Bean.MovieBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by smartzheng on 2017/6/5.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.BindingHolder> {
    private List<MovieBean.SubjectsBean> mMovies;

    public MainAdapter() {
        mMovies = new ArrayList<>();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMovieBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_movie, parent, false);
        return new BindingHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void addMovieSubjects(List<MovieBean.SubjectsBean> subjects) {
        mMovies.addAll(subjects);
        notifyDataSetChanged();
    }

    /**
     * 基本为固定写法
     */
    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemMovieBinding binding;

        public BindingHolder(ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieBean.SubjectsBean item) {
            binding.setItem(item);
            binding.executePendingBindings();
        }
    }
    public void clearMovieSubjects(){
        mMovies.clear();
    }
}
