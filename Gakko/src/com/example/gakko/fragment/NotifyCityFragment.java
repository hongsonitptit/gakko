package com.example.gakko.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.gakko.R;
import com.example.gakko.activity.MainActivity;
import com.example.gakko.adapter.NotifyCityAdapter;

public class NotifyCityFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_notify_city,
				container, false);
		ListView listView = (ListView) rootView
				.findViewById(R.id.lv_notify_city);
		NotifyCityAdapter notifyCityAdapter = new NotifyCityAdapter(
				getActivity());
		listView.setAdapter(notifyCityAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				((MainActivity) getActivity()).showDetailNotifyCity();
			}
		});

		return rootView;
	}
}
