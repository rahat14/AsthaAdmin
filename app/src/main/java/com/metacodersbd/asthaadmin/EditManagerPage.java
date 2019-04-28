package com.metacodersbd.asthaadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class EditManagerPage extends AppCompatActivity {
    EditText shoppName , shopphone , shopmail,memberId , shopadress , userName , UseNID , UserPhone ;
    DatabaseReference mref ;

    String uid ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_manager_page);
        //Setting UP Views
        shoppName = findViewById(R.id.shopNameProfile);
        shopphone = findViewById(R.id.PhoneProfile);
        shopmail = findViewById(R.id.emailProfile);
        memberId = findViewById(R.id.membershipProfile);
        shopadress = findViewById(R.id.addressProfile);
        userName = findViewById(R.id.ownerNameProfile);
        UseNID = findViewById(R.id.NidProfile);
        UserPhone = findViewById(R.id.OnwerPhoneProfile);


Intent i = getIntent();
        String sname = i.getStringExtra("SHOPNAME");
        String shopPh = i.getStringExtra("SHOPPH") ;
        String ShopMail = i.getStringExtra("SHOPMAIL") ;
        String memberID = i.getStringExtra("MEMBERID") ;
        String shopAdress = i.getStringExtra("SHOPADRESS") ;
        String managerName = i.getStringExtra("MANGERNAME") ;
        String Nid = i.getStringExtra("NID") ;
        String userPhone = i.getStringExtra("USERPhone") ;


            shoppName.setText(sname);
            shopphone.setText(shopPh);
            shopmail.setText(ShopMail);
            memberId.setText(memberID);
            shopadress.setText(shopAdress);
            userName.setText(managerName);
            UseNID.setText(Nid);
            UserPhone.setText(userPhone);



    }
}
