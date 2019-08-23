package com.example.baseapplication;

import android.Manifest;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.base.base.BaseActivity;
import com.example.base.base.BaseRecyclerAdapter;
import com.example.base.rx.RxEvent;
import com.example.base.util.PermissionUtil;
import com.example.baseapplication.dagger2.Dagger2Activity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TestAdapter testAdapter = new TestAdapter();
        List<String> data = new ArrayList<>();
        for (int i = 0;i<10;i++){
            data.add("内容");
        }

        testAdapter.replace(data);
        recyclerView.setAdapter(testAdapter);
        testAdapter.addHeaderView(R.layout.layout_test ,333,new BaseRecyclerAdapter.DataInjector<Integer>() {
            @Override
            public void onInject(Integer data, View root) {
                TextView textView = root.findViewById(R.id.tv_test);
                textView.setText(String.valueOf(data));
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        PermissionUtil.requestPermissionEach(MainActivity.this, new PermissionUtil.EachPermissionListenerImp() {
//                            @Override
//                            public void onEachGranted(String permission) {
//                                super.onEachGranted(permission);
//                            }
//                        }, Manifest.permission.CAMERA);

                        Intent intent = new Intent(MainActivity.this, Dagger2Activity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        testAdapter.addHeaderView(R.layout.layout_test);
        testAdapter.addFooterView(R.layout.layout_test, 444,new BaseRecyclerAdapter.DataInjector<Integer>() {
            @Override
            public void onInject(Integer data, View root) {
                TextView textView = root.findViewById(R.id.tv_test);
                textView.setText(String.valueOf(data));
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomViewActivity.start(MainActivity.this);

                    }
                });
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void handleDefaultEvent(RxEvent event) {

    }
}
