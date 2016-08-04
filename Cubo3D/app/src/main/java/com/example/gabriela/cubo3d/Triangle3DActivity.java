package com.example.gabriela.cubo3d;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
public class Triangle3DActivity extends AppCompatActivity    {
    Triangle3D t;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        t = new Triangle3D(Triangle3DActivity.this);
        setContentView(t);
    }
}