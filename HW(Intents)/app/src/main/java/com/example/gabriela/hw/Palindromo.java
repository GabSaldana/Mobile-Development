package com.example.gabriela.hw;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Palindromo extends AppCompatActivity  {

    int n ;
    TextView jtv;//este es un text view diferente al que usamos en el xml
    EditText jet;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.palindroma);//actividad a ser mostrada
        jtv =  (TextView)findViewById(R.id.xtv);
        jet= (EditText)findViewById(R.id.xet);
    }

    void palindrome(String p){
        int n=p.length();
        String p_aux="";

        for ( int i=n-1; i>=0; i--)
            p_aux = p_aux + p.charAt(i);
        if (p.equals(p_aux)){
            Toast.makeText(this, "Es PALINDROMA", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "No es PALINDROMA", Toast.LENGTH_SHORT).show();
        }
    }

    public void PalindromoonClick(View v) {
        if(v.getId()==findViewById(R.id.xbtn).getId())
        {
            String s1 =jet.getText().toString();
            System.out.println("TEXTO:" + s1 + "\n");
            palindrome(s1);
        }
    }


}
