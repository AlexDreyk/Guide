package com.kyler.mbq.mbqscpuguide;

import shared.ui.actionscontentview.ActionsContentView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {

  private ActionsContentView viewActionsContentView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewActionsContentView = (ActionsContentView) findViewById(R.id.actionsContentView);

    final ListView viewActionsList = (ListView) findViewById(R.id.actions);

    final String[] values = new String[] { "CPU Governors", "IO Schedulers", 
	"TCP Algorithms", "Nephilims Settings", "Help" };
	
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

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  private void showFragment(int position) {
    final Fragment f;
    switch (position) {
    case 0:
      f = new CPUGovernors();
      break;
    case 1:
      f = new IOSchedulers();
      break;
    case 2:
      f = new TCPAlgorithms();
      break;
    case 3:
        f = new Help();
        break;
    case 4:
        f = new Neph();
        break;


    default:
      return;
    }
    getSupportFragmentManager().beginTransaction().replace(R.id.content, f).commit();

    viewActionsContentView.showContent();
  }
}
