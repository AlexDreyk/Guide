package com.kyler.mbq.mbqscpuguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kyler.mbq.mbqscpuguide.Schedulers.BFQ;
import com.kyler.mbq.mbqscpuguide.Schedulers.CFQ;
import com.kyler.mbq.mbqscpuguide.Schedulers.Deadline;
import com.kyler.mbq.mbqscpuguide.Schedulers.FIFO;
import com.kyler.mbq.mbqscpuguide.Schedulers.FIOPS;
import com.kyler.mbq.mbqscpuguide.Schedulers.Noop;
import com.kyler.mbq.mbqscpuguide.Schedulers.ROW;
import com.kyler.mbq.mbqscpuguide.Schedulers.SIO;
import com.kyler.mbq.mbqscpuguide.Schedulers.Vr;

public class IOSchedulers extends Fragment {
	ListView lv1;
    String[] values = new String[] { "Deadline", "Noop", 
    		"SIO", "BFQ", 
    		"CFQ", "FIOPS", 
    		"ROW", "V(R)", 
    		"FIFO" };

	 
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.ioschedulerlayout, container, false);

    lv1 = (ListView) view.findViewById(R.id.schedulerlistview);        
    	  
          if (container == null) {
              return null;
          }
                   ArrayAdapter<String> files = new ArrayAdapter<String>(getActivity(), 
                           android.R.layout.simple_list_item_1, 
                           values);

                   lv1.setAdapter(files);

           return view;
       }
    
    public void onItemClick(AdapterView<?> adapter, View v, int position,
        long flags) {
      showFragment(position);
    }
  {;

  showFragment(0);
}

private void showFragment(int position) {
  final Fragment r;
  switch (position) {
  
  case 0:
    r = new Deadline();
    break;
    
  case 1:
    r = new Noop();
    break;
    
  case 2:
    r = new SIO();
    break;
    
  case 3:
    r = new BFQ();
    break;
    
  case 4:
    r = new CFQ();
    break;
    
  case 5:
    r = new FIOPS();
    break;
    
  case 6:
    r = new ROW();
	break;
	
  case 7:
	r = new Vr();
	break;
	
  case 8:
	r = new FIFO();
	break;

  default:
    return;
  }
}}