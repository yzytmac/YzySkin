package com.example.yzy.skindemo;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View pView) {
        String flag="-1";
        switch (pView.getId()) {
            case R.id.bt:
                flag = "-1";
                break;
            case R.id.bt0:
                flag = "0";
                break;
            case R.id.bt1:
                flag = "1";
                break;
            case R.id.bt2:
                flag = "2";
                break;
            default:
        }
        mSkinFactory.apply(MainActivity.this, flag);
        MyShrep.getInstance(this).saveFlag(flag);
    }
}
