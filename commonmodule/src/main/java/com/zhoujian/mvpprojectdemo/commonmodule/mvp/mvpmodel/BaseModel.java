package com.zhoujian.mvpprojectdemo.commonmodule.mvp.mvpmodel;

public interface BaseModel {

    interface CallBack<T> {
        void sucess(T data);
        void fail(Object data);
    }

    //普通请求消息接口可以调用这个回调
    interface MessageCallBack<T> extends CallBack {
        void begin(T data);//本地保存数据后，发送消息前，需要通知adapter增加一条消息
    }

    //上传接口可以调用这个回调
    interface UploadCallBack<T> extends MessageCallBack {
        void progressing(T data);//正在上传
    }
}
