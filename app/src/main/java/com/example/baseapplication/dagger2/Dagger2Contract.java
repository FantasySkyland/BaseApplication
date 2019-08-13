package com.example.baseapplication.dagger2;

import com.example.base.base.BaseContract;

/**
 * @author : sklyand
 * @email :
 * @time : 2019/8/13 10:01
 * @describe ：
 */
public interface Dagger2Contract {
    interface Presenter extends BaseContract.Presenter<View> {
        void test();
    }

    interface View extends BaseContract.View<Presenter>{
        void start();
    }
}
