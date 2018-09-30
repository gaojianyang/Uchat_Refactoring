package com.personal.xiri.uchat.component.skin.target;

import android.view.View;

import com.personal.xiri.uchat.component.skin.callback.LoadCallBack;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Gaojianyang on 18/9/29.
 * github https://github.com/gaojianyang
 */
public interface TargetFactory<R extends View,T> {

    DisposableObserver<T> buildTarget(R r);
    DisposableObserver<T> buildTarget(R r, LoadCallBack loadCallBack);
}
