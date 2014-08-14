package com.example.gakko.fragment;

import com.example.gakko.R;
import com.example.gakko.activity.MainActivity;
import com.example.gakko.adapter.NotifyCityAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class NotifySchoolFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_notify_school,
				container, false);

		ListView listView = (ListView) rootView
				.findViewById(R.id.lv_notify_school);
		NotifyCityAdapter notifyCityAdapter = new NotifyCityAdapter(
				getActivity());
		listView.setAdapter(notifyCityAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				((MainActivity) getActivity()).showDetailNotifySchool();
			}
		});

		return rootView;
	}
}
