package com.example.gakko.adapter;

import com.example.gakko.R;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class NotifyCityAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mLayoutInflater;

	public NotifyCityAdapter(Context context) {
		mContext = context;
		mLayoutInflater = (LayoutInflater) mContext
				.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = mLayoutInflater.inflate(R.layout.item_city_notify,
				parent, false);
		return rowView;
	}

}
