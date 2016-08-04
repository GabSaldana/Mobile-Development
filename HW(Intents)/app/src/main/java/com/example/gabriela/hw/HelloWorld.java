package com.example.gabriela.hw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class HelloWorld extends Activity {

    int n ;
    String s="";
    TextView jtv;//este es un text view diferente al que usamos en el xml
    EditText jet;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_hello_world);//actividad inicial
        jtv =  (TextView)findViewById(R.id.xtv);
        jet= (EditText)findViewById(R.id.xet);

    }

    public void maravilloso(int n){
        int m=n;
        String maravilloso;
        while(true){
            System.out.println("N: " + n);
            if(0 == n%2){
                n=n/2;
                if(n==1){
                    break;
                }
            }else{

                n=n*3+1;
            }
            s=s+n+"\n";
            jtv.setText(s + "");//concatenamos con la cadena vacia para hacerla string
        }
        maravilloso=  + m + "  Es maravilloso!!";
        Toast.makeText(this, maravilloso, Toast.LENGTH_SHORT).show();
    }


    public void NumonClick(View v) {
        if(v.getId()==findViewById(R.id.xbtn).getId())
        {
            String s1 =jet.getText().toString();
            System.out.println("TEXTO:" + s1 + "\n");
            n=Integer.parseInt(s1);
            maravilloso(n);
        }
    }

    /*public void BackonClick(View v) {
        if(v.getId()==findViewById(R.id.xbtnb.getId()){

            Intent i= new Intent(HelloWorld.this,Menu.class);//Intencion de hacer algo
            startActivity(i);
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
