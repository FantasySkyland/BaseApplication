package com.example.baseapplication.dagger2;

import com.example.base.base.BaseContract;

import dagger.Module;
import dagger.Provides;

/**
 * @author : sklyand
 * @email :
 * @time : 2019/8/13 09:40
 * @describe ：
 */
@Module
public class CommonModule {
    private Dagger2Contract.View view;

    public CommonModule(Dagger2Contract.View view) {
        this.view = view;
    }
    @Provides
    @ActivityScope
    public Dagger2Contract.View provideView(){
        return this.view;
    }
    @Provides
    @ActivityScope
    public String provideContent(){
        return "提供了Content";
    }
}
