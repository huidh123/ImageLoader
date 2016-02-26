package com.icephone.BitmapLoader;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by 晨晖 on 2016-02-26.
 */
public class BitmapLoaderConfig {

    /**
     * 线程池中线程数量
     */
    public int MAX_THREAD_POOL_NUM = 20;
    /**
     * 最大加载线程数量
     */
    public int MAX_WORKING_THREAD_NUM = 5;

    /**
     * 缓存文件夹地址
     */
    public String DISK_CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() +"/BitmapCache/";
}
