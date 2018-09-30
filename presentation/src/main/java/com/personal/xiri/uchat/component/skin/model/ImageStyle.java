package com.personal.xiri.uchat.component.skin.model;

import com.personal.xiri.uchat.component.skin.view.ImageType;
import com.personal.xiri.uchat.component.skin.view.ShapeType;

/**
 * Created by Gaojianyang on 18/9/19.
 * github https://github.com/gaojianyang
 */
public class ImageStyle extends SkinStyle {
    private String imgId;
    private String radius;
    private ImageType imageType;
    private String color;
    private String description;
    private String reserve;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
