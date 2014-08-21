package com.example.gakko.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

import com.example.gakko.R;

public class SettingActivity extends ActionBarActivity {

	private Button mButtonRule;
	private Button mButtonClose;
	private ToggleButton mToggleButtonPush;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setupActionBar();
		setContentView(R.layout.activity_setting);
		mButtonClose = (Button) findViewById(R.id.btn_close_setting);
		mButtonRule = (Button) findViewById(R.id.btn_rule_setting);
		mToggleButtonPush = (ToggleButton) findViewById(R.id.tgbtn_push_notify);

		mButtonClose.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		mButtonRule.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SettingActivity.this,
						RuleActivity.class);
				startActivity(intent);
				finish();
			}
		});

		mToggleButtonPush
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// set check status

					}
				});
	}

	private void setupActionBar() {
		ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setDisplayUseLogoEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		View mViewActionBar = LayoutInflater.from(this).inflate(
				R.layout.actionbar_layout, null);
		mActionBar.setCustomView(mViewActionBar);
		mActionBar.setDisplayShowCustomEnabled(true);

		ImageButton rightImageButton = (ImageButton) mViewActionBar
				.findViewById(R.id.btn_right_action_bar);

		ImageButton leftImageButton = (ImageButton) mViewActionBar
				.findViewById(R.id.btn_left_action_bar);
		TextView titleTextView = (TextView) mViewActionBar
				.findViewById(R.id.tv_title_action_bar);

		titleTextView.setText(getResources().getString(
				R.string.title_setting_screen));
		rightImageButton.setVisibility(View.INVISIBLE);
		leftImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
