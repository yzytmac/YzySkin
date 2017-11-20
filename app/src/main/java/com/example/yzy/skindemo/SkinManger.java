package com.example.yzy.skindemo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by yzy on 17-11-20.
 */

public class SkinManger {
    private Resources skinRes;//内存卡中的resources对象
    private Context mContext;
    private String skinPackage;//皮肤报名

    public void init(Context pContext,String flag) {
        mContext = pContext.getApplicationContext();//全局引用，时间最长
        File vFile = new File(Environment.getExternalStorageDirectory(), "skin"+flag+".apk");
        SkinManger.getInstance().loadSkin(vFile.getAbsolutePath());
    }

    private static final SkinManger ourInstance = new SkinManger();

    public static SkinManger getInstance() {
        return ourInstance;
    }

    public void loadSkin(String path) {
        try {
            AssetManager vAssetManager = AssetManager.class.newInstance();
//            vAssetManager.addAssetPath(path);调了该方法，vAssetManager才是内存卡资源的管理器，不然就是个空管理器，用不了，只能反射
            Method vAddAssetPath = vAssetManager.getClass().getMethod("addAssetPath", String.class);
            vAddAssetPath.invoke(vAssetManager,path);
            skinRes = new Resources(vAssetManager, mContext.getResources().getDisplayMetrics(), mContext.getResources().getConfiguration());

            PackageManager vPackageManager = mContext.getPackageManager();
            skinPackage = vPackageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES).packageName;

        } catch (Exception pE) {
            pE.printStackTrace();
        }

    }

    private SkinManger() {
    }

    public int getColor(SkinAttr pSkinAttr) {
        if (skinRes == null) {//代表资源包没有下载
            return pSkinAttr.resId;
        }
        String attrValueName = pSkinAttr.attrValue;
        int id = skinRes.getIdentifier(attrValueName, pSkinAttr.attrType, skinPackage);
        Log.e("yzy", "skinPackage===: " + skinPackage);
        if(id==0) {
            return pSkinAttr.resId;
        }
        return skinRes.getColor(id);
    }
}
