package com.example.gabriela.helloworld;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.*;
import android.app.*;
import android.widget.*;
public class MainActivity extends Activity{

    SharedPreferences	misDatos;
    EditText		    editNombre, editx, edity;
    String			    nombre;
    Float			    x, y;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        editNombre  = (EditText) findViewById(R.id.nombre);
        editx       = (EditText) findViewById(R.id.coordenadax);
        edity       = (EditText) findViewById(R.id.coordenaday);
        misDatos    = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        nombre      = misDatos.getString("nombre", "Valor predeterminado");
        x = misDatos.getFloat("x", 0);
        y = misDatos.getFloat("y", 0);
        editNombre.setText(nombre);
        editx.setText("" + x);
        edity.setText("" + y);
    }
    protected void onPause(){
        super.onPause();
        nombre = editNombre.getText().toString();
        x = Float.parseFloat(editx.getText().toString());
        y = Float.parseFloat(edity.getText().toString());
        SharedPreferences.Editor miEditor = misDatos.edit();
        miEditor.putString("nombre", nombre);
        miEditor.putFloat("x", x);
        miEditor.putFloat("y", y);
        miEditor.commit();
        Toast.makeText(this, "Preferencias guardadas", Toast.LENGTH_LONG).show();
    }
}
