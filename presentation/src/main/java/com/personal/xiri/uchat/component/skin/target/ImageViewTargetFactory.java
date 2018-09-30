package com.personal.xiri.uchat.component.skin.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.personal.xiri.uchat.component.skin.callback.LoadCallBack;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Gaojianyang on 18/9/29.
 * github https://github.com/gaojianyang
 */
public class ImageViewTargetFactory implements TargetFactory<ImageView,Drawable> {
    @Override
    public DisposableObserver<Drawable> buildTarget(ImageView imageView) {
        return new ImageViewTarget(imageView);
    }

    @Override
    public DisposableObserver<Drawable> buildTarget(ImageView imageView, LoadCallBack loadCallBack) {
        return null;
    }
}
