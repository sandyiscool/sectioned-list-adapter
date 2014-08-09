package com.sandeep.sectionedlistadapter.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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

        createData();
        mAdapter=new MyListAdapter1(this, mData);
        mListView.setAdapter(mAdapter);
        
        findViewById(R.id.addMoreItemsButton).setVisibility(View.GONE);
    }

    private void createData()
    {
        mData=new LinkedHashMap<String,ArrayList<String>>();
        
        String sectionName;
        ArrayList<String> children;
        
        // 1st section
        sectionName="Animals";
        children=new ArrayList<String>();
        children.add("Cat");
        children.add("Dog");
        children.add("Elephant");
        children.add("Cow");
        mData.put(sectionName, children);
        
        // 2nd section
        sectionName="Birds";
        children=new ArrayList<String>();
        children.add("Parrot");
        children.add("Eagle");
        children.add("Pigeon");
        children.add("Cuckoo");
        mData.put(sectionName, children);
        
        // 3rd section
        sectionName="Insects";
        children=new ArrayList<String>();
        children.add("Spider");
        children.add("Ant");
        children.add("Ladybird");
        children.add("Beetle");
        mData.put(sectionName, children);
        
        // 4th section
        sectionName="Reptiles";
        children=new ArrayList<String>();
        children.add("Crocodile");
        children.add("Lizard");
        children.add("Snake");
        children.add("Alligator");
        children.add("Komodo Dragon");
        mData.put(sectionName, children);
        
        //5th Section
        sectionName="Cars";
        children=new ArrayList<String>();
        children.add("Porsche");
        children.add("BMW");
        children.add("Volkswagen");
        children.add("Mercedez");
        children.add("Ferrari");
        mData.put(sectionName, children);
    }

}
