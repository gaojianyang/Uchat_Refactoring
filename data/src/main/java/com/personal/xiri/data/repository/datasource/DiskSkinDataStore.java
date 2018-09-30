package com.personal.xiri.data.repository.datasource;

import com.personal.xiri.data.entity.SkinEntity;
import com.personal.xiri.data.greendao.DaoSession;
import com.personal.xiri.data.greendao.SkinEntityDao;
import com.personal.xiri.domin.exception.NotFoundException;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Gaojianyang on 18/9/10.
 * github https://github.com/gaojianyang
 */
public class DiskSkinDataStore implements SkinDataStore {
    private DaoSession daoSession;
    private SkinEntityDao skinEntityDao;

    public DiskSkinDataStore(DaoSession daoSession) {
        if (daoSession == null) throw new IllegalArgumentException("Invalid null parameter");
        this.daoSession = daoSession;
        skinEntityDao = daoSession.getSkinEntityDao();

    }

    @Override
    public Observable<SkinEntity> getSkinById(long id) {
        return Observable.create(emitter -> {
            SkinEntity skinEntity = skinEntityDao.queryBuilder().where(SkinEntityDao.Properties.Id.eq(id)).unique();
            if (skinEntity != null) {
                emitter.onNext(skinEntity);
                emitter.onComplete();
            } else {
                emitter.onError(new NotFoundException());
            }
        });
    }

    @Override
    public Observable<List<SkinEntity>> getUserSkinsById(String identifier) {
        return Observable.create(emitter -> {
            List<SkinEntity> skinEntities = skinEntityDao.queryBuilder().where(SkinEntityDao.Properties.Identifier.eq(identifier)).orderAsc(SkinEntityDao.Properties.UpdateDate).list();
            if (skinEntities != null) {
                emitter.onNext(skinEntities);
                emitter.onComplete();
            } else {
                emitter.onError(new NotFoundException());
            }
        });
    }

    @Override
    public Observable<List<SkinEntity>> getRecentSkins() {
        return null;
    }

    @Override
    public void createOrUpdateSkin(SkinEntity skinEntity) {
        skinEntityDao.insertOrReplaceInTx(skinEntity);
    }
}
