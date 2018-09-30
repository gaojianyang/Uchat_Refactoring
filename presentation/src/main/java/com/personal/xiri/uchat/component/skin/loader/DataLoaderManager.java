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
public class DataLoaderManager implements LoaderManager<SkinStyle,DataLoader> {
    private final HashMap<SkinModuleType, DataLoader> dataLoaders;
    private final StyleTypeDecider decider;

    public DataLoaderManager(StyleTypeDecider decider,HashMap<SkinModuleType, DataLoader> dataLoaders) {
    this.decider=decider;
    this.dataLoaders=dataLoaders;
    }

    @Override
    public DataLoader getLoader(SkinStyle style) {
        return dataLoaders.get(decider.getType(style.getId()));
    }
}
