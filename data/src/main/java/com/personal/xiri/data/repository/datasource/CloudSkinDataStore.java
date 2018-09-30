package com.personal.xiri.data.repository.datasource;

import com.personal.xiri.data.entity.SkinEntity;
import com.personal.xiri.data.net.ResponseErrorFunc;
import com.personal.xiri.data.net.SkinApi;
import com.personal.xiri.domin.Response;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by Gaojianyang on 18/9/9.
 * github https://github.com/gaojianyang
 */
public class CloudSkinDataStore implements SkinDataStore {
    private SkinApi skinApi;

    public CloudSkinDataStore(SkinApi skinApi) {
        this.skinApi = skinApi;
    }

    @Override
    public Observable<SkinEntity> getSkinById(long id) {
        return null;
    }

    @Override
    public Observable<List<SkinEntity>> getUserSkinsById(String identifier) {
        return null;
    }

    @Override
    public Observable<List<SkinEntity>> getRecentSkins() {
        return skinApi.getRecentSkins().map(new ResponseErrorFunc<>());
    }

    @Override
    public void createOrUpdateSkin(SkinEntity skinEntity) {
    }
}
