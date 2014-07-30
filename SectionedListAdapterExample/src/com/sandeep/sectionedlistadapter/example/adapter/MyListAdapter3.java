package com.sandeep.sectionedlistadapter.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.List;

import com.sandeep.sectionedlistadapter.SectionedListAdapter;
import com.sandeep.sectionedlistadapter.example.Activity3.BitMapInfo;
import com.sandeep.sectionedlistadapter.example.R;


public class MyListAdapter3 extends SectionedListAdapter<String,BitMapInfo>
{
    private LayoutInflater mInflater;

    public MyListAdapter3(Context context, LinkedHashMap<String, ? extends List<BitMapInfo>> data){
        super(data);
        mInflater= LayoutInflater.from(context);
    }

    @Override
    protected View getHeaderView(int position, View convertView, ViewGroup parent)
    {
        String header = (String) getItem(position);
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.view_header, null);
        }
        ((TextView) convertView.findViewById(R.id.text_main)).setText(header.toString());
        return convertView;
    }

    @Override
    protected View getChildView(int position, View convertView, ViewGroup parent)
    {
    	BitMapInfo child = (BitMapInfo) getItem(position);
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.view_list_item3, null);
        }
        ((TextView) convertView.findViewById(R.id.text_main)).setText(child.toString());
        ((ImageView) convertView.findViewById(R.id.img)).setImageBitmap(child.getBitmap());
        return convertView;
    }
}
