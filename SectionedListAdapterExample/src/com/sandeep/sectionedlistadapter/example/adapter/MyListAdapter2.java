package com.sandeep.sectionedlistadapter.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.List;

import com.sandeep.sectionedlistadapter.SectionedListAdapter;
import com.sandeep.sectionedlistadapter.example.Activity2.TwoLineText;
import com.sandeep.sectionedlistadapter.example.R;


public class MyListAdapter2 extends SectionedListAdapter<String,TwoLineText>
{
    private LayoutInflater mInflater;

    public MyListAdapter2(Context context, LinkedHashMap<String, ? extends List<TwoLineText>> data){
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
        TwoLineText child = (TwoLineText) getItem(position);
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.view_list_item2, null);
        }
        ((TextView) convertView.findViewById(R.id.text_main)).setText(child.getMainText());
        ((TextView) convertView.findViewById(R.id.text_secondary)).setText(child.getSecondaryText());
        return convertView;
    }
}
