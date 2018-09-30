package com.personal.xiri.uchat.component.skin.model;

/**
 * Created by Gaojianyang on 18/9/22.
 * github https://github.com/gaojianyang
 */
public class TextStyle extends SkinStyle {
    private float textSize;
    private String textColor;
    private String typeFaceId;
    private String reserve;

    public TextStyle() {
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getTypeFaceId() {
        return typeFaceId;
    }

    public void setTypeFaceId(String typeFaceId) {
        this.typeFaceId = typeFaceId;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}
