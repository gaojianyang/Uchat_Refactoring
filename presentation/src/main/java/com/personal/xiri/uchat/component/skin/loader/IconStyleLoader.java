package com.personal.xiri.uchat.component.skin.loader;

import android.content.Context;
import android.graphics.Color;

import com.personal.xiri.uchat.component.ImageLoader;
import com.personal.xiri.uchat.component.skin.DefaultSkinStyleManager;
import com.personal.xiri.uchat.component.skin.PathManager;
import com.personal.xiri.uchat.component.skin.loader.StyleLoader;
import com.personal.xiri.uchat.component.skin.model.IconLoadData;
import com.personal.xiri.uchat.component.skin.model.IconStyle;
import com.personal.xiri.uchat.component.skin.view.IconType;

import io.reactivex.Observable;

/**
 * Created by Gaojianyang on 18/9/28.
 * github https://github.com/gaojianyang
 */
public class IconStyleLoader implements StyleLoader<IconStyle,IconLoadData> {
    private ImageLoader loader;
    private DefaultSkinStyleManager defManager;
    private PathManager pathManager;
    private Context context;
    public IconStyleLoader(ImageLoader imageLoader, DefaultSkinStyleManager defaultSkinStyleManager, PathManager pathManager, Context context) {
        loader = imageLoader;
        defManager = defaultSkinStyleManager;
        this.context = context;
        this.pathManager=pathManager;
    }

    @Override
    public Observable<IconLoadData> loadStyle(IconStyle style) {

        if (style == null) return Observable.error(new NullPointerException());
        Observable<IconLoadData> observable = null;
        IconLoadData parseData = new IconLoadData();
        switch (style.getIconType()) {
            case DEF:
                observable =getDefObservable(style,parseData);
                break;
            case IMG:
                observable =getImgObservable(style,parseData);
                break;
            case IMG_DOUBLE:
                observable =getImgDoubleObservable(style,parseData);
                break;
            case TXT:
                observable =getTxtObservable(style,parseData);
                break;
        }
        return observable;

    }
    private Observable<IconLoadData> getDefObservable(IconStyle style, IconLoadData parseData){
        return Observable.create(emitter -> {
            int id = defManager.getDefImgIdFromStyleId(style.getId());
            if (id == DefaultSkinStyleManager.ERROR)
                emitter.onError(new IllegalStateException());
            parseData.bitmap = loader.loadUrl(id, context);
            parseData.color = Color.parseColor(style.getColor());
            parseData.checkedColor = Color.parseColor(style.getCheckedColor());
            parseData.iconType = IconType.DEF;
            emitter.onNext(parseData);
        });
    }
    private Observable<IconLoadData> getImgObservable(IconStyle style, IconLoadData parseData){
        return Observable.create(emitter -> {
            parseData.bitmap = loader.loadUrl(pathManager.getPathIcon(style.getImgId()), context);
            parseData.checkedColor = Color.parseColor(style.getCheckedColor());
            parseData.iconType = IconType.IMG;
            emitter.onNext(parseData);
        });
    }
    private Observable<IconLoadData> getImgDoubleObservable(IconStyle style, IconLoadData parseData){
        return Observable.create(emitter -> {
            parseData.bitmap = loader.loadUrl(pathManager.getPathIcon(style.getImgId()), context);
            parseData.checkedBitmap = loader.loadUrl(pathManager.getPathIcon(style.getCheckedImgId()), context);
            parseData.iconType = IconType.IMG_DOUBLE;
            emitter.onNext(parseData);
        });
    }
    private Observable<IconLoadData> getTxtObservable(IconStyle style, IconLoadData parseData){
        return Observable.create(emitter -> {
            parseData.color = Color.parseColor(style.getColor());
            parseData.checkedColor = Color.parseColor(style.getCheckedColor());
            parseData.iconType = IconType.TXT;
            parseData.testSize=style.getTextSize();
            parseData.textString= style.getTextString();
            emitter.onNext(parseData);
        });
    }
}
