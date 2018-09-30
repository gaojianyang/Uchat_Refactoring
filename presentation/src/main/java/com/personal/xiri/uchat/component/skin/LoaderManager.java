package com.personal.xiri.uchat.component.skin;

/**
 * Created by Gaojianyang on 18/9/28.
 * github https://github.com/gaojianyang
 */
public interface LoaderManager<T,V> {

    public V getLoader(T type);
}
