package com.example.baseapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.baseapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 登录使用的对话框
 */
public class LoginProgressDialog extends Dialog {


    public LoginProgressDialog(@NonNull Context context) {
        this(context, R.style.BaseDialog);
    }

    public LoginProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initDialog();
    }


    @BindView(R.id.tv_load_desc)
    TextView tvLoadDesc;


    private void initDialog() {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_loading, null);
        ButterKnife.bind(this, contentView);
        setContentView(contentView);
        getWindow().setGravity(Gravity.CENTER);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void show(String text) {
        tvLoadDesc.setText(text);
        show();
    }
}
