package com.kyler.mbq.mbqscpuguide.Governors;

import com.kyler.mbq.mbqscpuguide.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Conservative extends Fragment {
	
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    final View v = inflater.inflate(R.layout.conservativelayout, container, false);
	    return v;
	  }
	}