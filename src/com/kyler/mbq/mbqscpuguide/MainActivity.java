package com.kyler.mbq.mbqscpuguide;

import com.kyler.mbq.mbqscpuguide.Algorithms.Cubic;
import com.kyler.mbq.mbqscpuguide.Algorithms.Hybla;
import com.kyler.mbq.mbqscpuguide.Algorithms.Reno;
import com.kyler.mbq.mbqscpuguide.Algorithms.Tahoe;
import com.kyler.mbq.mbqscpuguide.Algorithms.Vegas;
import com.kyler.mbq.mbqscpuguide.Algorithms.Westwood;
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
import com.kyler.mbq.mbqscpuguide.Schedulers.BFQ;
import com.kyler.mbq.mbqscpuguide.Schedulers.CFQ;
import com.kyler.mbq.mbqscpuguide.Schedulers.Deadline;
import com.kyler.mbq.mbqscpuguide.Schedulers.FIFO;
import com.kyler.mbq.mbqscpuguide.Schedulers.FIOPS;
import com.kyler.mbq.mbqscpuguide.Schedulers.Noop;
import com.kyler.mbq.mbqscpuguide.Schedulers.ROW;
import com.kyler.mbq.mbqscpuguide.Schedulers.SIO;
import com.kyler.mbq.mbqscpuguide.Schedulers.Vr;

import shared.ui.actionscontentview.ActionsContentView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
  ListView lv1;
  ListView lv2;
  ListView lv3;

  private ActionsContentView viewActionsContentView;
  private Object Transaction;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewActionsContentView = (ActionsContentView) findViewById(R.id.actionsContentView);

    final ListView viewActionsList = (ListView) findViewById(R.id.actions);
    
    final String[] values = new String[] { "Welcome", "CPU Governors", "IO Schedulers", 
	"TCP Algorithms", "Nephilims Settings", "Help", "Settings" };
	
    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, android.R.id.text1, values);

    viewActionsList.setAdapter(adapter);
    viewActionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapter, View v, int position,
          long flags) {
        showFragment(position);
      }
    });

    showFragment(0);
  }

  private void showFragment(int position) {
    final Fragment f;
    switch (position) {
    case 0:
      f = new Welcome();
      break;
    case 1:
      f = new CPUGovernors();
      break;
    case 2:
      f = new IOSchedulers();
      break;
    case 3:
      f = new TCPAlgorithms();
      break;
    case 4:
      f = new Neph();
      break;
    case 5:
      f = new Help();
      break;


    default:
      return;
    }
    getSupportFragmentManager().beginTransaction().replace(R.id.content, f).commit();

    viewActionsContentView.showContent();
  }
  
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
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, governors);

                 lv1.setAdapter(adapter);

         return view;
  }
  
  public void onItemClick(AdapterView<?> parent, View view,
	      int position, long id) {
	    switch( position ) {}

  showThisFragment(0);
}

private void showThisFragment(int position) {
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
  getSupportFragmentManager().beginTransaction().replace(R.id.content2, l).commit();

  viewActionsContentView.showContent();
}

String[] schedulers = new String[] { "Deadline", "Noop", 
		"SIO", "BFQ", 
		"CFQ", "FIOPS", 
		"ROW", "V(R)", 
		"FIFO" };

 
public View onCreateView1(LayoutInflater inflater, ViewGroup container,
Bundle savedInstanceState) {

View view = inflater.inflate(R.layout.ioschedulerlayout, container, false);

lv2 = (ListView) view.findViewById(R.id.schedulerlistview);        
	  
      if (container == null) {
          return null;
      }
      final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_1, android.R.id.text1, schedulers);

               lv2.setAdapter(adapter);

       return view;
   }

public void onItemClick1(AdapterView<?> adapter, View v, int position,
    long flags) {
  showFragment(position);
}
{;

showAlsoThisFragment(0);
}

private void showAlsoThisFragment(int position) {
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
getSupportFragmentManager().beginTransaction().replace(R.id.content3, r).commit();

viewActionsContentView.showContent();
}

String[] tcp = new String[] { "Tahoe", "Reno", 
		"Vegas", "Hybla", 
		"Cubic", "Westwood" };

 
public View onCreateView2(LayoutInflater inflater, ViewGroup container,
Bundle savedInstanceState) {

View view = inflater.inflate(R.layout.ioschedulerlayout, container, false);

lv2 = (ListView) view.findViewById(R.id.schedulerlistview);        
	  
      if (container == null) {
          return null;
      }
      final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_1, android.R.id.text1, schedulers);

               lv2.setAdapter(adapter);

       return view;
   }

public void onItemClick2(AdapterView<?> adapter, View v, int position,
    long flags) {
  showFragment(position);
}
{;

showThisThirdFragment(0);
}

private void showThisThirdFragment(int position) {
final Fragment r;
switch (position) {

case 0:
r = new Tahoe();
break;

case 1:
r = new Reno();
break;

case 2:
r = new Vegas();
break;

case 3:
r = new Hybla();
break;

case 4:
r = new Cubic();
break;

case 5:
r = new Westwood();
break;

default:
return;
}
getSupportFragmentManager().beginTransaction().replace(R.id.content3, r).commit();

viewActionsContentView.showContent();
}


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

public Object getTransaction() {
	return Transaction;
}

public void setTransaction(Object transaction) {
	Transaction = transaction;
}
}
