package com.personal.xiri.uchat.component.skin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.SparseArray;
import android.view.View;

import com.personal.xiri.data.entity.SkinEntity;
import com.personal.xiri.uchat.R;
import com.personal.xiri.uchat.component.skin.model.DefStyleEntity;
import com.personal.xiri.uchat.component.skin.model.IconStyle;
import com.personal.xiri.uchat.component.skin.model.ImageStyle;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;
import com.personal.xiri.uchat.component.skin.model.SkinStyleProvider;
import com.personal.xiri.uchat.component.skin.view.IconType;

import java.util.ArrayList;
import java.util.List;

import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_PHOTO;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_VIDEO;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_VOICE;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_EMOJI;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_GAME;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_MORE;
import static com.personal.xiri.uchat.component.skin.SkinId.ICON_BOTTOM_CAMERA;
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
 * Created by Gaojianyang on 18/9/20.
 * github https://github.com/gaojianyang
 */
public class DefaultSkinStyleManager {
    private Context context;

    public static final int ERROR = -1;

    private static final int[] iconIds = new int[]{ICON_BOTTOM_PHOTO, ICON_BOTTOM_VIDEO, ICON_BOTTOM_VOICE, ICON_BOTTOM_EMOJI, ICON_BOTTOM_GAME, ICON_BOTTOM_MORE, ICON_BOTTOM_CAMERA, ICON_EDIT_SEND};
    private static final int[] imgIds = new int[]{IMG_CHAT_CONTENT, IMG_CHAT_CONTENT_BOTTOM, IMG_CHAT_EDITTEXT, IMG_CHAT_BOTTOM_BAR, IMG_CHAT_BUBBLE, IMG_CHAT_BUBBLE_PEER, IMG_CHAT_DRAWER_SCRIM};
    private static final int[] txtIds = new int[]{TEXT_EDIT_CONTENT, TEXT_BUBBLE_CONTENT, TEXT_BUBBLE_CONTENT_PEER};


    private static final String[] defSkin1 = new String[]{"#6A759B", "#21273D", "#6A759B", "#21273D", "#E7E9EF", "#B9D4F1", "#FFFFFF", "#ffffff", "#B9C9DB", "#ffffff", "#515151"};
    private static final String[] defSkin2 = new String[]{"#723147", "#31152B", "#515151", "#a6a6a6", "#F9E4AD", "#CC4452", "#E6B098", "#ffffff", "#515151", "#ffffff", "#ffffff"};
    private static final String[] defSkin3 = new String[]{"#ffffff", "#555273", "#555273", "#a6a6a6", "#E23E57", "#65799B", "#E2EFF1", "#E2EFF1", "#555273", "#ffffff", "#515151"};

    private SparseArray<SkinStyleProvider> cacheStyleProviders = new SparseArray<>();

    public DefaultSkinStyleManager(Context context) {
        this.context = context;
    }

    public synchronized SkinStyleProvider getDefSkinStyleProvider(int seq) {
        if (cacheStyleProviders.get(seq) != null)
            return cacheStyleProviders.get(seq);

        SkinStyleProvider skinStyleProvider = null;
        switch (seq) {
            case 0:
                skinStyleProvider = DefaultSkinFactory.createSimpleSkin(iconIds, imgIds, txtIds, createSkinEntity(defSkin1));
                break;
            case 1:
                skinStyleProvider = DefaultSkinFactory.createSimpleSkin(iconIds, imgIds, txtIds, createSkinEntity(defSkin2));
                break;
            case 2:
                skinStyleProvider = DefaultSkinFactory.createSimpleSkin(iconIds, imgIds, txtIds, createSkinEntity(defSkin3));
                break;
        }
        cacheStyleProviders.put(seq, skinStyleProvider);
        return skinStyleProvider;
    }

    private DefStyleEntity createSkinEntity(String[] data) {
        DefStyleEntity defStyleEntity = new DefStyleEntity();
        defStyleEntity.setIconColor(data[0]);
        defStyleEntity.setIconCheckColor(data[1]);
        defStyleEntity.setIconSendColor(data[2]);
        defStyleEntity.setIconSendCheckColor(data[3]);
        defStyleEntity.setBgColor(data[4]);
        defStyleEntity.setBubbleBgColor(data[5]);
        defStyleEntity.setPeerBubbleBgColor(data[6]);
        defStyleEntity.setEtBgColor(data[7]);
        defStyleEntity.setEtTxtColor(data[8]);
        defStyleEntity.setBubbleTxtColor(data[9]);
        defStyleEntity.setPeerBubbleTxtColor(data[10]);
        return defStyleEntity;
    }

    public boolean hasDefaultStyle(int id) {
        return id > SkinId.STYLE_ID_BEGIN && id < SkinId.STYLE_ID_OVER;
    }

