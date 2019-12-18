package com.mgc.allotmentug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptStudent extends AppCompatActivity {
Button loginNew,btnAdmin,btndept,btnreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_opt_student );
        loginNew=(Button)findViewById( R.id.NewLog );
        btndept=findViewById( R.id.logindept );
        btnAdmin=findViewById( R.id.loginadmin );
        //login student...
        loginNew.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),StudentLoginPage.class ) );
            }
        } );

        btnAdmin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),loginadmin.class ) );
            }
        } );
        btndept.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),DepartmentLogin.class ) );
            }
        } );
        //create new student...
        btnreg=findViewById( R.id.NewReg );
        btnreg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),loginstudent.class ) );
            }
        } );
    }
}
