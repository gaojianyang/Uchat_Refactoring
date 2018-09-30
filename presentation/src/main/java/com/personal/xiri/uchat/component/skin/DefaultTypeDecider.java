package com.personal.xiri.uchat.component.skin;

import com.personal.xiri.uchat.component.skin.model.SkinModuleType;

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
import static com.personal.xiri.uchat.component.skin.SkinId.IMG_CHAT_EDITTEXT;

/**
 * Created by Gaojianyang on 18/9/28.
 * github https://github.com/gaojianyang
 */
//public static final int ICON_BOTTOM_PHOTO = 1001;
//public static final int ICON_BOTTOM_VIDEO = 1002;
//public static final int ICON_BOTTOM_VOICE = 1003;
//public static final int ICON_BOTTOM_EMOJI = 1004;
//public static final int ICON_BOTTOM_GAME = 1005;
//public static final int ICON_BOTTOM_MORE = 1006;
//public static final int ICON_BOTTOM_CAMERA = 1007;
//public static final int ICON_EDIT_SEND = 1008;
//public static final int IMG_CHAT_CONTENT = 1016;
//public static final int IMG_CHAT_CONTENT_BOTTOM = 1017;
//public static final int IMG_CHAT_EDITTEXT = 1018;
//public static final int IMG_CHAT_BOTTOM_BAR = 1019;
//public static final int IMG_CHAT_BUBBLE = 1020;
//public static final int IMG_CHAT_BUBBLE_PEER = 1021;
//public static final int IMG_CHAT_DRAWER_SCRIM = 1022;
//
//public static final int TEXT_EDIT_CONTENT = 1023;
//public static final int TEXT_BUBBLE_CONTENT = 1024;
//public static final int TEXT_BUBBLE_CONTENT_PEER = 1025;
public class DefaultTypeDecider implements StyleTypeDecider {
    @Override
    public SkinModuleType getType(int id) {
        SkinModuleType type = SkinModuleType.NORMAL_ICON;
        switch (id) {
            case ICON_BOTTOM_PHOTO:
            case ICON_BOTTOM_VIDEO:
            case ICON_BOTTOM_VOICE:
            case ICON_BOTTOM_EMOJI:
            case ICON_BOTTOM_GAME:
            case ICON_BOTTOM_MORE:
            case ICON_BOTTOM_CAMERA:
                type = SkinModuleType.CHECKABLE_ICON;
                break;
            case ICON_EDIT_SEND:
                type = SkinModuleType.NORMAL_ICON;
                break;
            case IMG_CHAT_CONTENT:
            case IMG_CHAT_CONTENT_BOTTOM:
            case IMG_CHAT_EDITTEXT:
            case IMG_CHAT_BOTTOM_BAR:
                type=SkinModuleType.BACKGROUND;
                break;
            case IMG_CHAT_BUBBLE:
            case IMG_CHAT_BUBBLE_PEER:
                type=SkinModuleType.BUBBLE;
                break;
        }
        return type;
    }
}
