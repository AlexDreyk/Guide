package com.kyler.mbq.mbqscpuguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 5;

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		
		
		case 0:
			About aboutlayout = new About();
			return aboutlayout;

		
		case 1:
			CPUGovernors governorlist = new CPUGovernors();
			return governorlist;

		
		case 2:
			IOSchedulers schedulerlist = new IOSchedulers();
			return schedulerlist;
			
		
		case 3:
			TCPAlgorithms tcplist = new TCPAlgorithms();
			return tcplist;

		
		case 4:
			Help helplist = new Help();
			return helplist;	
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}

}
