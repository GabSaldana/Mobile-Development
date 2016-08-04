package com.example.gabriela.cubo3d;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
public class Cubo3DActivity extends AppCompatActivity    {
    Cubo3D c;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        c = new Cubo3D(Cubo3DActivity.this);
        setContentView(c);
    }
}