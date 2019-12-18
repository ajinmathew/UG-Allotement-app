package com.mgc.allotmentug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DepartmentVerify extends AppCompatActivity {
    TextView disname,disage,disregno,disdepartment,disgender,distotalmark,disobtmark,disstream,disdisaster,disweb,disaccount,dismaths,disemail,dispassword,disopen,disverify;
    Button btnVerify,btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_department_verify );

        Intent i=getIntent();
        final String reg=i.getStringExtra( "registerno" );
        btnVerify=findViewById( R.id.verifystudent );
        btnback=findViewById( R.id.cardhome );
        disregno=findViewById( R.id.veregno );
        disname=findViewById( R.id.dename );
        disage=findViewById( R.id.deage );
        disgender=findViewById( R.id.degender );
        disdepartment=findViewById( R.id.dedepartment );
        distotalmark=findViewById( R.id.detotalmark );
        disobtmark=findViewById( R.id.deobtmark );
        disstream=findViewById( R.id.destream );
        disdisaster=findViewById( R.id.dedisaster );
        disweb=findViewById( R.id.deweb );
        disaccount=findViewById( R.id.deaccount );
        dismaths=findViewById( R.id.demaths );
        disemail=findViewById( R.id.deemail );
        disopen=findViewById( R.id.deopencourse );
        dispassword=findViewById( R.id.depassword );
        disverify=findViewById( R.id.deverify );

        DatabaseReference dRef= FirebaseDatabase.getInstance().getReference().child( "Alldata" ).child( reg );
        disregno.setText( reg );
        dRef.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String name=dataSnapshot.child( "name" ).getValue().toString();
                final String age=dataSnapshot.child( "age" ).getValue().toString();
                final String email=dataSnapshot.child( "email" ).getValue().toString();
                final String gender=dataSnapshot.child( "gender" ).getValue().toString();
                final String department=dataSnapshot.child( "department" ).getValue().toString();
                final String totalmark=dataSnapshot.child( "totalmark" ).getValue().toString();
                final String obtainedmark=dataSnapshot.child( "obtainedmark" ).getValue().toString();
                final String stream=dataSnapshot.child( "stream" ).getValue().toString();
                final String disa=dataSnapshot.child( "disaster" ).getValue().toString();
                final String accou=dataSnapshot.child( "accounting" ).getValue().toString();
                final String webtech=dataSnapshot.child( "web" ).getValue().toString();
                final String math=dataSnapshot.child( "maths" ).getValue().toString();
                final String password=dataSnapshot.child( "password" ).getValue().toString();
                final String open=dataSnapshot.child( "opencourse" ).getValue().toString();
                final String verify=dataSnapshot.child( "verify" ).getValue().toString();
                //setting retrived detials...
                disname.setText( name );
                disage.setText( age );
                disaccount.setText( accou );
                disdepartment.setText( department );
                disdisaster.setText( disa );
                disgender.setText( gender );
                disobtmark.setText( obtainedmark );
                distotalmark.setText( totalmark );
                disemail.setText( email );
                disstream.setText( stream );
                disweb.setText( webtech );
                dismaths.setText( math );
                disopen.setText( open );
                dispassword.setText( password );
                disverify.setText( verify );
                //verify in default child...
                btnVerify.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child("Alldata").child(reg).child( "verify" );
                        mDatabase.setValue( "Verified" );
                        Toast.makeText( DepartmentVerify.this,"Student Verified",Toast.LENGTH_SHORT ).show();
                        //after display the current student data....

                    }
                } );
                btnback.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity( new Intent( getApplicationContext(),HomeDepartmentCard.class ) );
                    }
                } );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }
}
