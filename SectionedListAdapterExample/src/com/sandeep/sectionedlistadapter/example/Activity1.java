package com.sandeep.sectionedlistadapter.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sandeep.sectionedlistadapter.example.adapter.MyListAdapter1;


public class Activity1 extends Activity
{

    ListView mListView;
    LinkedHashMap<String,ArrayList<String>> mData;
    MyListAdapter1 mAdapter;

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
            mData =new LinkedHashMap<String, ArrayList<String>>();
        }

        for (int i = 0; i < 30; i++)
        {
            String sectionName = "Section-" + (i + 1);
            ArrayList<String> children= mData.get(sectionName);
            if (children == null)
            {
                children=new ArrayList<String>();
            }
            for (int j = 0; j < 5; j++)
            {
                children.add(new StringBuilder("Item ").append(j).toString());
            }
            mData.put(sectionName, children);
        }

        if (mAdapter == null)
        {
            mAdapter = new MyListAdapter1(this, mData);
        }
        else
        {
            mAdapter.setData(mData);
        }
    }

}
