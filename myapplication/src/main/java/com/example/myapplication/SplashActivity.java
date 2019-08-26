package com.example.myapplication;

import android.widget.ImageView;

import butterknife.BindView;

/**
 * @author Administrator
 */
public class SplashActivity extends BaseActivity {
    @BindView(R.id.iv)
    ImageView mIv;

    @Override
    protected void initData() {
        mIv.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }
}
