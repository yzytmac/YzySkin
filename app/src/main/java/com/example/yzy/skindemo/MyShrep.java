package com.example.yzy.skindemo;

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

    public void saveFlag(String flag){
        mPreferences.edit().putString("flag",flag).commit();
    }

    public String getFlag(){
        return mPreferences.getString("flag","-1");
    }
}
