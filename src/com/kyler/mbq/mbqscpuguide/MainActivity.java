package com.kyler.mbq.mbqscpuguide;

import shared.ui.actionscontentview.ActionsContentView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
import com.kyler.mbq.mbqscpuguide.Tips.AutoBrightnessSucks;
import com.kyler.mbq.mbqscpuguide.Tips.BetterBatteryLife;
import com.kyler.mbq.mbqscpuguide.Tips.BlockAds;
import com.kyler.mbq.mbqscpuguide.Tips.ChangeBootAnimation;
import com.kyler.mbq.mbqscpuguide.Tips.ChangeDensity;
import com.kyler.mbq.mbqscpuguide.Tips.DeveloperOptions;
import com.kyler.mbq.mbqscpuguide.Tips.ForceGPURendering;
import com.kyler.mbq.mbqscpuguide.Tips.MSAA;
import com.kyler.mbq.mbqscpuguide.Tips.StatusBarAndQS;
import com.kyler.mbq.mbqscpuguide.Tips.WiFiDuringSleep;
import com.kyler.mbq.mbqscpuguide.Tips.WiFiScanInterval;
import com.kyler.mbq.mbqscpuguide.Tips.zRAM;

public class MainActivity extends FragmentActivity {

  private ActionsContentView viewActionsContentView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	  
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewActionsContentView = (ActionsContentView) findViewById(R.id.actionsContentView);

    final ListView viewActionsList = (ListView) findViewById(R.id.actions);
    
    final String[] values = new String[] 
    		
    		{ 
    		
    		"Welcome",
    		
    		"CPU Governors", 
    		
    		"IO Schedulers",
    		
    		"TCP Algorithms", 
    		
    		"Nephilims Settings", 
    		
    		"Help", 
    		
    		"Ondemand", 
    		
    		"Interactive",
      		
      		"InteractiveX", 
      		
      		"Performance", 
      		
      		"Powersave", 
      		
      		"Conservative", 
      		
      		"Userspace", 
      		
      		"Lagfree", 
      		
      		"Min Max", 
      		
      		"Hotplug", 
      		
      		"PegasusQ", 
      		
      		"Lazy", 
      		
      		"Nightmare", 
      		
      		"HotplugX", 
      		
      		"Lulzactive", 
      		
      		"Smartass", 
      		
      		"SmartassV2", 
      		
      		"Lionheart", 
      		
      		"BrazilianWax", 
      		
      		"Savagedzen", 
      		
      		"Scary",
      		
      		"Sakuractive",
      		
      		"OndemandPlus", 
      		
      		"DynInteractive",
      		
      		"Deadline", 
      		
      		"Noop", 
      		
    		"SIO", 
    		
    		"BFQ", 
    		
    		"CFQ", 
    		
    		"FIOPS", 
    		
    		"ROW", 
    		
    		"V(R)", 
    		
    		"FIFO", 
    		
    		"Tahoe", 
    		
    		"Reno", 
    		
    		"Vegas", 
    		
    		"Hybla", 
    		
    		"Cubic", 
    		
            "Westwood",  
    		
    		"Android tips",
    		
    		"Developer options",
    		
    		"Force GPU Rendering",
    		
    		"WiFi sleep policy",
    		
    		"WiFi Scan Interval", 
    		
    		"Better Battery Life",
    		
    		"StatusBar Trick",
    		
    		"Autobrightness Sucks",
    		
    		"Change Screen Density",
    		
    		"Change Your Bootanimation",
    		
    		"Block Ads",
    		
    		"4x MSAA",
    		
    		"zRAM Explanation" };

	
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
      
    case 6:
      f = new OnDemand();
      break;
        
    case 7:
      f = new Interactive();
      break;
        
    case 8:
      f = new InteractiveX();
      break;
        
    case 9:
      f = new Performance();
      break;
        
    case 10:
      f = new Powersave();
      break;
      
    case 11:
      f = new Conservative();
      break;
        
    case 12:
      f = new Userspace();
      break;
        
    case 13:
      f = new Lagfree();
      break;
        
    case 14:
      f = new MinMax();
      break;
       
