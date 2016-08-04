package com.example.gabriela.sttrg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.content_main);//actividad a ser mostrada
    }
    public void TabonClick(View v){
        if(v.getId()==findViewById(R.id.tb).getId()){
            Intent i= new Intent(MainActivity.this,Tab.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
    public void RgrouponClick(View v){
        if(v.getId()==findViewById(R.id.rg).getId()){
            Intent i= new Intent(MainActivity.this,Rgroup.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
    public void SpinonClick(View v){
        if(v.getId()==findViewById(R.id.sp).getId()){
            Intent i= new Intent(MainActivity.this,Spin.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
    public void TostonClick(View v){
        if(v.getId()==findViewById(R.id.ts).getId()){
            Intent i= new Intent(MainActivity.this,Tost.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
}
