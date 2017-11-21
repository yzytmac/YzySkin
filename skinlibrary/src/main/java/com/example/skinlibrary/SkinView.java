package com.example.skinlibrary;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yzy on 17-11-20.
 */

public class SkinView {
    private View mView;
    private List<SkinAttr> list;

    public SkinView(View pView, List<SkinAttr> pList) {
        mView = pView;
        list = pList;
    }

    public void apply(){
        for (SkinAttr vAttr : list) {
            if(vAttr.attrName.equals("background")) {
                if(vAttr.attrType.equals("color")) {
                    mView.setBackgroundColor(SkinManger.getInstance().getColor(vAttr));
                }else if(vAttr.attrType.equals("drawable")) {
                    mView.setBackground(SkinManger.getInstance().getDrawable(vAttr));
                }
            }else if(vAttr.attrName.equals("textColor")) {
                TextView tv = (TextView) mView;
                tv.setTextColor(SkinManger.getInstance().getColor(vAttr));
            }else if(vAttr.attrName.equals("src")) {
                ImageView iv = (ImageView) mView;
                iv.setImageDrawable(SkinManger.getInstance().getDrawable(vAttr));
            }
        }

    }
}
