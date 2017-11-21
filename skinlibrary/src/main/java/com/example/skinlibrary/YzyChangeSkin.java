package com.example.skinlibrary;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzy on 17-11-20.
 */

public class YzyChangeSkin implements LayoutInflaterFactory {
    private static final String[] prefixList = {"android.webkit.", "android.view.", "android.widget."};
    private List<SkinView> mSkinViews = new ArrayList<>();
    private static final YzyChangeSkin instance = new YzyChangeSkin();
    private YzyChangeSkin(){}
    public static YzyChangeSkin getInstance(){
        return instance;
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Log.e("yzy", "onCreateView=================: " + name);
        View view = null;
        //根据布局文件中的属性创建一个view
        if (name != null && name.contains(".")) {//代表是自定义控件，拥有全类名
            view = creatView(name, context, attrs);
        } else {//系统自带控件，不含有全类名，需要自己拼接
            for (String pre : prefixList) {
                view = creatView(pre + name, context, attrs);
                if (view != null) {
                    //找对了，实例化成功
                    break;
                }
            }
        }
        if (view != null) {
            paseSkinAttrs(context, attrs, view);
        }
        return view;
    }

    //解析控件的属性，判断哪些能够换肤
    private void paseSkinAttrs(Context pContext, AttributeSet pAttrs, View pView) {
        List<SkinAttr> vSkinAttrList = new ArrayList<>();
        for (int i = 0; i < pAttrs.getAttributeCount(); i++) {
            String attrName = pAttrs.getAttributeName(i);//background
            //能够换肤
            if (attrName.equals("background") || attrName.equals("textColor") || attrName.equals("src")) {
                Log.e("yzy", "attrName: " + attrName);
                String attrValue = pAttrs.getAttributeValue(i);//@color/colorText
                int resId = Integer.parseInt(attrValue.substring(1));//因为属性值前面有一个@所以要去掉
                String attrType = pContext.getResources().getResourceTypeName(resId);//前面的属性名color
                String attrTrueValue = pContext.getResources().getResourceEntryName(resId);//后面的具体引用colorButton
                Log.e("yzy", "------------ " +attrType + ":" +  attrTrueValue);
                SkinAttr vSkinAttr = new SkinAttr(attrName, attrType, attrTrueValue,resId);
                vSkinAttrList.add(vSkinAttr);
            }
        }

        if(!vSkinAttrList.isEmpty()) {
            SkinView vSkinView = new SkinView(pView, vSkinAttrList);
            mSkinViews.add(vSkinView);
            vSkinView.changeSkin();
        }
    }

    //创建我们自己的view
    private View creatView(String pName, Context pContext, AttributeSet pAttrs) {
        try {
            Class viewClazz = pContext.getClassLoader().loadClass(pName);
            Constructor<View> vConstructor = viewClazz.getConstructor(Context.class, AttributeSet.class);
            return vConstructor.newInstance(pContext, pAttrs);
        } catch (Exception pE) {
            pE.printStackTrace();
        }
        return null;
    }

    public void changeSkin(Context pContext, String path) {
        SkinManger.getInstance().init(pContext,path);
        for (SkinView vSkinView :mSkinViews){
            vSkinView.changeSkin();
        }
        MyShrep.getInstance(pContext).savePath(path);
    }


}
