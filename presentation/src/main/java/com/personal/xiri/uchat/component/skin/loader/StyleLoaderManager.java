package com.personal.xiri.uchat.component.skin.loader;

import com.personal.xiri.uchat.component.skin.LoaderManager;
import com.personal.xiri.uchat.component.skin.StyleTypeDecider;
import com.personal.xiri.uchat.component.skin.model.SkinModuleType;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;

import java.util.HashMap;

/**
 * Created by Gaojianyang on 18/9/28.
 * github https://github.com/gaojianyang
 */
public class StyleLoaderManager implements LoaderManager<SkinStyle, StyleLoader> {
    private final HashMap<SkinModuleType, StyleLoader> styleLoaders;
    private final StyleTypeDecider decider;

    public StyleLoaderManager(StyleTypeDecider decider,HashMap<SkinModuleType, StyleLoader> styleLoaders) {
        this.decider = decider;
        this.styleLoaders=styleLoaders;
    }

    @Override
    public synchronized StyleLoader getLoader(SkinStyle style) {

        return styleLoaders.get(decider.getType(style.getId()));

    }

}
