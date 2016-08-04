package com.example.gabriela.sttrg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class Tost extends Activity {
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_tost);
    }
    public void toast1(View v) {
        Toast toast = Toast.makeText(this, "Toast 1", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void toast2(View v) {
        Toast toast = Toast.makeText(this, "Toast 2", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
    public void toast3(View v) {
        LayoutInflater li = getLayoutInflater();
        View vw = li.inflate(R.layout.disenio, null);
        Toast t = new Toast(getApplicationContext());
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(vw);
        t.show();
    }
}
