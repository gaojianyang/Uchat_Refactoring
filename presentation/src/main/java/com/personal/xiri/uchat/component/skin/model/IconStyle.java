package com.personal.xiri.uchat.component.skin.model;

import android.graphics.PorterDuff;

import com.personal.xiri.uchat.component.skin.model.SkinStyle;
import com.personal.xiri.uchat.component.skin.view.IconType;

/**
 * Created by Gaojianyang on 18/9/18.
 * github https://github.com/gaojianyang
 */
public class IconStyle extends SkinStyle {

    private String color;
    private String checkedColor;
    private String imgId;
    private String checkedImgId;
    private IconType iconType;
    private String textString;
    private String reserve;
    private String animData;
    private int textSize;

    public IconStyle() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public IconType getIconType() {
        return iconType;
    }

    public void setIconType(IconType iconType) {
        this.iconType = iconType;
    }

    public String getCheckedColor() {
        return checkedColor;
    }

    public void setCheckedColor(String checkedColor) {
        this.checkedColor = checkedColor;
    }

    public String getCheckedImgId() {
        return checkedImgId;
    }

    public void setCheckedImgId(String checkedImgId) {
        this.checkedImgId = checkedImgId;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getTextString() {
        return textString;
    }

    public void setTextString(String textString) {
        this.textString = textString;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getAnimData() {
        return animData;
    }

    public void setAnimData(String animData) {
        this.animData = animData;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }
}
