package com.personal.xiri.uchat.component.skin.target;

import com.personal.xiri.uchat.component.skin.model.SkinModuleType;
import com.personal.xiri.uchat.component.skin.model.TargetType;

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
 * Created by Gaojianyang on 18/9/29.
 * github https://github.com/gaojianyang
 */
public class DefaultTagetTypeDecider implements TargetTypeDecider {

    @Override
    public TargetType getType(int id) {
        TargetType type = TargetType.ImageView;
        switch (id) {
            case ICON_BOTTOM_PHOTO:
            case ICON_BOTTOM_VIDEO:
            case ICON_BOTTOM_VOICE:
            case ICON_BOTTOM_EMOJI:
            case ICON_BOTTOM_GAME:
            case ICON_BOTTOM_MORE:
            case ICON_BOTTOM_CAMERA:
            case ICON_EDIT_SEND:
                type = TargetType.ImageView;
                break;
            case IMG_CHAT_CONTENT:
            case IMG_CHAT_CONTENT_BOTTOM:
            case IMG_CHAT_EDITTEXT:
            case IMG_CHAT_BOTTOM_BAR:
            case IMG_CHAT_BUBBLE:
            case IMG_CHAT_BUBBLE_PEER:
                type=TargetType.BackGroundView;
                break;
        }
        return type;
    }
}
