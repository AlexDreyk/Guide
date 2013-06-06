package com.kyler.mbq.mbqscpuguide;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;



public class MainActivity extends SherlockFragmentActivity {

	ActionBar mActionBar;
	ViewPager mPager;
	Tab tab;
	private Bundle savedInstanceState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		
		mActionBar = getSupportActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		
		mPager = (ViewPager) findViewById(R.id.pager);
		
		
		FragmentManager fm = getSupportFragmentManager();

		
		ViewPager.SimpleOnPageChangeListener ViewPagerListener = new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				
				mActionBar.setSelectedNavigationItem(position);
			}
		};

		mPager.setOnPageChangeListener(ViewPagerListener);
		
		ViewPagerAdapter viewpageradapter = new ViewPagerAdapter(fm);
		
		mPager.setAdapter(viewpageradapter);
		
		
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				
				mPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO 
			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO, Ill find a use
			}
		};
		

		
		tab = mActionBar.newTab().setText("About App").setTabListener(tabListener);
		mActionBar.addTab(tab);
		
		
		tab = mActionBar.newTab().setText("CPU Governors").setTabListener(tabListener);
		mActionBar.addTab(tab);
		
		
		tab = mActionBar.newTab().setText("IO Schedulers").setTabListener(tabListener);
		mActionBar.addTab(tab);
		
		
		tab = mActionBar.newTab().setText("TCP Algorithms").setTabListener(tabListener);
		mActionBar.addTab(tab);
		
		
		tab = mActionBar.newTab().setText("Help").setTabListener(tabListener);
		mActionBar.addTab(tab);

	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main, menu);
		
        return true;
    }
}

