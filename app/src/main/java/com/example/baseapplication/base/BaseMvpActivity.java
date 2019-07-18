package com.example.baseapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;


/**
 * @Author zhengdengyao
 * @Created 2019/1/4 0004
 * @Description mvp Activity的基类 mvp的activity继承此类
 */
public abstract class BaseMvpActivity<Presenter extends BaseContract.Presenter> extends
        BaseActivity implements BaseContract.View<Presenter>{
    protected final String TAG = getClass().getSimpleName();
    protected Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
        setPresenter(initPresenter(),mProvider);
        init();
    }

    /**
     * 初始化
     */
    protected abstract void init();

    /**
     * @return xml文件
     */
    protected abstract @LayoutRes int setLayoutRes();

    /**
     * @return 初始化presenter
     */
    protected abstract Presenter initPresenter();

    @Override
    public void setPresenter(Presenter presenter, LifecycleProvider<ActivityEvent> provider) {
        this.presenter = presenter;
        if (this.presenter!=null){
            presenter.setProvider(provider);
        }
    }

    @Override
    public Context getAContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.destroy();
        }
    }
}