package com.example.gabriela.hw;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Primo extends AppCompatActivity  {

    int n ;
    TextView jtv;//este es un text view diferente al que usamos en el xml
    EditText jet;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.primo);//actividad a ser mostrada
        jtv =  (TextView)findViewById(R.id.xtv);
        jet= (EditText)findViewById(R.id.xet);
    }

    boolean primo(int n) {
        int cont = 0;
        boolean flag=true;
        // recorre numero desde el 2 hasta el valor recibido
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                // Si se puede dividir por algun numero mas de una vez, no es primo
                if (++cont > 1)
                    flag= false;
            }
        }
        return flag;
    }

    public void PrimoonClick(View v) {
        if(v.getId()==findViewById(R.id.xbtn).getId())
        {
            String s1 =jet.getText().toString();
            System.out.println("TEXTO:" + s1 + "\n");
            n=Integer.parseInt(s1);
            if(primo(n)== true){

                Toast.makeText(this, "Si es PRIMO", Toast.LENGTH_SHORT).show();
            }else{

                Toast.makeText(this, "No es PRIMO", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
