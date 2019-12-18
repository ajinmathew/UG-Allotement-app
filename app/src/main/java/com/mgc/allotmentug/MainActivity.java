package com.mgc.allotmentug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent(getApplicationContext(),OptStudent.class ) );
                finish();
            }
        },SPLASH_TIME);
    }
}
