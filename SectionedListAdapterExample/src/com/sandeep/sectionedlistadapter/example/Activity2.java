package com.sandeep.sectionedlistadapter.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sandeep.sectionedlistadapter.example.adapter.MyListAdapter2;


public class Activity2 extends Activity
{

    ListView mListView;
    LinkedHashMap<String, ArrayList<TwoLineText>> mData;
    MyListAdapter2 mAdapter;

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
            mData = new LinkedHashMap<String, ArrayList<TwoLineText>>();
        }

        for (int i = 0; i < 30; i++)
        {
            String sectionName = "Section-" + (i + 1);
            ArrayList<TwoLineText> children = mData.get(sectionName);
            if (children == null)
            {
                children = new ArrayList<TwoLineText>();
            }
            for (int j = 0; j < 5; j++)
            {
                children.add(new TwoLineText());
            }
            mData.put(sectionName, children);
        }

        if (mAdapter == null)
        {
            mAdapter = new MyListAdapter2(this, mData);
        }
        else
        {
            mAdapter.setData(mData);
        }
    }

    public class TwoLineText
    {
        String mMainText;
        String mSecondaryText;

        public TwoLineText()
        {
        	mMainText = "Main Text or Title";
        	mSecondaryText = "Secondary Text. Can be a caption or brief description,etc";
        }

        public String getMainText()
        {
            return mMainText;
        }
        
        public String getSecondaryText()
        {
            return mSecondaryText;
        }
    }

}
