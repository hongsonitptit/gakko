package com.example.gakko.activity;

import android.content.Intent;
import android.media.audiofx.NoiseSuppressor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gakko.R;

public class HomeActivity extends ActionBarActivity {

	public static final String SHOW_ACTION = "SHOW ACTION";

	private View mViewActionBar;
	private ImageButton mImageButtonSetting;
	private View mViewLayoutNotifyCity;
	private View mViewLayoutChat;
	private View mViewLayoutSchool;
	private View mViewLayoutAds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setupActionBar();
		setContentView(R.layout.activity_home);
		mViewLayoutNotifyCity = (View) findViewById(R.id.layout_notify_from_city);
		mViewLayoutChat = (View) findViewById(R.id.layout_chat);
		mViewLayoutSchool = (View) findViewById(R.id.layout_notify_from_school);
		mViewLayoutAds = (View) findViewById(R.id.layout_advertise);

		mViewLayoutNotifyCity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						MainActivity.class);
				intent.putExtra(SHOW_ACTION, MainActivity.SHOW_NOTIFY_FROM_CITY);
				startActivity(intent);
			}
		});
		mViewLayoutChat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						MainActivity.class);
				intent.putExtra(SHOW_ACTION, MainActivity.SHOW_CHAT);
				startActivity(intent);
			}
		});
		mViewLayoutSchool.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						MainActivity.class);
				intent.putExtra(SHOW_ACTION,
						MainActivity.SHOW_NOTIFY_FROM_SCHOOL);
				startActivity(intent);
			}
		});
		mViewLayoutAds.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						MainActivity.class);
				intent.putExtra(SHOW_ACTION, MainActivity.SHOW_ADS);
				startActivity(intent);
			}
		});
	}

	private void setupActionBar() {
		ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setDisplayUseLogoEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		mViewActionBar = LayoutInflater.from(this).inflate(
				R.layout.actionbar_layout, null);
		mActionBar.setCustomView(mViewActionBar);
		mActionBar.setDisplayShowCustomEnabled(true);

		ImageButton rightImageButton = (ImageButton) mViewActionBar
				.findViewById(R.id.btn_right_action_bar);

		ImageButton leftImageButton = (ImageButton) mViewActionBar
				.findViewById(R.id.btn_left_action_bar);
		TextView titleTextView = (TextView) mViewActionBar
				.findViewById(R.id.tv_title_action_bar);

		titleTextView.setText("LOGO (Necol+)");
		rightImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,
						SettingActivity.class);
				startActivity(intent);
			}
		});

	}
}
