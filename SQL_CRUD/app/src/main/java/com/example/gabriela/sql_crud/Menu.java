package com.example.gabriela.sql_crud;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity  {

    SQLiteDatabase sqlDB=null;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.menu);//actividad a ser mostrada
        PostDatabase DB= new PostDatabase(Menu.this);
        sqlDB = DB.getWritableDatabase();

        Toast t= Toast.makeText(getApplicationContext(),"CREATED", Toast.LENGTH_SHORT);
        t.show();
    }

    public void AddonClick(View v){
        if(v.getId()==findViewById(R.id.add).getId()){

            ContentValues values = new ContentValues();
            values.put(PostDatabase.COL_TITLE, "Test Title");
            values.put(PostDatabase.COL_CONTENT, "Test Content");

            sqlDB.insert(PostDatabase.TABLE_POSTS, null, values);

            Toast t= Toast.makeText(getApplicationContext(),"INSERTED", Toast.LENGTH_SHORT);
            t.show();
        }
    }

    /*public void DeleteonClick(View v){
        if(v.getId()==findViewById(R.id.delete).getId()){

            Intent i= new Intent(Menu.this,Delete.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
    public void UpdateonClick(View v){
        if(v.getId()==findViewById(R.id.update).getId()){

            Intent i= new Intent(Menu.this,Update.class);//Intencion de hacer algo
            startActivity(i);
        }
    }
    public void SelectonClick(View v){
        if(v.getId()==findViewById(R.id.select).getId()){

            Intent i= new Intent(Menu.this,Select.class);//Intencion de hacer algo
            startActivity(i);
        }
    }*/

}

