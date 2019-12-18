package com.mgc.allotmentug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeDepartmentCard extends AppCompatActivity {

    private DatabaseReference mData;
    private RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home_department_card );
        mData=FirebaseDatabase.getInstance().getReference().child( "Alldata" );
        mData.keepSynced( true );
        mList=(RecyclerView)findViewById( R.id.recyclerviewpage );
        mList.setHasFixedSize( true );
        mList.setLayoutManager( new LinearLayoutManager( this ) );

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<CardDetials,CardViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<CardDetials, CardViewHolder>
                (CardDetials.class,R.layout.cardview,CardViewHolder.class,mData) {
            @Override
            protected void populateViewHolder(CardViewHolder cardViewHolder, CardDetials cardDetials, int i) {
                cardViewHolder.setRegisterno(cardDetials.getRegisterno());
                cardViewHolder.setName(cardDetials.getName());
                cardViewHolder.setVerify(cardDetials.getVerify());
            }
        };
        mList.setAdapter( firebaseRecyclerAdapter );
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public CardViewHolder(@NonNull View itemView) {
            super( itemView );
            mView=itemView;
        }
        public void setRegisterno(final String registerno)
        {
            TextView txtregno=mView.findViewById( R.id.card_regno );
            txtregno.setText( registerno );
            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent in=new Intent( view.getContext(),DepartmentVerify.class );
                    in.putExtra( "registerno",registerno );
                    view.getContext().startActivity( in );
                }
            } );
        }
        public void setName(String name)
        {
            TextView txtname=mView.findViewById( R.id.card_name );
            txtname.setText( name );
        }
        public void setVerify(String verify)
        {
            TextView txtverify=mView.findViewById( R.id.card_verify );
            txtverify.setText( verify );
        }
    }
}
