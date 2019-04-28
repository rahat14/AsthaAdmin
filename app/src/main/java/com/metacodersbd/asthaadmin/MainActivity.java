package com.metacodersbd.asthaadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView customer_count , transaction_count , manager_Count  , products_Count ;
    CardView managerButton , productList , userLIST ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customer_count = findViewById(R.id.customerCount);
        transaction_count = findViewById(R.id.transactionCount);
        manager_Count = findViewById(R.id.ManagerCount);
        products_Count = findViewById(R.id.productsCount);
        managerButton = findViewById(R.id.managerID);
        productList = findViewById(R.id.productlist) ;
        userLIST = findViewById(R.id.userList) ;



        userLIST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(getApplicationContext(), userList.class) ;
                startActivity(o);



            }
        });

        managerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(getApplicationContext(), ManagerList.class) ;
                startActivity(o);



            }
        });
        productList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(getApplicationContext(), productList.class) ;
                startActivity(o);

            }
        });


        //Init Count
        coustomerCount();
        productsCount();
        managerCount();


    }

    private void managerCount() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

// i used the single or the value.. depending if you want to keep track
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //  Log.e(dataSnapshot.getKey(),dataSnapshot.getChildrenCount() + "");

                if(dataSnapshot.getKey().equals("shopOwner")){


                    manager_Count.setText(String.valueOf(dataSnapshot.getChildrenCount()));

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void productsCount() {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

// i used the single or the value.. depending if you want to keep track
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //  Log.e(dataSnapshot.getKey(),dataSnapshot.getChildrenCount() + "");

                if(dataSnapshot.getKey().equals("Products")){


                    products_Count.setText(String.valueOf(dataSnapshot.getChildrenCount()));

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void coustomerCount() {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

// i used the single or the value.. depending if you want to keep track
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
              //  Log.e(dataSnapshot.getKey(),dataSnapshot.getChildrenCount() + "");

                if(dataSnapshot.getKey().equals("UsersProfile")){


                    customer_count.setText(String.valueOf(dataSnapshot.getChildrenCount()));

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

}
