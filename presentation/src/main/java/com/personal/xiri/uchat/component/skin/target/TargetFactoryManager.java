package com.personal.xiri.uchat.component.skin.target;

import com.personal.xiri.uchat.component.skin.LoaderManager;
import com.personal.xiri.uchat.component.skin.model.SkinModuleType;
import com.personal.xiri.uchat.component.skin.model.SkinStyle;
import com.personal.xiri.uchat.component.skin.model.TargetType;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Created by Gaojianyang on 18/9/29.
 * github https://github.com/gaojianyang
 */
public class TargetFactoryManager implements LoaderManager<SkinStyle,TargetFactory> {
    private HashMap<TargetType, TargetFactory> targetFactorys;
    private TargetTypeDecider targetDecider;

    public TargetFactoryManager(HashMap<TargetType, TargetFactory> targetFactorys, TargetTypeDecider targetDecider) {
        this.targetFactorys = targetFactorys;
        this.targetDecider = targetDecider;
    }

//    TargetFactory getTargetFactory(SkinStyle style) {
//        return targetFactorys.get(targetDecider.getType(style.getId()));
//    }

    @Override
    public TargetFactory getLoader(SkinStyle style) {
        return targetFactorys.get(targetDecider.getType(style.getId()));
    }
}
