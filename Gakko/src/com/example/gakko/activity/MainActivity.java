package com.example.gakko.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gakko.R;
import com.example.gakko.fragment.AdsFragment;
import com.example.gakko.fragment.ChatFragment;
import com.example.gakko.fragment.CreateNewRoomFragment;
import com.example.gakko.fragment.NotifyCityDetailFragment;
import com.example.gakko.fragment.NotifyCityFragment;
import com.example.gakko.fragment.NotifySchoolDetailFragment;
import com.example.gakko.fragment.NotifySchoolFragment;

public class MainActivity extends ActionBarActivity {

	public static final int SHOW_NOTIFY_FROM_CITY = 1;
	public static final int SHOW_NOTIFY_FROM_CITY_DETAIL = 2;
	public static final int SHOW_NOTIFY_FROM_SCHOOL = 3;
	public static final int SHOW_NOTIFY_FROM_SCHOOL_DETAIL = 4;
	public static final int SHOW_ADS = 5;
	public static final int SHOW_CHAT = 6;
	public static final int SHOW_CREATE_NEW_ROOM = 7;

	private ImageButton mImageButtonNotifyCity;
	private ImageButton mImageButtonChat;
	private ImageButton mImageButtonNotifySchool;
	private ImageButton mImageButtonAds;

	private NotifyCityFragment mNotifyCityFragment;
	private NotifySchoolFragment mNotifySchoolFragment;
	private ChatFragment mChatFragment;
	private AdsFragment mAdsFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mImageButtonAds = (ImageButton) findViewById(R.id.btn_show_activity_ads);
		mImageButtonChat = (ImageButton) findViewById(R.id.btn_show_activity_chat);
		mImageButtonNotifyCity = (ImageButton) findViewById(R.id.btn_show_activity_city);
		mImageButtonNotifySchool = (ImageButton) findViewById(R.id.btn_show_activity_school);

		mNotifyCityFragment = new NotifyCityFragment();
		mNotifySchoolFragment = new NotifySchoolFragment();
		mChatFragment = new ChatFragment();
		mAdsFragment = new AdsFragment();

		showAction();

		mImageButtonAds.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setupActionBar(SHOW_ADS);
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.my_fragment, mAdsFragment).commit();
			}
		});

		mImageButtonChat.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setupActionBar(SHOW_CHAT);
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.my_fragment, mChatFragment).commit();
			}
		});

		mImageButtonNotifyCity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setupActionBar(SHOW_NOTIFY_FROM_CITY);
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.my_fragment, mNotifyCityFragment)
						.commit();
			}
		});

		mImageButtonNotifySchool.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setupActionBar(SHOW_NOTIFY_FROM_SCHOOL);
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.my_fragment, mNotifySchoolFragment)
						.commit();
			}
		});

	}

	private void showAction() {
		int showAction = getIntent().getExtras().getInt(
				HomeActivity.SHOW_ACTION);
		setupActionBar(showAction);
		switch (showAction) {
		case SHOW_ADS:
			setupActionBar(SHOW_ADS);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.my_fragment, mAdsFragment).commit();
			break;
		case SHOW_CHAT:
			setupActionBar(SHOW_CHAT);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.my_fragment, mChatFragment).commit();
			break;
		case SHOW_NOTIFY_FROM_CITY:
			setupActionBar(SHOW_NOTIFY_FROM_CITY);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.my_fragment, mNotifyCityFragment).commit();
			break;
		case SHOW_NOTIFY_FROM_SCHOOL:
			setupActionBar(SHOW_NOTIFY_FROM_SCHOOL);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.my_fragment, mNotifySchoolFragment).commit();
			break;
		default:
			break;
		}
	}

	private void setupActionBar(int type) {
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

		switch (type) {
		case SHOW_ADS:
			titleTextView.setText("Advertise");
			rightImageButton.setVisibility(View.INVISIBLE);
			leftImageButton.setVisibility(View.INVISIBLE);
			break;
		case SHOW_CHAT:
			titleTextView.setText("Chat");
			rightImageButton.setVisibility(View.VISIBLE);
			leftImageButton.setVisibility(View.INVISIBLE);
			rightImageButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					setupActionBar(SHOW_CREATE_NEW_ROOM);
					getSupportFragmentManager()
							.beginTransaction()
							.replace(R.id.my_fragment,
									new CreateNewRoomFragment()).commit();
				}
			});
			break;
		case SHOW_NOTIFY_FROM_CITY:
			titleTextView.setText("Notify from city");
			rightImageButton.setVisibility(View.INVISIBLE);
			leftImageButton.setVisibility(View.INVISIBLE);
			break;
		case SHOW_NOTIFY_FROM_CITY_DETAIL:
			titleTextView.setText("Detail notify from city");
			rightImageButton.setVisibility(View.INVISIBLE);
			leftImageButton.setVisibility(View.VISIBLE);
			leftImageButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					setupActionBar(SHOW_NOTIFY_FROM_CITY);
					getSupportFragmentManager().beginTransaction()
							.replace(R.id.my_fragment, mNotifyCityFragment)
							.commit();
				}
			});
			break;
		case SHOW_NOTIFY_FROM_SCHOOL:
			titleTextView.setText("Notify from school");
			rightImageButton.setVisibility(View.INVISIBLE);
			leftImageButton.setVisibility(View.INVISIBLE);
			break;
		case SHOW_NOTIFY_FROM_SCHOOL_DETAIL:
			titleTextView.setText("Detail notify from school");
			rightImageButton.setVisibility(View.INVISIBLE);
			leftImageButton.setVisibility(View.VISIBLE);
			leftImageButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					setupActionBar(SHOW_NOTIFY_FROM_SCHOOL);
					getSupportFragmentManager().beginTransaction()
							.replace(R.id.my_fragment, mNotifySchoolFragment)
							.commit();
				}
			});
			break;

		case SHOW_CREATE_NEW_ROOM:
			titleTextView.setText("Create new room");
			rightImageButton.setVisibility(View.INVISIBLE);
			leftImageButton.setVisibility(View.VISIBLE);
			leftImageButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					setupActionBar(SHOW_CHAT);
					getSupportFragmentManager().beginTransaction()
							.replace(R.id.my_fragment, mChatFragment).commit();
				}
			});
			break;
		default:
			break;
		}

	}

	public void showDetailNotifyCity() {
		setupActionBar(SHOW_NOTIFY_FROM_CITY_DETAIL);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.my_fragment, new NotifyCityDetailFragment())
				.commit();
	}

	public void showDetailNotifySchool() {
		setupActionBar(SHOW_NOTIFY_FROM_SCHOOL_DETAIL);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.my_fragment, new NotifySchoolDetailFragment())
				.commit();
	}

}
