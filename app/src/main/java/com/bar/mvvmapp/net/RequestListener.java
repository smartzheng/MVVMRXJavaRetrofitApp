package com.bar.mvvmapp.net;

/**
 * Created by smartzheng on 2017/9/12.
 */

public interface RequestListener<T> {
    void success(T data);
    void failed(String msg);
}
