package com.kyler.mbq.mbqscpuguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

   }