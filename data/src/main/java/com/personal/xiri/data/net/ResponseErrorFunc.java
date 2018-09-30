package com.personal.xiri.data.net;

import com.personal.xiri.domin.Response;
import com.personal.xiri.domin.exception.ResponseException;

import io.reactivex.functions.Function;

/**
 * Created by Gaojianyang on 18/9/13.
 * github https://github.com/gaojianyang
 */
public class ResponseErrorFunc<T> implements Function<Response<T>,T> {
    @Override
    public T apply(Response<T> response) throws Exception {
        if(response.getStatusCode()!=0){
            throw new ResponseException(response);
        }
        return response.data;
    }
}
