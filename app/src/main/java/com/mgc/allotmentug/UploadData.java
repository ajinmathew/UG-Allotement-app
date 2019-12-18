package com.mgc.allotmentug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class UploadData extends AppCompatActivity {
EditText maths,web,accounting,disaster;
int matlimit,acclimit,dislimit,weblimit,count,pcount;
Button btnUpload;


    public String arr[][]=new String[10][3];
    public int i=0;
    String temp,temp2;



    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_upload_data );
        maths=(EditText) findViewById( R.id.countmaths );
        web=(EditText)findViewById( R.id.countweb );
        accounting=(EditText)findViewById( R.id.countaccounting );
        disaster=(EditText)findViewById( R.id.countdisaster );
        btnUpload=findViewById( R.id.upload );

        t1=findViewById( R.id.txt1 );
        t2=findViewById( R.id.txt2 );
        t3=findViewById( R.id.txt3 );
        t4=findViewById( R.id.txt4 );


        DatabaseReference dReffer= FirebaseDatabase.getInstance().getReference().child("Alldata");
        dReffer.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                count= (int) dataSnapshot.getChildrenCount();
                if(dataSnapshot.exists())
                {
                    Toast.makeText( UploadData.this,"Total number of Registered Students "+count,Toast.LENGTH_LONG ).show();
                }
                else
                {
                    Toast.makeText( UploadData.this,"...!!!DataBase contain No student Detials!!!... ",Toast.LENGTH_SHORT ).show();
                }
                Toast.makeText( UploadData.this,"DataBase Contain "+count+" Students Data's",Toast.LENGTH_SHORT).show();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    String regno= (String) dataSnapshot1.child( "registerno" ).getValue();
                    String indmark= (String) dataSnapshot1.child( "indexmark" ).getValue();
                    arr[i][0]= regno;
                    arr[i][1]=indmark;
                    arr[i][2]="Ajin";
                    i++;
                }
                //sorting detials.....
                for(int i=0;i<count;i++)
                {
                    for(int j=i+1;j<count;j++)
                    {
                        if(Float.parseFloat(arr[i][1])<Float.parseFloat(arr[j][1]))
                        {
                            temp = arr[i][1];
                            arr[i][1] = arr[j][1];
                            arr[j][1] = temp;
                            temp2 = arr[i][0];
                            arr[i][0] = arr[j][0];
                            arr[j][0] = temp2;
                        }
                    }
                }
                Toast.makeText( UploadData.this,"Succesfully ordered "+count+" Datas",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
        btnUpload.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting the limit...
                acclimit=Integer.parseInt( accounting.getText().toString().trim() );
                dislimit=Integer.parseInt( disaster.getText().toString().trim() );
                matlimit=Integer.parseInt( maths.getText().toString().trim() );
                weblimit=Integer.parseInt( web.getText().toString().trim() );

                for(int i=0;i<count;i++)
                {

                }

                Toast.makeText( UploadData.this,"Succesfully uploaded "+count+" Datas",Toast.LENGTH_LONG).show();
            }
        } );
    }



}
