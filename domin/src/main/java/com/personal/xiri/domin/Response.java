package com.personal.xiri.domin;

/**
 * Created by Gaojianyang on 18/9/11.
 * github https://github.com/gaojianyang
 */
public class Response<T> {

    private int statusCode;
    private String statusMsg;
    private long time;

    public T data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
