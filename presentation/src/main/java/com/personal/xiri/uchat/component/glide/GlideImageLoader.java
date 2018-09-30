package com.personal.xiri.uchat.component.glide;


import android.content.Context;
import android.graphics.Bitmap;

import com.personal.xiri.uchat.component.ImageLoader;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

/**
 * Created by Gaojianyang on 18/9/25.
 * github https://github.com/gaojianyang
 */
public class GlideImageLoader implements ImageLoader {
    @Inject
    public GlideImageLoader() {
    }

    @Override
    public Bitmap loadUrl(String url, Context applicationContext) throws Exception {
        return GlideApp.with(applicationContext).asBitmap().load(url).submit().get();
    }

    @Override
    public Bitmap loadUrl(int id, Context applicationContext) throws Exception {
        return GlideApp.with(applicationContext).asBitmap().load(id).submit().get();
    }
}
