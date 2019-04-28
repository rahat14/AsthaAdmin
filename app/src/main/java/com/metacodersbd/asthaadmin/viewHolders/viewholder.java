package com.metacodersbd.asthaadmin.viewHolders;

import android.content.Context;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.metacodersbd.asthaadmin.R;

public class viewholder extends  RecyclerView.ViewHolder {

    View mView;

    public viewholder(View itemView) {
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
    public void setDetails(Context ctx,String ShopName , String shopadree ,String shopphone , String shopemail , String memberId , String fbid
   , String ownerid ,String OwnerPhone , String OwnerEmail , String OwnerNid , String Uid , String isVerified ){
        //Views
        TextView shopName = mView.findViewById(R.id.rShopName);
        TextView shopAdress = mView.findViewById(R.id.rshopadress);
        TextView shopPhone = mView.findViewById(R.id.rshopPhone);
        TextView shopEmail = mView.findViewById(R.id.rshopmail);
        TextView memberid = mView.findViewById(R.id.rmemberid);
        TextView fbId =mView.findViewById(R.id.rfbid);
        TextView ownerId = mView.findViewById(R.id.rmanagerName);
        TextView ownerPhone = mView.findViewById(R.id.rownerphone);
        TextView ownerEmail =mView.findViewById(R.id.rownerEmail);
        TextView ownerNID = mView.findViewById(R.id.rownerNid);
        TextView uid = mView.findViewById(R.id.ruid);
        TextView isverified = mView.findViewById(R.id.rVerified);

        //set data to views

        shopAdress.setText(shopadree);
        shopPhone.setText(shopphone);
        shopEmail.setText(shopemail);
        memberid.setText(memberId);
        fbId.setText(fbid);
        shopName.setText("Shop Name :"+ShopName);
        ownerId.setText("Manager Name : "+ownerid);
        ownerPhone.setText(OwnerPhone);
        ownerEmail.setText(OwnerEmail);
        ownerNID.setText(OwnerNid);
        uid.setText(Uid);
        isverified.setText(isVerified);



        //  Picasso.get().load(image).error(R.drawable.loading).into(mImageIv);


    }


    private viewholder.ClickListener mClickListener;

    //interface to send callbacks
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(viewholder.ClickListener clickListener){
        mClickListener = clickListener;
    }



}
