package com.example.gabriela.sttrg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Rgroup extends Activity {
    RadioGroup  jrg1;
    TextView    jtv1, jtv2;
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_rgroup);
        jtv1 = (TextView)   findViewById(R.id.xtv1);
        jtv2 = (TextView)   findViewById(R.id.xtv2);
        jrg1 = (RadioGroup) findViewById(R.id.xrg1);
        jrg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup rg, int id) {
                if(id == R.id.xrb1)         jtv2.setText("Botón 1 digitado");
                else if(id == R.id.xrb2)    jtv2.setText("Botón 2 digitado");
                else if(id == R.id.xrb3)    jtv2.setText("Botón 3 digitado");
            }
        });
    }
}
