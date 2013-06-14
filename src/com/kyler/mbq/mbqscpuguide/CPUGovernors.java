package com.kyler.mbq.mbqscpuguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CPUGovernors extends Fragment {
	ListView lv1;
    String[] values = new String[] { "Ondemand", "Interactive",
    		"InteractiveX", "Performance", 
    		"Powersave", "Conservative", 
    		"Userspace", "Lagfree", 
    		"Min Max", "Hotplug", 
    		"PegasusQ", "Lazy", 
    		"Nightmare", "HotplugX", 
    		"Lulzactive", "Smartass", 
    		"SmartassV2", "Lionheart", 
    		"BrazillianWax", "Savagedzen", 
    		"Scary", "Sakuractive",
    		"OndemandPlus", "DynInteractive" };

	 
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.cpugovernorlayout, container, false);

    lv1 = (ListView) view.findViewById(R.id.governorlistview);        
    	  
          if (container == null) {
              return null;
          }
                   ArrayAdapter<String> files = new ArrayAdapter<String>(getActivity(), 
                           android.R.layout.simple_list_item_1, 
                           values);

                   lv1.setAdapter(files);

           return view;
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, (ViewGroup) menu);
      return true;
    }

	private LayoutInflater getMenuInflater() {
		// TODO Auto-generated method stub
		return null;
	}
}
