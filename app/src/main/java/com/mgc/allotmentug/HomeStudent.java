package com.mgc.allotmentug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;
import java.util.StringTokenizer;

public class HomeStudent extends AppCompatActivity {

    TextView profileName, profileAge, profileEmail,profilegender,profiledepartmnt,profileutyregno,profiletotalmark,profileobmark,profilestream,diaster,acounting,web,maths;
    Button update;
    DatabaseReference reff;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home_student );
        profileName = findViewById( R.id.sname );
        profileAge = findViewById( R.id.sage );
        profileEmail=findViewById( R.id.semail );
        profilegender=findViewById( R.id.sgender );
        profiledepartmnt=findViewById( R.id.sdepartment );
        profileutyregno=findViewById( R.id.sUtyRegNo );
        profiletotalmark=findViewById( R.id.stotalmark );
        profileobmark=findViewById( R.id.sobtmark );
        profilestream=findViewById( R.id.sstream );
        diaster=findViewById( R.id.sdisaster );
        acounting=findViewById( R.id.saccounting );
        web=findViewById( R.id.sweb );
        maths=findViewById( R.id.smaths );
        student=new Student( );
        //geting the intented values...
        final String registerno=getIntent().getStringExtra( "data" );
        update=findViewById( R.id.updatestudent );
        reff=FirebaseDatabase.getInstance().getReference().child( "Alldata" ).child( registerno );
        reff.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String name=dataSnapshot.child( "name" ).getValue().toString();
               String age=dataSnapshot.child( "age" ).getValue().toString();
               String email=dataSnapshot.child( "email" ).getValue().toString();
               final String password=dataSnapshot.child( "password" ).getValue().toString();
               String gender=dataSnapshot.child( "gender" ).getValue().toString();
               String department=dataSnapshot.child( "department" ).getValue().toString();
               String utyregno=dataSnapshot.child( "registerno" ).getValue().toString();
               String totalmark=dataSnapshot.child( "totalmark" ).getValue().toString();
               String obtainedmark=dataSnapshot.child( "obtainedmark" ).getValue().toString();
               String stream=dataSnapshot.child( "stream" ).getValue().toString();
               String disa=dataSnapshot.child( "disaster" ).getValue().toString();
               String accou=dataSnapshot.child( "accounting" ).getValue().toString();
               String webtech=dataSnapshot.child( "web" ).getValue().toString();
               String math=dataSnapshot.child( "maths" ).getValue().toString();
               final String indexmark=dataSnapshot.child( "indexmark" ).getValue().toString();
               final String verify=dataSnapshot.child( "verify" ).getValue().toString();
               final String opencourse=dataSnapshot.child( "opencourse" ).getValue().toString();
                profileName.setText( name );
                profileAge.setText( age );
                profilegender.setText( gender );
                profileEmail.setText( email );
                profileutyregno.setText( utyregno );
                profiledepartmnt.setText( department );
                profiletotalmark.setText( totalmark );
                profileobmark.setText( obtainedmark );
                profilestream.setText( stream );
                diaster.setText( disa );
                acounting.setText( accou );
                web.setText( webtech );
                maths.setText( math );
                update.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String age=profileAge.getText().toString().trim();
                        String name=profileName.getText().toString().trim();
                        String utyregno=profileutyregno.getText().toString().trim();
                        String gender=profilegender.getText().toString().trim();
                        String department=profiledepartmnt.getText().toString().trim();
                        String totalmark=profiletotalmark.getText().toString().trim();
                        String obtainedmark=profileobmark.getText().toString().trim();
                        String stream=profilestream.getText().toString().trim();
                        String disa=diaster.getText().toString().trim();
                        String accou=acounting.getText().toString().trim();
                        String webtech=web.getText().toString().trim();
                        String math=maths.getText().toString().trim();
                        String email=profileEmail.getText().toString().trim();
                        //calculations for index mark....
                        float caltotlmark= Float.parseFloat( totalmark );
                        float calobtmark= Float.parseFloat( obtainedmark );
                        float calcindex=(calobtmark/caltotlmark)*1000;
                        String indexmark= String.valueOf( calcindex );
                        student.setIndexmark( indexmark );
                        student.setName( name );
                        student.setAge( age );
                        student.setRegisterno( utyregno );
                        student.setDepartment( department );
                        student.setGender( gender);
                        student.setTotalmark( totalmark );
                        student.setObtainedmark( obtainedmark );
                        student.setStream( stream );
                        student.setDisaster( disa );
                        student.setAccounting( accou );
                        student.setWeb( webtech );
                        student.setMaths( math );
                        student.setEmail( email );
                        student.setOpencourse( opencourse );
                        student.setVerify( verify );
                        student.setPassword( password );
                        DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child("Alldata").child(registerno);
                        mDatabase.setValue(student);
                        Toast.makeText( HomeStudent.this,"Data Updated",Toast.LENGTH_SHORT ).show();
                    }
                } );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        } );

    }

}

