package com.metacodersbd.asthaadmin;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.metacodersbd.asthaadmin.viewHolders.viewholder;

public class ManagerList extends AppCompatActivity {

    LinearLayoutManager mLayoutManager; //for sorting

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;

    DatabaseReference mRef;
    private ProgressBar Sales_progressBar ;


    public    String uid;
    FirebaseRecyclerAdapter<modelForShopOwner, viewholder> firebaseRecyclerAdapter ;
    FirebaseRecyclerOptions<modelForShopOwner> options ;
    Query firebaseSearchQuery ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_list);

        mRecyclerView = findViewById(R.id.recycle_managerList) ;

        //set layout as LinearLayout
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("shopOwner");
        firebaseSearchQuery = mRef.orderByChild("shopuid").startAt(uid).endAt(uid + "\uf8ff");

        mRef.keepSynced(true);

        // Toast.makeText(getApplicationContext(), "We Are Loading Data", Toast.LENGTH_SHORT).show();

        //load Data
        showData();


    }

    private void showData() {
        options = new FirebaseRecyclerOptions.Builder<modelForShopOwner>()
                .setQuery(  mRef , modelForShopOwner.class)
                .build() ;

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<modelForShopOwner, viewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull modelForShopOwner model) {


                holder.setDetails(getApplicationContext(), model.getShopName(), model.getShopAdress(), model.getShopPhone() , model.getShopEmail(), model.getMemberId()
                        , model.getFbId() , model.getOwnerId() , model.getOwnerPhone() , model.getOwnerEmail() , model.getOwnerNID(), model.getUid()
                        ,model.getIsverified());

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                      //  Sales_progressBar.setVisibility(View.GONE);

                    }
                }, 3000);

            }



            @NonNull
            @Override
            public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                //INflate the row
                Context context;
                View itemVIew = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);

                viewholder viewHolder = new viewholder(itemVIew);

                //itemClicklistener
                viewHolder.setOnClickListener(new viewholder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        //Views
                        //   TextView mTitleTv = view.findViewById(R.id.rTitleTv);
                        //    TextView mDescTv = view.findViewById(R.id.rDescriptionTv);
                        //     ImageView mImageView = view.findViewById(R.id.rImageView);





                        String shoppName = getItem(position).getShopName();
                        String shopphone = getItem(position).getShopPhone();
                        String shopmail = getItem(position).getShopEmail();
                        String memberId = getItem(position).getMemberId();
                        String shopadress = getItem(position).getShopAdress();
                        String userName = getItem(position).getOwnerId();
                        String UseNID  = getItem(position).getOwnerNID() ;
                        String UserPhone = getItem(position).getOwnerPhone() ;



                        Intent i = new Intent(view.getContext() , EditManagerPage.class);
                        i.putExtra("SHOPNAME", shoppName);
                        i.putExtra("SHOPPH", shopphone);
                        i.putExtra("SHOPMAIL", shopmail);
                        i.putExtra("MEMBERID", memberId);
                        i.putExtra("SHOPADRESS", shopadress);
                        i.putExtra("MANGERNAME", userName);
                        i.putExtra("NID", UseNID);
                        i.putExtra("USERPhone", UserPhone);



                        startActivity(i);


                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });



                return viewHolder;
            }
        };


        mRecyclerView.setLayoutManager(mLayoutManager);
        firebaseRecyclerAdapter.startListening();
        //setting adapter

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }






    }

