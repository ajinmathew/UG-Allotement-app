package com.mgc.allotmentug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentLoginPage extends AppCompatActivity {
    private EditText regno;
    private EditText password;
    private Button btnlogin;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;
    DatabaseReference dref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_student_login_page );
        mAuth=FirebaseAuth.getInstance();
        mDialog=new ProgressDialog(this);
        password=findViewById(R.id.paswordstd);
        regno=findViewById( R.id.regnostd );
        btnlogin=findViewById(R.id.btn_login);
        btnlogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reg=regno.getText().toString().trim();
                dref= FirebaseDatabase.getInstance().getReference().child( "Alldata" ).child( reg );
                dref.addValueEventListener( new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String mEmail=dataSnapshot.child( "email" ).getValue().toString();
                        String mPassword=password.getText().toString().trim();
                        if (TextUtils.isEmpty(mEmail))
                        {
                            Toast.makeText(getApplicationContext(),"...accessing emaiid error...",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(mPassword))
                        {
                            password.setError("Required Field...");
                            return;
                        }
                        mDialog.setMessage("Processing...");
                        mDialog.show();
                        mAuth.signInWithEmailAndPassword(mEmail,mPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    String da=regno.getText().toString();
                                    Toast.makeText(getApplicationContext(),"Authentication Complete...",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(StudentLoginPage.this,s_home.class);
                                    intent.putExtra( "data",da );
                                    startActivity(intent);
                                    mDialog.dismiss();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Error...Authentication Failed...",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                } );
            }
        } );
    }
}
