package com.example.mymoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class hesapolustur extends AppCompatActivity {

    private String name_,surname_,location_,password_,phoneNumber_,tcNumber_;
    private EditText name,surname,phoneNumber,location,tcNumber,password;
    private Button create;
    private Intent intent;
    private int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesapolustur);


    }
    public void create(View view){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        create = (Button) findViewById(R.id.kaydet);
        name = (EditText) findViewById(R.id.ad);
        surname = (EditText) findViewById(R.id.soyad);
        location = (EditText) findViewById(R.id.adres);
        phoneNumber = (EditText) findViewById(R.id.tel);
        tcNumber = (EditText) findViewById(R.id.tc);
        password = (EditText) findViewById(R.id.şifre);

        name_ = name.getText().toString();
        surname_ = surname.getText().toString();
        location_= location.getText().toString();
        phoneNumber_ = phoneNumber.getText().toString();
        tcNumber_ = tcNumber.getText().toString();
        password_ = password.getText().toString();



        if (create.isEnabled()) {
            myRef.child("User" + i).child("TC").setValue(tcNumber_);
            myRef.child("User" + i).child("Name").setValue(name_);
            myRef.child("User" + i).child("Surname").setValue(surname_);
            myRef.child("User" + i).child("Location").setValue(location_);
            myRef.child("User" + i).child("Phone").setValue(phoneNumber_);
            myRef.child("User" + i).child("Password").setValue(password_);
            i++;
            intent = new Intent(hesapolustur.this,MainActivity.class);
            startActivity(intent);
        }


    }

}