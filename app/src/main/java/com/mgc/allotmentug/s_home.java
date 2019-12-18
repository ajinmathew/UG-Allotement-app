package com.mgc.allotmentug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class s_home extends AppCompatActivity {
Button btnupadatestd;
TextView txt1,txtname1,txtindex1,txtdis1,txtdis2;
    DatabaseReference dbrefer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_s_home );
        btnupadatestd=findViewById( R.id.updateprofile );
        txt1=findViewById( R.id.regnew1 );
        txtname1=findViewById( R.id.namenew1 );
        txtindex1=findViewById( R.id.indexnew1 );
        txtdis1=findViewById( R.id.disnew1 );
        btnupadatestd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String da=txt1.getText().toString();
                Intent intent=new Intent(s_home.this,HomeStudent.class);
                intent.putExtra( "data",da );
                startActivity(intent);
            }
        } );
        final String registerno=getIntent().getStringExtra( "data" );
        txt1.setText( registerno );
        dbrefer= FirebaseDatabase.getInstance().getReference().child( "Alldata" ).child( registerno );
        dbrefer.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child( "name" ).getValue().toString();
                txtname1.setText( name );
                String index=dataSnapshot.child( "indexmark" ).getValue().toString();
                txtindex1.setText( index );
                String open=dataSnapshot.child( "opencourse" ).getValue().toString();
                if(open.equals( "Not alloted" ))
                {
                    txtdis1.setText( "Not alloted any course!..." );
                }else {
                    txtdis1.setText( "Alloted to "+open );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );

    }
}
