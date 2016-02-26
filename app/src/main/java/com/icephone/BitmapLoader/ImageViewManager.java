package com.icephone.BitmapLoader;

import android.media.Image;
import android.widget.ImageView;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 晨晖 on 2016-02-26.
 */
public class ImageViewManager {

    private Map<String,SoftReference<ImageView>> mImageMap;

    private static ImageViewManager mInstance;

    private ImageViewManager(){
        mImageMap = new HashMap<>();
    }

    public static ImageViewManager getInstance(){
        if(mInstance == null){
            synchronized (ImageViewManager.class){
                if(mInstance == null){
                    mInstance = new ImageViewManager();
                }
            }
        }
        return mInstance;
    }

    public void addImageView(String imageViewTag,ImageView imageview){
        mImageMap.put(imageViewTag , new SoftReference<ImageView>(imageview));
    }

    public ImageView getImageView(String imageViewTag){
        if(mImageMap.get(imageViewTag) != null){
            return mImageMap.get(imageViewTag).get();
        }
        return null;
    }
}
