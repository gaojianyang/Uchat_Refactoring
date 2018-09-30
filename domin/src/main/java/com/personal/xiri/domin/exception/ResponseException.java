package com.personal.xiri.domin.exception;


import com.personal.xiri.domin.Response;

/**
 * Created by Gaojianyang on 18/9/13.
 * github https://github.com/gaojianyang
 */
public class ResponseException extends Exception {
    private Response response;
    public static final int STATUS_CODE_SUCCESS=0;

    public ResponseException(Response response) {
        super();
        this.response = response;
    }
}
