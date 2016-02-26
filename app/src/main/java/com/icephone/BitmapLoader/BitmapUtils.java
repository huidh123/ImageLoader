package com.icephone.BitmapLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 晨晖 on 2016-02-26.
 */
public class BitmapUtils {
    /**
     * 从网络加载一张图片
     * @param url
     * @return
     */
    public static Bitmap getBitmapFromNet(String url){
        InputStream fin = null;
        HttpURLConnection httpConn = null;
        Bitmap resBMP = null;
        try {
            URL bitmapUrl = new URL(url);
            httpConn = (HttpURLConnection) bitmapUrl.openConnection();
            fin = httpConn.getInputStream();
            resBMP = BitmapFactory.decodeStream(fin);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fin != null){
                    fin.close();
                }
                if(httpConn != null){
                    httpConn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resBMP;
    }

    public static Bitmap getBitmapFromDisk(String path , String fileName){
        return BitmapFactory.decodeFile(path +fileName);
    }

    public static void saveBitmap(Bitmap saveBMP,String path,String filename){
        File saveDirs = new File(path);
        if(!saveDirs.exists()){
            boolean res = saveDirs.mkdirs();
        }

        File file = new File(saveDirs.getAbsolutePath()+filename);
        if(file.exists()){
            file.delete();
            Log.e("tag","删除文件:");
        }
        FileOutputStream fos = null;
        try {
            //创建文件
            boolean createRes = file.createNewFile();
            Log.e("tag","创建文件："+file.getAbsolutePath() + "结果："+createRes);
            fos = new FileOutputStream(file);
            saveBMP.compress(Bitmap.CompressFormat.PNG , 100 , fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos!= null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
