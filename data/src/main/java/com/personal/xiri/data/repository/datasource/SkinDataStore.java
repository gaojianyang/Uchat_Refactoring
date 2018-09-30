package com.personal.xiri.data.repository.datasource;

import com.personal.xiri.data.entity.SkinEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Gaojianyang on 18/9/9.
 * github https://github.com/gaojianyang
 */
public interface SkinDataStore {
    Observable<SkinEntity> getSkinById(long id);
    Observable<List<SkinEntity>> getUserSkinsById(String identifier);
    Observable<List<SkinEntity>> getRecentSkins();
    void createOrUpdateSkin(SkinEntity skinEntity);

}
