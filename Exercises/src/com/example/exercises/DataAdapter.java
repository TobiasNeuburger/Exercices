package com.example.exercises;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DataAdapter extends BaseAdapter {
	private List<String> data = new LinkedList<String>();
	private Context context;
	
	public DataAdapter(Context context) {
		this.context = context;
		for (int i = 0; i < 200; i++)
			data.add("Element " + i);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View myView = convertView;
		if (convertView == null) {
			LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			myView = li.inflate(R.layout.listrow, null);
		}
		TextView tv = (TextView) myView.findViewById(R.id.listRow_text);
		tv.setText(this.data.get(position));
		
		return myView;
	}
	
}