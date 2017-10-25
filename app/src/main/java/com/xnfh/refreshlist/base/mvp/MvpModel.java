package com.xnfh.refreshlist.base.mvp;

import android.os.Handler;

/**
 * Created by wangxuewei on 2017/10/25.
 */
public class MvpModel {
    /**
            * 获取网络接口数据
    * @param param 请求参数
    * @param callback 数据回调接口
    */
    public static void getNetData(final String param, final MvpCallback callback){
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param){
                    case "normal":
                        callback.onSuccess("根据参数"+param+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        },2000);
    }
}
