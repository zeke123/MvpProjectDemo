package com.zhoujian.mvpprojectdemo.commonmodule.mvp.mvppresenter;

import com.zhoujian.mvpprojectdemo.commonmodule.mvp.mvpview.BaseView;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseView> {

    public WeakReference<V> baseView;

    private int pageSize = 20;

    public void attachView(V baseView){


    }



}
