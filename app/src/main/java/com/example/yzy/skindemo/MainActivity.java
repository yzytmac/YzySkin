package com.example.yzy.skindemo;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import com.example.skinlibrary.BaseActivity;

import java.io.File;

public class MainActivity extends BaseActivity {

    private EditText nSkinEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nSkinEd = (EditText)findViewById(R.id.skin_ed);

    }

    public void onClick(View pView) {
        String skinName=nSkinEd.getText().toString()+".apk";
        String path = Environment.getExternalStorageDirectory()+ File.separator+skinName;
        mSkinFactory.apply(MainActivity.this, path);
    }
}
