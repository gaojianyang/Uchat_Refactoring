package com.personal.xiri.uchat.component.skin;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by Gaojianyang on 18/9/25.
 * github https://github.com/gaojianyang
 */
public class PathManager {

    public static final String PATH_ICON = "u/skin/icon";
    public static final String PATH_IMG = "u/skin/img";
    private Context context;

    public PathManager(Context context) {
        this.context = context;
    }

    public String getBaseSavePath(String basePath) {
        String cachePath = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalFilesDir(null).getPath() + File.separator + basePath + File.separator;
        } else {
            cachePath = context.getFilesDir().getPath() + File.separator + basePath + File.separator;
        }
        File file = new File(cachePath);
        if (file == null || !file.exists()) {
            file.mkdirs();
        }
        return cachePath;
    }

    public String getPathIcon(String iconId) {
        return getBaseSavePath(PATH_ICON) + File.separator + iconId;
    }

    public String getPathImg(String iconId) {
        return getBaseSavePath(PATH_IMG) + File.separator + iconId;
    }


}
