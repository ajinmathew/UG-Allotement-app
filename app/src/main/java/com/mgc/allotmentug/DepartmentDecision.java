package com.mgc.allotmentug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DepartmentDecision extends AppCompatActivity {
    Button btnverify,btnupload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_department_decision );
        btnverify=findViewById( R.id.verifystudent );
        btnverify.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),HomeDepartmentCard.class ) );
            }
        } );
        btnupload=findViewById( R.id.uploadstudent );
        btnupload.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),UploadData.class ) );
            }
        } );

    }
}
