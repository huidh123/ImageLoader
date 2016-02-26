package com.icephone.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.icephone.BitmapLoader.BitmapLoader;
import com.icephone.BitmapLoader.BitmapLoaderConfig;
import com.icephone.BitmapLoader.BitmapUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Bitmap tempBMP;
    private GridView grid;
    private BitmapLoader bitmapLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitmapLoader = new BitmapLoader(this);
        grid = (GridView) findViewById(R.id.grid);
        GridAdapter gridAdapter = new GridAdapter(getTestPic());
        grid.setAdapter(gridAdapter);
    }

    class GridAdapter extends BaseAdapter{
        private ArrayList<String> bmpList;

        public GridAdapter(ArrayList<String> bmpList){
            this.bmpList = bmpList;
        }

        @Override
        public int getCount() {
            return bmpList.size();
        }

        @Override
        public Object getItem(int position) {
            return bmpList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
            {
                convertView = MainActivity.this.getLayoutInflater().inflate(
                        R.layout.item_bitmap, parent, false);
            }
            ImageView imageview = (ImageView) convertView
                    .findViewById(R.id.id_img);
            imageview.setImageResource(R.mipmap.ic_launcher);
            bitmapLoader.loadBitmap(bmpList.get(position), imageview);
            return convertView;
        }
    }

    public ArrayList<String> getTestPic(){
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("http://pica.nipic.com/2007-11-09/200711912453162_2.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-001.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-002.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-003.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-004.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-005.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-006.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-007.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-008.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-009.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-010.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-011.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-012.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-013.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-014.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-005.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-006.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-007.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-008.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-009.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-010.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-011.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-012.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-013.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-014.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-005.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-006.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-007.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-008.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-009.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-010.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-011.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-012.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-013.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-014.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-005.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-006.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-007.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-008.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-009.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-010.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-011.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-012.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-013.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-014.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-005.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-006.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-007.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-008.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-009.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-010.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-011.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-012.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-013.jpg");
        arrayList.add("http://img.ivsky.com/img/tupian/pre/201511/19/ghost_city-014.jpg");
        return arrayList;
    }
}

