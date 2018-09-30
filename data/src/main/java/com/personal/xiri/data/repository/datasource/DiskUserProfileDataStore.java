package com.personal.xiri.data.repository.datasource;

import com.personal.xiri.data.entity.UserProfileEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Gaojianyang on 18/9/15.
 * github https://github.com/gaojianyang
 */
public class DiskUserProfileDataStore implements UserProfileDataStore {

    public DiskUserProfileDataStore() {
    }

    @Override
    public Observable<UserProfileEntity> getUserProfileFromId(String identifier) {
        return null;
    }

    @Override
    public Observable<List<UserProfileEntity>> getUserFriendsProfileFromId(String identifier) {
        return null;
    }
}
