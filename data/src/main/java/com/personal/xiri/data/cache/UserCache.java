package com.personal.xiri.data.cache;

import com.personal.xiri.data.entity.SkinEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by Gaojianyang on 18/9/2.
 * github https://github.com/gaojianyang
 */
public interface UserCache {
    Flowable<SkinEntity> getCurrentUsingSkin(String identifier);
}
