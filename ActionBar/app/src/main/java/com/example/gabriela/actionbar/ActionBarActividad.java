package com.example.gabriela.actionbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
public class ActionBarActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_action_bar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Log.i("ActionBar", "Nuevo");
                return true;
            case R.id.action_buscar:
                Log.i("ActionBar", "Buscar");;
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings");;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}