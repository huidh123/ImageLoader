package com.icephone.BitmapLoader;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * 获取一个位图图像的任务的接口，这个通常是一个长时间的运行任务
 * Created by 晨晖 on 2016-02-26.
 */
public interface IBitmapTask {
    Bitmap getBitmap();
}
