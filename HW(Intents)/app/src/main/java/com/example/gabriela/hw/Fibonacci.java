package com.example.gabriela.hw;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fibonacci extends AppCompatActivity  {

    int n ;
    TextView jtv;//este es un text view diferente al que usamos en el xml
    EditText jet;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.fibonacci);//actividad a ser mostrada
        jtv =  (TextView)findViewById(R.id.xtv);
        jet= (EditText)findViewById(R.id.xet);
    }

    void genera_fibonacci(int numero,int fib){
        int fibo1=1,fibo2=1;
        int [] arreglo=new int[100];
        for(int i=0;i<=numero-1;i++){
            arreglo[i]=fibo1;
            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;
        }
        verifica_f(fib,arreglo);
    }

    void verifica_f(int fb,int [] s){
        boolean ver=false;
        for(int i=0;i<s.length;i++){
            if(fb==s[i]){
                Toast.makeText(this, "Si es FIBONACCI", Toast.LENGTH_SHORT).show();
                ver=true;
            }
        }
        if(ver==false){
            Toast.makeText(this, "No es FIBONACCI", Toast.LENGTH_SHORT).show();
        }
    }

    public void FiboonClick(View v) {
        if(v.getId()==findViewById(R.id.xbtn).getId())
        {
            String s1 =jet.getText().toString();
            System.out.println("TEXTO:" + s1 + "\n");
            n=Integer.parseInt(s1);
            genera_fibonacci(100,n);
        }
    }


}
