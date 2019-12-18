package com.mgc.allotmentug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginadmin extends AppCompatActivity {
EditText username,userpassword;
Button btnlog;
String usename="Admin";
String usepass="admin123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_loginadmin );
        username=findViewById( R.id.username );
        userpassword=findViewById( R.id.userpassword );
        btnlog=findViewById( R.id.loginuser );
        btnlog.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString().trim();
                String password=userpassword.getText().toString().trim();
                if(name.equals( usename )&password.equals( usepass )){
                    startActivity( new Intent( getApplicationContext(),AdminHome.class ) );
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Error...",Toast.LENGTH_SHORT).show();
                }
            }
        } );

    }
}
