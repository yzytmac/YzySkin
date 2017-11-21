package com.example.yzy.skindemo;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import com.example.skinlibrary.SkinActivity;

import java.io.File;

public class MainActivity extends SkinActivity {

    private EditText mSkinEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSkinEd = (EditText)findViewById(R.id.skin_ed);

    }

    public void onClick(View pView) {
        String skinName= mSkinEd.getText().toString()+".apk";
        String path = Environment.getExternalStorageDirectory()+ File.separator+skinName;
        YzyChangeSkin.changeSkin(MainActivity.this, path);
    }
}
