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
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gakko.R;

public class LoginActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setupActionBar();
		setContentView(R.layout.activity_login);
		Button loginButton = (Button) findViewById(R.id.btn_login);
		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// check API
				if (true) {
					Intent intent = new Intent(LoginActivity.this,
							RuleActivity.class);
					startActivity(intent);
					finish();
				} else {
					// toast login failt
				}
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

		titleTextView.setText("Login");
		rightImageButton.setVisibility(View.INVISIBLE);
		leftImageButton.setVisibility(View.INVISIBLE);

	}
}
