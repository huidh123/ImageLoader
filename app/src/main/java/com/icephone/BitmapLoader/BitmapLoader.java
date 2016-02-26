package com.icephone.BitmapLoader;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 晨晖 on 2016-02-26.
 */
public class BitmapLoader {

    protected BitmapLoaderConfig mLoadConfig;
    protected ExecutorService mThreadPool;
    //任务栈，后添加入的任务会优先加载
    protected List<BMPLoadThread> mRunnableStack;
    protected Semaphore mThreadLock;
    protected Context context;

    protected Handler handler = new Handler();

    public BitmapLoader(Context context){
        this.context = context.getApplicationContext();

        mLoadConfig = new BitmapLoaderConfig();
        mThreadLock = new Semaphore(mLoadConfig.MAX_WORKING_THREAD_NUM);
        mThreadPool = Executors.newFixedThreadPool(mLoadConfig.MAX_THREAD_POOL_NUM);

        mRunnableStack=  new LinkedList<>();
        //开启任务管理线程
        TaskManagerThread taskManagerThread = new TaskManagerThread();
        taskManagerThread.start();

    }

    /**
     * 加载一个Bitmap到ImageView上面
     * @param url BItmap加载地址
     * @param imageview 需要设置Bitmap的ImageView
     */
    public void loadBitmap(String url , ImageView imageview){
        //保存ImageView信息
        String randomImageTag = UUID.randomUUID().toString();
        ImageViewManager.getInstance().addImageView(randomImageTag, imageview);
        IBitmapTask bitmapLoadTask = new LoadTask(url);
        BMPLoadThread bmpLoadThread = new BMPLoadThread(this,randomImageTag,bitmapLoadTask);
        mRunnableStack.add(bmpLoadThread);
    }

    /**
     * 获取加载任务,LIFO
     * @return
     */
    public BMPLoadThread getLoadThread(){
        if(mRunnableStack == null || mRunnableStack.size() ==0){
            return null;
        }
        return this.mRunnableStack.remove(mRunnableStack.size() - 1);
    }

    /**
     * 任务管理线程，判断当前任务数量，若可以加载任务则将获取线程池中线程执行任务
     */
    class TaskManagerThread extends Thread{
        @Override
        public void run() {
            super.run();
            //开始循环读取任务
            while(true){
                try {
                    //获取刚刚添加的图片加载任务
                    BMPLoadThread tempLoadThread = getLoadThread();
                    //如果存在任务
                    if(tempLoadThread != null){
                        //获取信号量，否则阻塞
                        mThreadLock.acquire();
                        mThreadPool.execute(tempLoadThread);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
