package com.icephone.BitmapLoader;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by 晨晖 on 2016-02-26.
 */
public class LoadTask implements IBitmapTask {

    private String mBitMapUrl;

    public LoadTask(String url){
        this.mBitMapUrl = url;
    }
    @Override
    public Bitmap getBitmap() {
        return BitmapUtils.getBitmapFromNet(mBitMapUrl);
    }
}
