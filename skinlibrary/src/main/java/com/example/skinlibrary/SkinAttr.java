package com.example.skinlibrary;

/**
 * Created by yzy on 17-11-20.
 * background="@color/colorText"
 */

public class SkinAttr {
    /**
     * background
     */
    public String attrName;

    /**
     * @color
     */
    public String attrType;
    /**
     * colorText
     */
    public String attrValue;

    /**
     * 资源id
     */
    public int resId;

    public SkinAttr(String pAttrName, String pAttrType, String pAttrValue,int pResId) {
        attrName = pAttrName;
        attrType = pAttrType;
        attrValue = pAttrValue;
        resId = pResId;
    }
}
