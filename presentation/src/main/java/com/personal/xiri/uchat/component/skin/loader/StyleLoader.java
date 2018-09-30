package com.personal.xiri.uchat.component.skin.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.personal.xiri.uchat.component.skin.model.IconStyle;
import com.personal.xiri.uchat.component.skin.model.ImageStyle;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;

import io.reactivex.Observable;

/**
 * Created by Gaojianyang on 18/9/25.
 * github https://github.com/gaojianyang
 */
public interface StyleLoader<M extends SkinStyle,T> {
    Observable<T> loadStyle(M style);

}
