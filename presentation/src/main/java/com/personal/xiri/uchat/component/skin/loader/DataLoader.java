package com.personal.xiri.uchat.component.skin.loader;


import io.reactivex.Observable;

/**
 * Created by Gaojianyang on 18/9/28.
 * github https://github.com/gaojianyang
 */
public interface DataLoader<T,V> {
    Observable<V> dataLoad(Observable<T> data);
}
