package com.personal.xiri.uchat.component.skin;

import android.view.View;

import com.bumptech.glide.Glide;
import com.personal.xiri.uchat.R;
import com.personal.xiri.uchat.component.skin.interpreter.StyleInterpreterBuilder;
import com.personal.xiri.uchat.component.skin.loader.DataLoader;
import com.personal.xiri.uchat.component.skin.loader.DataLoaderManager;
import com.personal.xiri.uchat.component.skin.loader.StyleLoader;
import com.personal.xiri.uchat.component.skin.loader.StyleLoaderManager;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;
import com.personal.xiri.uchat.component.skin.target.TargetFactory;
import com.personal.xiri.uchat.component.skin.target.TargetFactoryManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Gaojianyang on 18/9/15.
 * github https://github.com/gaojianyang
 */
public class USkin {
    private static volatile USkin uSkin;

    private final StyleLoaderManager styleLoaderManager;
    private final DataLoaderManager dataLoaderManager;
    private final TargetFactoryManager targetFactoryManager;
    private final CompositeDisposable disposables;
    private final DefaultSkinStyleManager defSkinStyleManager;

    private USkin(StyleLoaderManager styleLoaderManager, DataLoaderManager dataLoaderManager, TargetFactoryManager targetFactoryManager, DefaultSkinStyleManager defSkinStyleManager) {
        this.styleLoaderManager = styleLoaderManager;
        this.dataLoaderManager = dataLoaderManager;
        this.targetFactoryManager = targetFactoryManager;
        this.disposables = new CompositeDisposable();
        this.defSkinStyleManager = defSkinStyleManager;
    }

    public static void init(StyleLoaderManager styleLoaderManager, DataLoaderManager dataLoaderManager, TargetFactoryManager targetFactoryManager, DefaultSkinStyleManager defSkinStyleManager) {
        if (uSkin == null) {
            synchronized (USkin.class) {
                if (uSkin == null) {
                    uSkin = new USkin(styleLoaderManager, dataLoaderManager, targetFactoryManager, defSkinStyleManager);
                }
            }
        }

    }

    private StyleLoaderManager getStyleLoaderManager() {
        return styleLoaderManager;
    }

    private DataLoaderManager getDataLoaderManager() {
        return dataLoaderManager;
    }

    private TargetFactoryManager getTargetFactoryManager() {
        return targetFactoryManager;
    }

    public CompositeDisposable getDisposables() {
        return disposables;
    }

    private static USkin getUSkin() {
        if (uSkin == null) throw new IllegalStateException("uskin need init");
        return uSkin;
    }

    public static StyleInterpreterBuilder display(View view) {
        return new StyleInterpreterBuilder(view);
    }

    public static StyleLoader getStyleLoader(SkinStyle style) {
        return getUSkin().getStyleLoaderManager().getLoader(style);
    }

    public static DataLoader getDataLoader(SkinStyle style) {
        return getUSkin().getDataLoaderManager().getLoader(style);
    }

    public static TargetFactory getTargetFactory(SkinStyle style) {
        return getUSkin().getTargetFactoryManager().getLoader(style);
    }

    public static SkinStyle getDefaultStyle(int styleId) {
      return getUSkin().getDefSkinStyleManager().getDefSkinStyleProvider(0).getSkinStyleSparseArray().get(styleId);
    }


    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public static void dispose() {
        if (!getUSkin().getDisposables().isDisposed()) {
            getUSkin().getDisposables().dispose();
        }
    }

    public static void addDisposable(Disposable disposable) {
        getUSkin().getDisposables().add(disposable);
    }

    public DefaultSkinStyleManager getDefSkinStyleManager() {
        return defSkinStyleManager;
    }
}
