package com.example.gakko.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.example.gakko.R;

public class RuleActivity extends ActionBarActivity {

	private TextView mTextViewNext;
	private CheckBox mCheckBoxRule;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setupActionBar();
		setContentView(R.layout.activity_rule);
		mTextViewNext = (TextView) findViewById(R.id.tv_next_rule);
		mCheckBoxRule = (CheckBox) findViewById(R.id.cb_rule);
		mTextViewNext.setEnabled(false);
		mTextViewNext.setTextColor(Color.GRAY);
		mCheckBoxRule.setChecked(false);
		mTextViewNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// start home activity
				Intent intent = new Intent(RuleActivity.this,
						HomeActivity.class);
				startActivity(intent);
				finish();
			}
		});
		mCheckBoxRule.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					mTextViewNext.setTextColor(Color.WHITE);
				} else {
					mTextViewNext.setTextColor(Color.GRAY);
				}
				mTextViewNext.setEnabled(isChecked);
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
				R.string.tv_rule_title_rule_screen));
		rightImageButton.setVisibility(View.INVISIBLE);
		leftImageButton.setVisibility(View.INVISIBLE);

	}
}
