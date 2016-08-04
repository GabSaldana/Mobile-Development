package com.example.gabriela.archivos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ArchivosActivity extends Activity { // Abre un archivo almacenado
    TextView tv;
    String			s;
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.archivos_activity);
        tv	= (TextView) findViewById(R.id.xt);
        tv.append("\nAbriendo: res/raw/aiuda.txt");
        is	= getResources().openRawResource(R.raw.aiuda);
        isr	= new InputStreamReader(is);
        br	= new BufferedReader(isr, 8192);
        try{
            while( null != (s=br.readLine()) )
                tv.append("\n" + s);
            is.close();
            isr.close();
            br.close();
        } catch(Exception e){
            tv.append("\n " + e);
        }
        tv.append("\nEnd of file.");
    }
}

