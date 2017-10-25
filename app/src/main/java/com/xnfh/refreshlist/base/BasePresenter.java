package com.xnfh.refreshlist.base;

import com.xnfh.refreshlist.base.mvp.MvpPresenter;

/**
 * Created by wangxuewei on 2017/10/25.
 */
public class BasePresenter<V extends BaseView> extends MvpPresenter {
    /**
     * 绑定的view
     */
    private V mvpView;

    /**
     * 断开view，一般在onDestroy中调用
     */
    @Override
    public void detachView() {
        this.mvpView = null;
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mvpView != null;
    }
    /**
     * 获取连接的view
     */
    public V getView(){
        return mvpView;
    }

}
