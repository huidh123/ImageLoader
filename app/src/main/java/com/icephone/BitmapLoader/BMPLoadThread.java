package com.icephone.BitmapLoader;

import android.content.AbstractThreadedSyncAdapter;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import java.util.concurrent.Semaphore;

/**
 * 进行Bitmap加载的线程，可以通过传入不同的IBitmapTask来加载图片
 * Created by 晨晖 on 2016-02-26.
 */
public class BMPLoadThread implements Runnable {

    private BitmapLoader mBitmapLoader;
    private IBitmapTask mLoadTask;
    private String imageViewTag;

    public BMPLoadThread(BitmapLoader mBitMapLoader ,String imageViewTag, IBitmapTask mLoadTask){
        this.mBitmapLoader = mBitMapLoader;
        this.mLoadTask = mLoadTask;
        this.imageViewTag = imageViewTag;
    }

    @Override
    public void run() {
        //执行加载任务
        final Bitmap loadedBitmap = mLoadTask.getBitmap();
        mBitmapLoader.handler.post(new Runnable() {
            @Override
            public void run() {
                ImageView imageView = ImageViewManager.getInstance().getImageView(imageViewTag);
                if(imageView!= null && imageView.isShown()){
                    imageView.setImageBitmap(loadedBitmap);
                }
            }
        });
        mBitmapLoader.mThreadLock.release();
    }


}
