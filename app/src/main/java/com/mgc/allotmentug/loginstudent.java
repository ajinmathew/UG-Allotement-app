package com.mgc.allotmentug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class loginstudent extends AppCompatActivity {
    EditText txtage,txtname,txtdept,txtUtyRegNo,totalmark,obtainedmark,email1,password1;
    RadioButton gendermale,genderfemale,stream_hse,stream_vhse,stream_thse,disaster1,disaster2,disaster3,disaster4,accounting1,accounting2,accounting3,accounting4,webT1,webT2,webT3,webT4,maths1,maths2,maths3,maths4;
    Button register;
    private ProgressDialog mDialog;
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    FirebaseUser mUser=mAuth.getCurrentUser();
    Student student;
    String gender="";
    String stream="";
    String  disaster="";
    String accounting="";
    String web="";
    String maths="";
    String verify="no";
    String opencourse="Not alloted";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_loginstudent );
        mDialog=new ProgressDialog(this);
        txtname=(EditText)findViewById( R.id.name );
        txtage=(EditText)findViewById( R.id.age );
        txtdept=(EditText)findViewById( R.id.department );
        txtUtyRegNo=(EditText)findViewById( R.id.UtyRegNo );
        gendermale=(RadioButton) findViewById( R.id.radio_male );
        genderfemale=(RadioButton) findViewById( R.id.radio_female );
        totalmark=(EditText)findViewById( R.id.aggmark );
        obtainedmark=(EditText)findViewById( R.id.obtmark );
        register=(Button)findViewById( R.id.register_student );
        stream_hse=(RadioButton)findViewById( R.id.hse );
        stream_vhse=(RadioButton)findViewById( R.id.vhse );
        stream_thse=(RadioButton)findViewById( R.id.thse );
        disaster1=(RadioButton)findViewById( R.id.dis1 );
        disaster2=(RadioButton)findViewById( R.id.dis2 );
        disaster3=(RadioButton)findViewById( R.id.dis3 );
        disaster4=(RadioButton)findViewById( R.id.dis4 );
        accounting1=(RadioButton)findViewById( R.id.acc1 );
        accounting2=(RadioButton)findViewById( R.id.acc2 );
        accounting3=(RadioButton)findViewById( R.id.acc3 );
        accounting4=(RadioButton)findViewById( R.id.acc4 );
        webT1=(RadioButton)findViewById( R.id.web1 );
        webT2=(RadioButton)findViewById( R.id.web2 );
        webT3=(RadioButton)findViewById( R.id.web3 );
        webT4=(RadioButton)findViewById( R.id.web4 );
        maths1=(RadioButton)findViewById( R.id.mat1 );
        maths2=(RadioButton)findViewById( R.id.mat2 );
        maths3=(RadioButton)findViewById( R.id.mat3 );
        maths4=(RadioButton)findViewById( R.id.mat4 );
        email1=(EditText)findViewById( R.id.email_student );
        password1=(EditText)findViewById( R.id.password_student );
        student=new Student( );
        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age=txtage.getText().toString().trim();
                String registerno=txtUtyRegNo.getText().toString().trim();
                if(gendermale.isChecked()){
                    gender="male";
                }
                if(genderfemale.isChecked()){
                    gender="female";
                }
                String name=txtname.getText().toString().trim();
                String  markobtained=obtainedmark.getText().toString().trim();
                if(stream_hse.isChecked()){
                    stream="HSE";
                }
                if(stream_vhse.isChecked()){
                    stream="VHSE";
                }
                if(stream_thse.isChecked()){
                    stream="THSE";
                }
                if(disaster1.isChecked()){
                    disaster="1";
                }
                if(disaster2.isChecked()){
                    disaster="2";
                }
                if(disaster3.isChecked()){
                    disaster="3";
                }
                if(disaster4.isChecked()){
                    disaster="4";
                }
                if(accounting1.isChecked()){
                    accounting="1";
                }
                if(accounting2.isChecked()){
                    accounting="2";
                }
                if(accounting3.isChecked()){
                    accounting="3";
                }
                if(accounting4.isChecked()){
                    accounting="4";
                }
                if(webT1.isChecked()){
                    web="1";
                }
                if(webT2.isChecked()){
                    web="2";
                }
                if(webT3.isChecked()){
                    web="3";
                }
                if(webT4.isChecked()){
                    web="4";
                }

                if(maths1.isChecked()){
                    maths="1";
                }
                if(maths2.isChecked()){
                    maths="2";
                }
                if(maths3.isChecked()){
                    maths="3";
                }
                if(maths4.isChecked()){
                    maths="4";
                }
                String marktotal=totalmark.getText().toString().trim();
                String emai1=email1.getText().toString().trim();
                String password=password1.getText().toString().trim();
                String department=txtdept.getText().toString().trim();
                float caltotlmark= Float.parseFloat( marktotal );
                float calobtmark= Float.parseFloat( markobtained );
                float calcindex=(calobtmark/caltotlmark)*1000;
                String indexmark= String.valueOf( calcindex );
                student.setIndexmark( indexmark );
                student.setName( name );
                student.setAge( age );
                student.setRegisterno( registerno );
                student.setDepartment( department );
                student.setGender( gender);
                student.setTotalmark( marktotal );
                student.setObtainedmark( markobtained );
                student.setStream( stream );
                student.setDisaster( disaster );
                student.setAccounting( accounting );
                student.setWeb( web );
                student.setMaths( maths );
                student.setEmail( emai1 );
                student.setPassword( password );
                student.setVerify( verify );
                student.setOpencourse( opencourse );
                DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child("Alldata").child(registerno);
                mDatabase.setValue(student);
                Toast.makeText( loginstudent.this,"Data Inserted",Toast.LENGTH_SHORT ).show();
                mDialog.setMessage("Processing...");
                mDialog.show();
                mAuth.createUserWithEmailAndPassword(emai1,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            String da=txtUtyRegNo.getText().toString();
                            Toast.makeText(getApplicationContext(),"Complete...",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(loginstudent.this,s_home.class);
                            intent.putExtra( "data",da );
                            startActivity( intent );
                            mDialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Registeration Error...",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        } );
    }
}
