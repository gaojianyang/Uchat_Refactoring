package com.personal.xiri.uchat.component.skin.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.personal.xiri.uchat.component.skin.callback.LoadCallBack;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Gaojianyang on 18/9/28.
 * github https://github.com/gaojianyang
 */
public class ImageViewTarget extends DisposableObserver<Drawable> {
    private final ImageView imageView;
    private LoadCallBack loadCallBack;

    public ImageViewTarget(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageViewTarget(ImageView imageView, LoadCallBack loadCallBack) {
        this.imageView = imageView;
        this.loadCallBack = loadCallBack;
    }


    @Override
    public void onNext(Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    @Override
    public void onError(Throwable e) {
        if (loadCallBack != null) loadCallBack.onError(e);
    }

    @Override
    public void onComplete() {
        if (loadCallBack != null) loadCallBack.onComplete();

    }
}
