package com.personal.xiri.uchat.component.skin.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;

import com.personal.xiri.uchat.util.ConvertUtils;

/**
 * Created by Gaojianyang on 18/9/15.
 * github https://github.com/gaojianyang
 */
public class USkinCheckableDrawable extends Drawable {
    private int color;
    private int checkedColor;
    private PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
    private Bitmap bitmap;
    private Bitmap checkedBitmap;
    private IconType iconType;
    private String textString;
    private int textSize;

    private int mWidth;
    private int mHeight;
    private Paint mPaint;

    private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);

    //    private boolean isCheck;
    //    private int offsetWidth;
//    private int offsetHeight;
    private Builder builder;

    public USkinCheckableDrawable(Builder builder) {
        this.builder = builder;
        apply(builder);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        switch (iconType) {
            case DEF:
            case IMG:
            case IMG_DOUBLE:
                if (judgeIsCheck(getState())) {
                    drawCheckedBitmap(canvas);
                } else {
                    drawBitmap(canvas);
                }
                break;
            case TXT:
                if (judgeIsCheck(getState())) {
                    drawText(canvas,checkedColor);
                }else{
                    drawText(canvas,color);
                }

                break;


        }
    }

    private void drawCheckedBitmap(Canvas canvas) {
        if (checkedBitmap != null) {
            getPaint().setColorFilter(null);
            canvas.drawBitmap(checkedBitmap, null, getBitmapRect(checkedBitmap), getPaint());
        } else if (bitmap != null) {
            if (checkedColor != Color.TRANSPARENT)
                getPaint().setColorFilter(getColorFilter(checkedColor, mode));
            canvas.drawBitmap(checkedBitmap, null, getBitmapRect(bitmap), getPaint());
        }
    }

    private void drawBitmap(Canvas canvas) {
        if (bitmap != null) {
            if (color != Color.TRANSPARENT)
                getPaint().setColorFilter(getColorFilter(color, mode));
            canvas.drawBitmap(checkedBitmap, null, getBitmapRect(bitmap), getPaint());
        }
    }

    private void drawText(Canvas canvas,int color) {
        if(TextUtils.isEmpty(textString)) return;
        getPaint().setTextSize(ConvertUtils.dp2px(textSize));
        Paint.FontMetricsInt fontMetrics = getPaint().getFontMetricsInt();
        int baseLine = (int) ((mHeight - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top);
        Rect bounds = new Rect();
        getPaint().getTextBounds(textString, 0, textString.length(), bounds);
        if (color != Color.TRANSPARENT)
            getPaint().setColorFilter(getColorFilter(color, PorterDuff.Mode.SRC_IN));
        canvas.drawText(textString,(mWidth  - bounds.width()) / 2 ,baseLine,getPaint());
    }

    @Override
    public void setAlpha(int alpha) {
        getPaint().setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mWidth = bounds.width();
        mHeight = bounds.height();
    }

    @Override
    protected boolean onStateChange(int[] state) {
        invalidateSelf();
        return true;
    }

    private boolean judgeIsCheck(int[] state) {
        for (int i = 0; i < state.length; i++) {
            if (state[i] == android.R.attr.state_checked || state[i] == android.R.attr.state_pressed) {
                return true;
            }
        }
        return false;
    }

    private PorterDuffColorFilter getColorFilter(int color, PorterDuff.Mode mode) {
        PorterDuffColorFilter mTintFilter = COLOR_FILTER_CACHE.get(color, mode);
        if (mTintFilter == null) {
            mTintFilter = new PorterDuffColorFilter(color, mode);
            COLOR_FILTER_CACHE.put(color, mode, mTintFilter);
        }
        return mTintFilter;
    }

    private Rect getBitmapRect(Bitmap bitmap) {
        float scaleX = bitmap.getWidth() * 1.0f / mWidth;
        float scaleY = bitmap.getHeight() * 1.0f / mHeight;
        float scale = Math.max(scaleX, scaleY);
        return new Rect(0, 0, (int) (bitmap.getWidth() * 1.0f / scale)
                , (int) (bitmap.getHeight() * 1.0f / scale));
    }

    public void apply(Builder builder) {
        if (builder == null) throw new NullPointerException("builder cant be null");
        color = builder.color;
        checkedColor = builder.checkedColor;
        bitmap = builder.bitmap;
        checkedBitmap = builder.checkedBitmap;
        iconType = builder.iconType;
        textString = builder.textString;
        textSize = builder.textSize;
        invalidateSelf();
    }


    public Paint getPaint() {
        if (mPaint == null) {
            mPaint = new Paint();

        }
        return mPaint;
    }
    public static class Builder {
        private int color;
        private int checkedColor;
        private Bitmap bitmap;
        private Bitmap checkedBitmap;
        private IconType iconType;
        private String textString;
        private int textSize;

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }

        public Builder setCheckedColor(int checkedColor) {
            this.checkedColor = checkedColor;
            return this;
        }


        public Builder setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public Builder setCheckedBitmap(Bitmap checkedBitmap) {
            this.checkedBitmap = checkedBitmap;
            return this;
        }

        public Builder setIconType(IconType iconType) {
            this.iconType = iconType;
            return this;
        }

        public Builder setTextString(String textString) {
            this.textString = textString;
            return this;
        }

        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public USkinCheckableDrawable build() {
            return new USkinCheckableDrawable(this);
        }
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {

        public ColorFilterLruCache(int maxSize) {
            super(maxSize);
        }

        PorterDuffColorFilter get(int color, PorterDuff.Mode mode) {
            return get(generateCacheKey(color, mode));
        }

        PorterDuffColorFilter put(int color, PorterDuff.Mode mode, PorterDuffColorFilter filter) {
            return put(generateCacheKey(color, mode), filter);
        }

        private static int generateCacheKey(int color, PorterDuff.Mode mode) {
            int hashCode = 1;
            hashCode = 31 * hashCode + color;
            hashCode = 31 * hashCode + mode.hashCode();
            return hashCode;
        }
    }

}
