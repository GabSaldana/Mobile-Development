package com.example.gabriela.hw;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Menu extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.menu);//actividad a ser mostrada

    }

    public void MavonClick(View v){
        if(v.getId()==findViewById(R.id.mav).getId()){

            Intent i= new Intent(Menu.this,HelloWorld.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
    public void FiboonClick(View v){
        if(v.getId()==findViewById(R.id.fibo).getId()){

            Intent i= new Intent(Menu.this,Fibonacci.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
    public void PrionClick(View v){
        if(v.getId()==findViewById(R.id.pri).getId()){

            Intent i= new Intent(Menu.this,Primo.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
    public void PalionClick(View v){
        if(v.getId()==findViewById(R.id.pali).getId()){

            Intent i= new Intent(Menu.this,Palindromo.class);//Intencion de hacer algo
            startActivity(i);
        }
    }

}
