package com.sandeep.sectionedlistadapter.example;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import com.sandeep.sectionedlistadapter.example.adapter.MyListAdapter3;


public class Activity3 extends Activity
{

    ListView mListView;
    LinkedHashMap<String, ArrayList<BitMapInfo>> mData;
    MyListAdapter3 mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        mListView = (ListView) findViewById(R.id.listView);

        addMoreItemsToList();
        mListView.setAdapter(mAdapter);

        Button addMoreItemsButton = (Button) findViewById(R.id.addMoreItemsButton);
        addMoreItemsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addMoreItemsToList();
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void addMoreItemsToList()
    {
        if (mData == null)
        {
            mData = new LinkedHashMap<String, ArrayList<BitMapInfo>>();
        }

        for (int i = 0; i < 30; i++)
        {
            String sectionName = "Section-" + (i + 1);
            ArrayList<BitMapInfo> children = mData.get(sectionName);
            if (children == null)
            {
                children = new ArrayList<BitMapInfo>();
            }
            for (int j = 0; j < 5; j++)
            {
                children.add(new BitMapInfo());
            }
            mData.put(sectionName, children);
        }

        if (mAdapter == null)
        {
            mAdapter = new MyListAdapter3(this, mData);
        }
        else
        {
            mAdapter.setData(mData);
        }
    }

    public class BitMapInfo
    {
        String mBitmapName;
        Bitmap mBitmap;

        public BitMapInfo()
        {
            mBitmapName = String.valueOf(String.valueOf(new Date().getTime()));
            mBitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_menu_save);
        }

        public Bitmap getBitmap()
        {
            return mBitmap;
        }

        @Override
        public String toString()
        {
            return mBitmapName;
        }
    }

}
