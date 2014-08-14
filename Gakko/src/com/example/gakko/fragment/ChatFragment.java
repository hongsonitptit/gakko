package com.example.gakko.fragment;

import com.example.gakko.R;
import com.example.gakko.adapter.RoomAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ChatFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_chat, container,
				false);
		ListView listView = (ListView) rootView.findViewById(R.id.lv_room);
		RoomAdapter roomAdapter = new RoomAdapter(getActivity());
		listView.setAdapter(roomAdapter);
		return rootView;
	}
}
