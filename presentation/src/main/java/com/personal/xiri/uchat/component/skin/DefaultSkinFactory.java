package com.personal.xiri.uchat.component.skin;

import android.graphics.PorterDuff;
import android.util.SparseArray;

import com.personal.xiri.uchat.component.skin.model.DefStyleEntity;
import com.personal.xiri.uchat.component.skin.model.IconStyle;
import com.personal.xiri.uchat.component.skin.model.ImageStyle;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;
import com.personal.xiri.uchat.component.skin.model.SkinStyleProvider;
import com.personal.xiri.uchat.component.skin.model.TextStyle;
import com.personal.xiri.uchat.component.skin.view.IconType;
import com.personal.xiri.uchat.component.skin.view.ImageType;

import java.util.ArrayList;
import java.util.List;

import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_CAMERA;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_EMOJI;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_GAME;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_MORE;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_PHOTO;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_VIDEO;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_VOICE;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_EDIT_SEND;
import static com.personal.xiri.uchat.component.skin.SkinId.IMG_CHAT_BOTTOM_BAR;
import static com.personal.xiri.uchat.component.skin.SkinId.IMG_CHAT_BUBBLE;
import static com.personal.xiri.uchat.component.skin.SkinId.IMG_CHAT_BUBBLE_PEER;
import static com.personal.xiri.uchat.component.skin.SkinId.IMG_CHAT_CONTENT;
import static com.personal.xiri.uchat.component.skin.SkinId.IMG_CHAT_CONTENT_BOTTOM;
import static com.personal.xiri.uchat.component.skin.SkinId.IMG_CHAT_DRAWER_SCRIM;
import static com.personal.xiri.uchat.component.skin.SkinId.IMG_CHAT_EDITTEXT;
import static com.personal.xiri.uchat.component.skin.SkinId.TEXT_BUBBLE_CONTENT;
import static com.personal.xiri.uchat.component.skin.SkinId.TEXT_BUBBLE_CONTENT_PEER;
import static com.personal.xiri.uchat.component.skin.SkinId.TEXT_EDIT_CONTENT;

/**
 * Created by Gaojianyang on 18/9/22.
 * github https://github.com/gaojianyang
 */
public class DefaultSkinFactory {

    public static SkinStyleProvider createSimpleSkin(int[] iconIds, int[] imgIds, int[] txtIds, DefStyleEntity defStyleEntity) {
        SkinStyleProvider styleProvider = new SkinStyleProvider();
        List<SkinStyle> skinStylesList = new ArrayList<>();
        SparseArray<SkinStyle> skinStyleSparseArray = new SparseArray<>();
        for (int iconId : iconIds) {
            IconStyle iconStyle = makeIconStyle(iconId, defStyleEntity);
            skinStylesList.add(iconStyle);
            skinStyleSparseArray.put(iconId, iconStyle);
        }
        for (int imgId : imgIds) {
            ImageStyle imageStyle = makeImgStyle(imgId, defStyleEntity);
            skinStylesList.add(imageStyle);
            skinStyleSparseArray.put(imgId, imageStyle);
        }
        for (int txtId : txtIds) {
            ImageStyle imageStyle = makeImgStyle(txtId, defStyleEntity);
            skinStylesList.add(imageStyle);
            skinStyleSparseArray.put(txtId, imageStyle);
        }
        styleProvider.setSkinStylesList(skinStylesList);
        styleProvider.setSkinStyleSparseArray(skinStyleSparseArray);
        return styleProvider;
    }


    private static IconStyle makeIconStyle(int id, DefStyleEntity defStyleEntity) {
        IconStyle iconStyle = new IconStyle();
        iconStyle.setId(id);
        iconStyle.setIconType(IconType.DEF);
        switch (id) {
            case ICON_BOTTOM_PHOTO:
            case ICON_BOTTOM_VIDEO:
            case ICON_BOTTOM_VOICE:
            case ICON_BOTTOM_EMOJI:
            case ICON_BOTTOM_GAME:
            case ICON_BOTTOM_MORE:
            case ICON_BOTTOM_CAMERA:
                iconStyle.setColor(defStyleEntity.getIconColor());
                iconStyle.setCheckedColor(defStyleEntity.getIconCheckColor());
                break;
            case ICON_EDIT_SEND:
                iconStyle.setColor(defStyleEntity.getIconSendColor());
                iconStyle.setCheckedColor(defStyleEntity.getIconSendCheckColor());
                break;
        }
        return iconStyle;
    }

    private static ImageStyle makeImgStyle(int id, DefStyleEntity defStyleEntity) {
        ImageStyle imgStyle = new ImageStyle();
        imgStyle.setId(id);
        imgStyle.setImageType(ImageType.COLOR);
        switch (id) {
            case IMG_CHAT_CONTENT_BOTTOM:
            case IMG_CHAT_DRAWER_SCRIM:
            case IMG_CHAT_BOTTOM_BAR:
                break;
            case IMG_CHAT_BUBBLE:
                imgStyle.setColor(defStyleEntity.getBubbleBgColor());
                break;
            case IMG_CHAT_BUBBLE_PEER:
                imgStyle.setColor(defStyleEntity.getPeerBubbleBgColor());
                break;
            case IMG_CHAT_CONTENT:
                imgStyle.setColor(defStyleEntity.getBgColor());
                break;
            case IMG_CHAT_EDITTEXT:
                imgStyle.setColor(defStyleEntity.getEtBgColor());
                break;

        }
        return imgStyle;
    }

    private static TextStyle makeTextStyle(int id, DefStyleEntity defStyleEntity) {
        TextStyle textStyle = new TextStyle();
        textStyle.setId(id);
        switch (id) {
            case TEXT_EDIT_CONTENT:
                textStyle.setTextColor(defStyleEntity.getEtTxtColor());
                break;
            case TEXT_BUBBLE_CONTENT:
                textStyle.setTextColor(defStyleEntity.getBubbleTxtColor());
                break;
            case TEXT_BUBBLE_CONTENT_PEER:
                textStyle.setTextColor(defStyleEntity.getPeerBubbleTxtColor());
                break;
        }
        return textStyle;
    }

}
