package com.personal.xiri.uchat.component.skin.interpreter;

import android.view.View;

import com.personal.xiri.uchat.component.skin.USkin;
import com.personal.xiri.uchat.component.skin.callback.LoadCallBack;
import com.personal.xiri.uchat.component.skin.loader.DataLoader;
import com.personal.xiri.uchat.component.skin.loader.StyleLoader;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;
import com.personal.xiri.uchat.component.skin.target.TargetFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Gaojianyang on 18/9/28.
 * github https://github.com/gaojianyang
 */
public class StyleInterpreterBuilder {
    private View targetView;
    private boolean ifErrorUseDefault = true;
    private StyleLoader styleLoader;
    private DataLoader dataLoader;
    private TargetFactory targetFactory;
    private DisposableObserver lastDisposableObserver;
    private LoadCallBack callBack;

    public StyleInterpreterBuilder( View targetView) {

        this.targetView = targetView;
    }

    public StyleInterpreterBuilder load(SkinStyle style) {
        if (styleLoader == null)
            styleLoader = USkin.getStyleLoader(style);
        if (dataLoader == null)
            dataLoader = USkin.getDataLoader(style);
        if (lastDisposableObserver != null && !lastDisposableObserver.isDisposed()) {
            lastDisposableObserver.dispose();
        }
        if (targetFactory == null)
            targetFactory = USkin.getTargetFactory(style);
        DisposableObserver observer = null;
        if (ifErrorUseDefault) {
            observer = targetFactory.buildTarget(targetView);
        }else {
            observer=targetFactory.buildTarget(targetView,new DefCallBack(style.getId()));
        }

        lastDisposableObserver = observer;
        USkin.addDisposable((Disposable) (dataLoader.dataLoad(styleLoader.loadStyle(style).subscribeOn(Schedulers.io())).observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer)));
        return this;
    }


    public StyleInterpreterBuilder reLoad(SkinStyle style) {
        return load(style);
    }

    public StyleInterpreterBuilder ifErrorUseDefault(boolean ifErrorUseDefault) {
        this.ifErrorUseDefault = ifErrorUseDefault;
        return this;
    }

    private class DefCallBack implements LoadCallBack {
        private int styleId;

        public DefCallBack(int styleId){
            this.styleId=styleId;
        }
        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable e) {
            ifErrorUseDefault=false;
           SkinStyle skinStyle= USkin.getDefaultStyle(styleId);
           if(skinStyle!=null) reLoad(skinStyle);
        }
    }


}
