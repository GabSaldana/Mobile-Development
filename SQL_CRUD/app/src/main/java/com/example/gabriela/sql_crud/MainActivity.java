package com.example.gabriela.sql_crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        CreateDB();
        Insert();
        Select();
        sqlDB.close();
    }

    public void CreateDB(){

        PostDatabase DB = new PostDatabase(MainActivity.this);
        sqlDB = DB.getWritableDatabase();
        Log.d("DB","ONCREATE");

    }

    public void Insert(){

        //INSERTING VALUES
        ContentValues values1 = new ContentValues();
        values1.put(PostDatabase.COL_TITLE, "Test Title");
        values1.put(PostDatabase.COL_CONTENT, "Test Content");
        sqlDB.insert(PostDatabase.TABLE_POSTS, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(PostDatabase.COL_TITLE, "Test2 Title");
        values2.put(PostDatabase.COL_CONTENT, "Test2 Content");
        sqlDB.insert(PostDatabase.TABLE_POSTS, null, values2);
        Log.d("DB","INSERTED");
    }

    public void Select(){

        //READING with Raw Query
        Cursor cursor = sqlDB.rawQuery("SELECT * FROM posts ",null);

        if (cursor != null && cursor.moveToFirst()) {
            String title = cursor.getString(cursor.getColumnIndex(PostDatabase.COL_TITLE));
            String content = cursor.getString(cursor.getColumnIndex(PostDatabase.COL_CONTENT));

            // Dumps "Title: Test Title Content: Test Content"
            Log.d("PostDataBase", "Title: " + title + " Content: " + content);

            cursor.close();
        }

        //  `query()` method
        /* Cursor query (String table, String[] columns, String selection, String[] selectionArgs,
        String groupBy, String having, String orderBy, String limit)*/
    }

    public void Delete(){

        //DELETE
        // Define 'where' part of query.
        String whereClause2 = PostDatabase.ID + " = ?";
        // Specify arguments in placeholder order.
        String[] whereArgs2 = { "6" };
        // Issue SQL statement.
        sqlDB.delete(PostDatabase.TABLE_POSTS, whereClause2, whereArgs2);

    }

    public void Update(){

        //UPDATE
        // New value for one column
        ContentValues values = new ContentValues();
        values.put(PostDatabase.COL_TITLE, "Second title changed");

        // Which row to update, based on the ID
        String whereClause = PostDatabase.ID + " LIKE ?";
        String[] whereArgs = { "2" };

        int affectedRows = sqlDB.update(
                PostDatabase.TABLE_POSTS,
                values,
                whereClause,
                whereArgs
        );
        Log.d("PostDataBase", String.valueOf(affectedRows));
    }

    public void DeleteDb(){

        MainActivity.this.deleteDatabase("test_db");
    }
}
