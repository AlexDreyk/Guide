package com.kyler.mbq.mbqscpuguide;

import com.kyler.mbq.mbqscpuguide.Governors.BrazilianWax;
import com.kyler.mbq.mbqscpuguide.Governors.Conservative;
import com.kyler.mbq.mbqscpuguide.Governors.DynInteractive;
import com.kyler.mbq.mbqscpuguide.Governors.Hotplug;
import com.kyler.mbq.mbqscpuguide.Governors.HotplugX;
import com.kyler.mbq.mbqscpuguide.Governors.Interactive;
import com.kyler.mbq.mbqscpuguide.Governors.InteractiveX;
import com.kyler.mbq.mbqscpuguide.Governors.Lagfree;
import com.kyler.mbq.mbqscpuguide.Governors.Lazy;
import com.kyler.mbq.mbqscpuguide.Governors.Lionheart;
import com.kyler.mbq.mbqscpuguide.Governors.Lulzactive;
import com.kyler.mbq.mbqscpuguide.Governors.MinMax;
import com.kyler.mbq.mbqscpuguide.Governors.Nightmare;
import com.kyler.mbq.mbqscpuguide.Governors.OnDemand;
import com.kyler.mbq.mbqscpuguide.Governors.OndemandPlus;
import com.kyler.mbq.mbqscpuguide.Governors.PegasusQ;
import com.kyler.mbq.mbqscpuguide.Governors.Performance;
import com.kyler.mbq.mbqscpuguide.Governors.Powersave;
import com.kyler.mbq.mbqscpuguide.Governors.Sakuractive;
import com.kyler.mbq.mbqscpuguide.Governors.Savagedzen;
import com.kyler.mbq.mbqscpuguide.Governors.Scary;
import com.kyler.mbq.mbqscpuguide.Governors.Smartass;
import com.kyler.mbq.mbqscpuguide.Governors.SmartassV2;
import com.kyler.mbq.mbqscpuguide.Governors.Userspace;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CPUGovernors extends Fragment implements OnClickListener {
	
	
	ListView lv1;
	
	
    String[] governors = new String[] { "Ondemand", "Interactive",
    		
    		"InteractiveX", "Performance", 
    		
    		"Powersave", "Conservative", 
    		
    		"Userspace", "Lagfree", 
    		
    		"Min Max", "Hotplug", 
    		
    		"PegasusQ", "Lazy", 
    		
    		"Nightmare", "HotplugX", 
    		
    		"Lulzactive", "Smartass", 
    		
    		"SmartassV2", "Lionheart", 
    		
    		"BrazilianWax", "Savagedzen", 
    		
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
                           android.R.layout.simple_list_item_1, governors);

                   lv1.setAdapter(files);

           return view;
    }
    
    public void onItemClick(AdapterView<?> parent, View view,
    	      int position, long id) {
    	    switch( position ) {}

      showFragment(0);
    }

    private void showFragment(int position) {
      final Fragment l;
      switch (position) {
      
      case 0:
       l = new OnDemand();
       break;
       
      case 1:
       l = new Interactive();
       break;
       
      case 2:
       l = new InteractiveX();
       break;
       
      case 3:
       l = new Performance();
       break;
       
      case 4:
       l = new Powersave();
       break;
      case 5:
       l = new Conservative();
       break;
       
      case 6:
       l = new Userspace();
       break;
       
      case 7:
       l = new Lagfree();
       break;
       
      case 8:
       l = new MinMax();
      break;
      
      case 9:
       l = new Hotplug();
      break;
      
      case 10:
       l = new PegasusQ();
      break;
      
      case 11:
       l = new Lazy();
      break;
      
      case 12:
       l = new Nightmare();
      break;
      
      case 13:
       l = new HotplugX();
      break;
      
      case 14:
       l = new Lulzactive();
      break;
      
      case 15:
       l = new Smartass();
      break;
      
      case 16:
       l = new SmartassV2();
      break;
      
      case 17:
       l = new Lionheart();
      break;
      
      case 18:
       l = new BrazilianWax();
      break;
      
      case 19:
       l = new Savagedzen();
      break;
      
      case 20:
       l = new Scary();
      break;
     
      case 21:
       l = new Sakuractive();
      break;
     
      case 22:
       l = new OndemandPlus();
      break;
     
      case 23:
       l = new DynInteractive();
      break;
         
      default:
        return;
      }
      getChildFragmentManager().beginTransaction().replace(R.id.content, l).commit();

      lv1.layout(position, position, position, position);
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

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}	
}