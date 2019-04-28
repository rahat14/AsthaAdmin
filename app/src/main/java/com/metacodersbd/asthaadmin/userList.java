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
import com.metacodersbd.asthaadmin.viewHolders.ViewHolderForProducts;
import com.metacodersbd.asthaadmin.viewHolders.viewHolderForUser;

public class userList extends AppCompatActivity {
    LinearLayoutManager mLayoutManager; //for sorting

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;

    DatabaseReference mRef;
    private ProgressBar Sales_progressBar ;


    public    String uid;
    FirebaseRecyclerAdapter<modelForUser, viewHolderForUser> firebaseRecyclerAdapter ;
    FirebaseRecyclerOptions<modelForUser> options ;
    Query firebaseSearchQuery ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        //RecyclerView
        mRecyclerView = findViewById(R.id.recycle_userList);


        // Sales_progressBar.setVisibility(View.VISIBLE);

        //set layout as LinearLayout
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("UsersProfile");
        firebaseSearchQuery = mRef.orderByChild("UsersProfile").startAt(uid).endAt(uid + "\uf8ff");

        mRef.keepSynced(true);

        // Toast.makeText(getApplicationContext(), "We Are Loading Data", Toast.LENGTH_SHORT).show();

        //load Data
        showData();

    }
    private  void showData(){

        options = new FirebaseRecyclerOptions.Builder<modelForUser>()
                .setQuery(  mRef , modelForUser.class)
                .build() ;

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<modelForUser, viewHolderForUser>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewHolderForUser holder, int position, @NonNull modelForUser model) {


                holder.setDetails(getApplicationContext(), model.getName() , model.getPhone() , model.getUid());

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //     Sales_progressBar.setVisibility(View.GONE);

                    }
                }, 3000);

            }



            @NonNull
            @Override
            public viewHolderForUser onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                //INflate the row
                Context context;
                View itemVIew = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowforuser, viewGroup, false);

                viewHolderForUser viewHolder = new viewHolderForUser(itemVIew);

                //itemClicklistener
                viewHolder.setOnClickListener(new viewHolderForUser.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        //Views
                        //   TextView mTitleTv = view.findViewById(R.id.rTitleTv);
                        //    TextView mDescTv = view.findViewById(R.id.rDescriptionTv);
                        //     ImageView mImageView = view.findViewById(R.id.rImageView);






                 //       Intent i = new Intent(view.getContext() , SalesDetailsPage.class);





                    //    startActivity(i);


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