    public int getDefImgIdFromStyleId(int styleId) {
        int imgId = ERROR;
        switch (styleId) {
            case ICON_BOTTOM_PHOTO:
                imgId = R.mipmap.def_photo_3x;
                break;
            case ICON_BOTTOM_VIDEO:
                imgId = R.mipmap.def_skin_3x;
                break;
            case ICON_BOTTOM_VOICE:
                imgId = R.mipmap.def_voice_3x;
                break;
            case ICON_BOTTOM_EMOJI:
                imgId = R.mipmap.def_emoji_3x;
                break;
            case ICON_BOTTOM_GAME:
                imgId = R.mipmap.def_game_3x;
                break;
            case ICON_BOTTOM_MORE:
                imgId = R.mipmap.def_more_3x;
                break;
            case ICON_BOTTOM_CAMERA:
                imgId = R.mipmap.def_camera_3x;
                break;
            case ICON_EDIT_SEND:
                imgId = R.mipmap.line_send;
                break;
            default:
                break;

        }
        return imgId;
    }
//
//    public String getDefaultTextById(int styleId) {
//        String textString = "";
//        switch (styleId) {
//            case IMAGE_CHAT_DRAWER_FILE:
//                textString = context.getString(R.string.style_drawer_item_5);
//                break;
//            case IMAGE_CHAT_DRAWER_PHOTO:
//                textString = context.getString(R.string.style_drawer_item_6);
//                break;
//            case IMAGE_CHAT_DRAWER_SKIN:
//                textString = context.getString(R.string.style_drawer_item_3);
//                break;
//            case IMAGE_CHAT_DRAWER_GRADE:
//                textString = context.getString(R.string.style_drawer_item_4);
//                break;
//            case IMAGE_CHAT_DRAWER_VIDEO:
//                textString = context.getString(R.string.style_drawer_item_1);
//                break;
//            case IMAGE_CHAT_DRAWER_CALL:
//                textString = context.getString(R.string.style_drawer_item_2);
//                break;
//        }
//        return textString;
//    }
//
//    public int getDefaultColorByStyleId(int styleId, boolean checked, int themeId) {
//        if (themeId >= AppStyleManager.getThemeDatas().size()) {
//            themeId = 0;
//        }
//        Themedata themedata = AppStyleManager.getThemeDatas().get(themeId);
//        int defaultColor = Color.TRANSPARENT;
//        switch (styleId) {
//            case IMAGE_BOTTOM_PHOTO:
//            case IMAGE_BOTTOM_VIDEO:
//            case IMAGE_BOTTOM_VOICE:
//            case IMAGE_BOTTOM_EMOJI:
//            case IMAGE_BOTTOM_GAME:
//            case IMAGE_BOTTOM_MORE:
//            case IMAGE_BOTTOM_CAMERA:
//                if (!checked)
//                    defaultColor = Color.parseColor(themedata.getIconColor());
//                else
//                    defaultColor = Color.parseColor(themedata.getIconCheckColor());
//                break;
//            case IMAGE_EDIT_SEND:
//                if (!checked)
//                    defaultColor = Color.parseColor(themedata.getIconSendColor());
//                else
//                    defaultColor = Color.parseColor(themedata.getIconSendCheckColor());
//                break;
//            case BG_CHAT_CONTENT:
//                defaultColor = Color.parseColor(themedata.getBgColor());
//                break;
//            case BG_CHAT_CONTENT_BOTTOM:
//                break;
//            case BG_CHAT_EDITTEXT:
//                defaultColor = Color.parseColor(themedata.getEditTextBgColor());
//                break;
//            case BG_CHAT_BOTTOM_BAR:
//                break;
//            case IMAGE_CHAT_DRAWER_FILE:
//            case IMAGE_CHAT_DRAWER_PHOTO:
//            case IMAGE_CHAT_DRAWER_VIDEO:
//            case IMAGE_CHAT_DRAWER_CALL:
//            case IMAGE_CHAT_DRAWER_SKIN:
//            case IMAGE_CHAT_DRAWER_GRADE:
//                defaultColor = Color.parseColor(themedata.getMenuColor());
//                break;
//            case BG_CHAT_CONTENT_RIGHT:
//                defaultColor = Color.parseColor(themedata.getChatBgColor());
//                break;
//            case BG_CHAT_DRAWER_RIGHT:
//                break;
//            case BG_CHAT_DRAWER_TOP_RIGHT:
//                break;
//            case BG_CHAT_DRAWER_BOTTOM_RIGHT:
//                break;
//            case BG_CHAT_DRAWER_SCRIM_RIGHT:
//                break;
//            default:
//                break;
//
//        }
//        return defaultColor;
//
//    }
//
//    public int getDefaultChatBgColor(boolean isMirror, int themeId) {
//        if (themeId >= AppStyleManager.getThemeDatas().size()) {
//            themeId = 0;
//        }
//        Themedata themedata = AppStyleManager.getThemeDatas().get(themeId);
//        if (!isMirror) return Color.parseColor(themedata.getChatBgColor());
//        else return Color.parseColor(themedata.getChatOtherBgColor());
//
//    }
//
//    public int getDefaultTextColorByStyleId(int styleId, int themeId) {
//        int defaultColor = Color.parseColor("#ff515151");
//        Themedata themedata = AppStyleManager.getThemeDatas().get(themeId);
//        switch (styleId) {
//            case TEXT_CHAT_CONTENT_RIGHT:
//                break;
//            case TEXT_CHAT_CONTENT_EDIT:
//                defaultColor = Color.parseColor(themedata.getEditTextContentColor());
//                break;
//            case TEXT_CHAT_CONTENT_LOGO:
//                defaultColor = Color.parseColor(themedata.getLogoColor());
//                break;
//            case TEXT_DRAWER_NAME:
//                defaultColor = Color.parseColor(themedata.getNameColor());
//                break;
//            case TEXT_DRAWER_SIGN:
//                defaultColor = Color.parseColor(themedata.getSignColor());
//                break;
//            case TEXT_DRAWER_MENU:
//                defaultColor = Color.parseColor(themedata.getMenuColor());
//                break;
//            default:
//                break;
//
//        }
//        return defaultColor;
//    }

}
