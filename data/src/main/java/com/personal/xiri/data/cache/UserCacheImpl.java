package com.personal.xiri.data.cache;

import com.personal.xiri.data.entity.SkinEntity;

import io.reactivex.Flowable;


/**
 * Created by Gaojianyang on 18/9/5.
 * github https://github.com/gaojianyang
 */
public class UserCacheImpl implements UserCache {

    @Override
    public Flowable<SkinEntity> getCurrentUsingSkin(String identifier) {
        return null;
    }
}
