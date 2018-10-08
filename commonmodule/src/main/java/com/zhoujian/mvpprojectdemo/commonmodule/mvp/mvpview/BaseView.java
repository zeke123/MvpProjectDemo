package com.zhoujian.mvpprojectdemo.commonmodule.mvp.mvpview;

public interface BaseView {

    void showLoading();

    void hideLoading();

    void showView(int code, Object data);

    class code {
        int load = 1;
    }
}