    case 15:
      f = new Hotplug();
      break;
       
    case 16:
      f = new PegasusQ();
      break;
       
    case 17:
      f = new Lazy();
      break;
       
    case 18:
      f = new Nightmare();
      break;
       
    case 19:
      f = new HotplugX();
      break;
       
    case 20:
      f = new Lulzactive();
      break;
       
    case 21:
      f = new Smartass();
      break;
       
    case 22:
      f = new SmartassV2();
      break;
       
    case 23:
      f = new Lionheart();
      break;
       
    case 24:
      f = new BrazilianWax();
      break;
       
    case 25:
      f = new Savagedzen();
      break;
       
    case 26:
      f = new Scary();
      break;
    
    case 27:
      f = new Sakuractive();
      break;
      
    case 28:
      f = new OndemandPlus();
      break;
      
    case 29:
      f = new DynInteractive();
      break;
      
    case 30:
      f = new Deadline();
      break;
        
    case 31:
      f = new Noop();
      break;
        
    case 32:
      f = new SIO();
      break;
        
    case 33:
      f = new BFQ();
      break;
        
    case 34:
      f = new CFQ();
      break;
        
    case 35:
      f = new FIOPS();
      break;
        
    case 36:
      f = new ROW();
      break;
    	
    case 37:
      f = new Vr();
      break;
    	
    case 38:
      f = new FIFO();
      break;  
      
    case 39:
      f = new Tahoe();
      break;
          
    case 40:
      f = new Reno();
      break;
          
    case 41:
      f = new Vegas();
      break;
        
    case 42:
      f = new Hybla();
      break;
          
    case 43:
      f = new Cubic();
      break;
      	
    case 44:
      f = new Westwood();
      break;
      	
    case 45:
      f = new FIFO();
      break; 
      
    case 46:
      f = new AndroidTips();
      break;
      
    case 47:
      f = new DeveloperOptions();
      break;
          
    case 48:
      f = new ForceGPURendering();
      break;
          
    case 49:
      f = new WiFiDuringSleep();
      break;
      	
    case 50:
      f = new WiFiScanInterval();
      break;
      	
    case 51:
      f = new BetterBatteryLife();
      break;  
        
    case 52:
      f = new StatusBarAndQS();
      break;
            
    case 53:
      f = new AutoBrightnessSucks();
      break;
            
    case 54:
      f = new ChangeDensity();
        break;
          
    case 55:
      f = new ChangeBootAnimation();
        break;
            
    case 56:
      f = new BlockAds();
      break;
        	
    case 57:
      f = new MSAA();
      break;
        	
    case 58:
      f = new zRAM();
      break; 

    default:
    	
      return;
      
    }
    
    getSupportFragmentManager().beginTransaction().replace(R.id.content, f).commit();

    viewActionsContentView.showContent();
    
  }
  
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.main, menu);
      
	return true;
	
  }
  
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
	  
     switch (item.getItemId()) {
     
         case R.id.builddate:
        	 
              AlertDialog.Builder builddatealert = new AlertDialog.Builder(this);

                     builddatealert.setMessage("Saturday, June 15th, 2013");

                     builddatealert.setNeutralButton("OK", new DialogInterface.OnClickListener() {

                         public void onClick(DialogInterface arg0, int arg1) {

                         }
                     });

                     builddatealert.show();
              break;
              
         case R.id.changelog:
        	 
   AlertDialog.Builder changelogalert = new AlertDialog.Builder(this);

          changelogalert.setMessage("Fixed the mistake at Force GPU Rendering");

          changelogalert.setNeutralButton("OK", new DialogInterface.OnClickListener() {

              public void onClick(DialogInterface arg0, int arg1) {

              }
          });

          changelogalert.show();
          
          break;
          
         case R.id.version:
        	 
   AlertDialog.Builder versionalert = new AlertDialog.Builder(this);

          versionalert.setMessage("Alpha 3 (0.0.3a)");

          versionalert.setNeutralButton("OK", new DialogInterface.OnClickListener() {

              public void onClick(DialogInterface arg0, int arg1) {

              }
          });

          versionalert.show();
          
          break;       

     }
     
     return true;
  }
}

