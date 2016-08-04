package com.example.gabriela.sttrg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;

public class Spin extends Activity{
    Spinner ListaOpciones;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_spin);
        ListaOpciones = (Spinner) findViewById(R.id.spinner);
        ListaOpciones.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(Spin.this, ListaOpciones.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}
