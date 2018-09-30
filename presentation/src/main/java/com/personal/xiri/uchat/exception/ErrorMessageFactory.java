package com.personal.xiri.uchat.exception;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.personal.xiri.uchat.R;

/**
 * Created by Gaojianyang on 18/9/13.
 * github https://github.com/gaojianyang
 */
public class ErrorMessageFactory {
    private static final String TAG = "ErrorMessageFactory";
    private ErrorMessageFactory() {
        //empty
    }
    /**
     * Creates a String representing an error message.
     *
     * @param context   Context needed to retrieve string resources.
     * @param exception An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public static String create(Context context, Exception exception) {
        if (!TextUtils.isEmpty(exception.getMessage())) {
            Log.e(TAG, exception.getMessage());
        }
        String message = context.getString(R.string.exception_message_generic);
//        if (exception instanceof NetworkConnectionException) {
//            message = context.getString(R.string.exception_message_no_connection);
//        } else if (exception instanceof NotFoundException) {
//            message = context.getString(R.string.exception_message_not_found);
//        } else if (exception instanceof ResponseException) {
//            message = exception.getMessage();
//        } else if (exception instanceof HttpException) {
//            message = exception.getMessage();
//        }
        return message;
    }
}
