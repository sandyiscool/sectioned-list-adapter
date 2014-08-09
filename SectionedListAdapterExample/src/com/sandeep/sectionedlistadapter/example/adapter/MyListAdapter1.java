package com.sandeep.sectionedlistadapter.example.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.List;

import com.sandeep.sectionedlistadapter.SectionedListAdapter;
import com.sandeep.sectionedlistadapter.example.R;

public class MyListAdapter1 extends SectionedListAdapter<String, String> {
	private LayoutInflater mInflater;
	
	int[] headerColors={Color.BLUE,Color.GREEN,Color.MAGENTA};

	public MyListAdapter1(Context context,
			LinkedHashMap<String, ? extends List<String>> data) {
		super(data);
		mInflater = LayoutInflater.from(context);
	}

	@Override
	protected View getHeaderView(int position, View convertView,
			ViewGroup parent) {
		String header = (String) getItem(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.view_header, null);
		}
		TextView txtView=(TextView) convertView.findViewById(R.id.text_main);
		txtView.setText(header.toString());
		txtView.setBackgroundColor(headerColors[position%headerColors.length]);
		return convertView;
	}

	@Override
	protected View getChildView(int position, View convertView, ViewGroup parent) {
		String child = (String) getItem(position);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.view_list_item1, null);
		}
		((TextView) convertView.findViewById(R.id.text_main)).setText(child
				.toString());
		return convertView;
	}
}
