package com.personal.xiri.uchat.component;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by Gaojianyang on 18/9/25.
 * github https://github.com/gaojianyang
 */
public interface ImageLoader {
    Bitmap loadUrl(String url, Context applicationContext)throws Exception;
    Bitmap loadUrl(int id, Context applicationContext)throws Exception;
}
