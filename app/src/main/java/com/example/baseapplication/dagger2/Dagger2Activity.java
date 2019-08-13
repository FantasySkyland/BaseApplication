package com.example.baseapplication.dagger2;

import android.view.View;
import android.widget.Button;

import com.example.base.base.BaseMvpActivity;
import com.example.base.util.ToastUtils;
import com.example.baseapplication.R;

import javax.inject.Inject;

import butterknife.BindView;

public class Dagger2Activity extends BaseMvpActivity<Dagger2Contract.Presenter> implements Dagger2Contract.View {
    @Inject
    Dagger2Presenter dagger2Presenter;
    @BindView(R.id.btn)
    Button button;
    @Inject
    String content;
    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_dagger2;
    }

    @Override
    protected void initWidget() {
        DaggerCommonComponent.builder().commonModule(new CommonModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dagger2Presenter.test();
            }
        });
    }

    @Override
    protected Dagger2Contract.Presenter initPresenter() {
        return null;
    }

    @Override
    public void start() {
        ToastUtils.showShortToast(content);
    }
}
