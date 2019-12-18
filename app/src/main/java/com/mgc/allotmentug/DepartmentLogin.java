package com.mgc.allotmentug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DepartmentLogin extends AppCompatActivity {
    EditText deptname,deptpassword;
    Button deptlog;
    String nam="Department";
    String pass="dept123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_department_login );
        deptname=findViewById( R.id.username_dept );
        deptpassword=findViewById( R.id.userpassword_dept );
        deptlog=findViewById( R.id.loginuser_dept );
        deptlog.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=deptname.getText().toString().trim();
                String password=deptpassword.getText().toString().trim();
                if(name.equals( nam )&password.equals( pass )){
                    startActivity( new Intent( getApplicationContext(), DepartmentDecision.class ) );
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login Error...",Toast.LENGTH_SHORT).show();
                }
            }
        } );


    }
}
