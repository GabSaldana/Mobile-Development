package com.example.gabriela.sttrg;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class Tab extends Activity {
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_tab);
        Resources r = getResources();
        TabHost th = (TabHost) findViewById(android.R.id.tabhost);
        th.setup();
        TabSpec ts = th.newTabSpec("mitab1");
        ts.setContent(R.id.tab1);
        ts.setIndicator("TAB1", r.getDrawable(android.R.drawable.ic_btn_speak_now));
        th.addTab(ts);
        ts=th.newTabSpec("mitab2");
        ts.setContent(R.id.tab2);
        ts.setIndicator("TAB2", r.getDrawable(android.R.drawable.ic_dialog_map));
        th.addTab(ts);
        th.setCurrentTab(0);
        th.setOnTabChangedListener(new OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Toast.makeText(getApplicationContext(), "Pestaña seleccionada: " + tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}