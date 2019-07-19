package com.example.baseapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.base.base.BaseRecyclerAdapter;

import butterknife.BindView;

/**
 * @author : sklyand
 * @email : zhengdengyao@51yryc.com
 * @time : 2019/7/19 11:07
 * @describe ：
 */
public class TestAdapter extends BaseRecyclerAdapter<String> {
    @Override
    protected int getItemViewType(int position, String s) {
        return R.layout.layout_test;
    }

    @Override
    protected ViewHolder<String> onCreateViewHolder(View root, ViewGroup parent, int viewType) {
        return new TestViewHolder(root);
    }

    public class TestViewHolder extends BaseRecyclerAdapter.ViewHolder<String>{
        @BindView(R.id.tv_test)
        TextView tv_test;

        public TestViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(String s) {
            tv_test.setText(s);
        }
    }
}
