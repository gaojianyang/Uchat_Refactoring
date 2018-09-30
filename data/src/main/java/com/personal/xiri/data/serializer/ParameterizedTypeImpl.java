package com.personal.xiri.data.serializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Gaojianyang on 18/9/12.
 * github https://github.com/gaojianyang
 */
public class ParameterizedTypeImpl implements ParameterizedType {
    private final Class raw;
    private final Type[] args;

    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }

    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}

