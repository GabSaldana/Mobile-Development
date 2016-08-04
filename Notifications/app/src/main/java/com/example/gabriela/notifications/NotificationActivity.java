package com.example.gabriela.notifications;

import android.os.Bundle;
import android.app.*;
import android.content.*;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.NotificationCompat;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NotificationActivity extends Activity {
    int t=200, i=0;
    boolean c=true;
    TextView jtv;
    Button jbnN;
    private static final int NOTIF_ALERTA_ID = 1;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_notification);
        jtv = (TextView) findViewById(R.id.xtv);
        jbnN = (Button)findViewById(R.id.xbnN);
        jbnN.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                NotificationCompat.Builder ncb =
                        new NotificationCompat.Builder(NotificationActivity.this)
                                .setSmallIcon(android.R.drawable.stat_sys_warning)
                                .setLargeIcon((((BitmapDrawable) getResources()
                                        .getDrawable(R.mipmap.ic_launcher)).getBitmap()))
                                .setContentTitle("Alerta de Notificación")
                                .setContentText("Uso de una notificación." + "i = " + i)
                                .setContentInfo("5")
                                .setTicker("Mensaje de Alerta!");
                Intent in = new Intent(NotificationActivity.this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this, 0, in, 0);
                ncb.setContentIntent(pi);
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(NOTIF_ALERTA_ID, ncb.build());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notification, menu);
        return true;
    }
}
