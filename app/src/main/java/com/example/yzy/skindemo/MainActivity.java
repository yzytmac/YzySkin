package com.example.yzy.skindemo;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View pView){
        switch (pView.getId()){
            case R.id.bt1:
                mSkinFactory.apply(MainActivity.this,"");
                break;
            case R.id.bt2:
                mSkinFactory.apply(MainActivity.this,"0");
                break;
            default:
        }

    }
}
