package com.personal.xiri.uchat.component.skin.loader;

import android.graphics.drawable.Drawable;

import com.personal.xiri.uchat.component.skin.model.IconLoadData;
import com.personal.xiri.uchat.component.skin.view.USkinCheckableDrawable;

import io.reactivex.Observable;

/**
 * Created by Gaojianyang on 18/9/30.
 * github https://github.com/gaojianyang
 */
public class IconParseDataLoader implements DataLoader<IconLoadData,Drawable> {
    @Override
    public Observable<Drawable> dataLoad(Observable<IconLoadData> data) {
        return data.map(iconLoadData -> buildDrawable(iconLoadData));
    }
    private USkinCheckableDrawable buildDrawable(IconLoadData data) {
        return new USkinCheckableDrawable.Builder()
                .setIconType(data.iconType)
                .setBitmap(data.bitmap)
                .setCheckedBitmap(data.checkedBitmap)
                .setColor(data.color)
                .setCheckedColor(data.checkedColor)
                .setTextSize(data.testSize)
                .setTextString(data.textString)
                .build();
    }
}
