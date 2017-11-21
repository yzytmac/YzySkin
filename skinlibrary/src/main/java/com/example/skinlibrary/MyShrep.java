package com.example.skinlibrary;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yzy on 17-11-21.
 */

public class MyShrep {
    private static SharedPreferences mPreferences;
    private MyShrep() {
    }
    private static MyShrep instance;

    public static MyShrep getInstance(Context ctx) {
        if (mPreferences == null) {
            mPreferences = ctx.getSharedPreferences("yang", Context.MODE_PRIVATE);
        }

        if (instance == null) {
            instance = new MyShrep();
        }
        return instance;
    }

    public void savePath(String path){
        mPreferences.edit().putString("skinPath",path).commit();
    }

    public String getPath(){
        return mPreferences.getString("skinPath","-1");
    }
}
