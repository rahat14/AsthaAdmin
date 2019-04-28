package com.metacodersbd.asthaadmin.viewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.metacodersbd.asthaadmin.R;

public class viewHolderForUser extends RecyclerView.ViewHolder {
    View mView;

    public viewHolderForUser(View itemView) {
        super(itemView);

        mView = itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });
        //item long click
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });

    }

    //set details to recycler view row
    public void setDetails(Context ctx, String userName, String UserPhone, String UID){
        //Views
        TextView uname = mView.findViewById(R.id.rUserName);
        TextView uphone = mView.findViewById(R.id.rUserPhone);
        TextView uid = mView.findViewById(R.id.rUserUid);







        //set data to views



        uname.setText("User Name :"+userName);
        uphone.setText("User Phone :"+UserPhone);
        uid.setText("Uid: "+UID);



        //  Picasso.get().load(image).error(R.drawable.loading).into(mImageIv);


    }


    private viewHolderForUser.ClickListener mClickListener;

    //interface to send callbacks
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(viewHolderForUser.ClickListener clickListener){
        mClickListener = clickListener;
    }

}
