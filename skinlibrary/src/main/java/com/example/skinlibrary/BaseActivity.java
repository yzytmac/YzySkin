package com.example.skinlibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;

public class BaseActivity extends Activity {

    protected SkinFactory mSkinFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String path = MyShrep.getInstance(this).getPath();
        SkinManger.getInstance().init(this,path);
        mSkinFactory = new SkinFactory();
        //监听布局填充的情况
        LayoutInflaterCompat.setFactory(getLayoutInflater(),mSkinFactory);
    }
}
