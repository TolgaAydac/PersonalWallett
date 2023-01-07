package com.example.mymoney;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText Name,tc,password;
    private String tc__,password__;
    private EditText Password;
    private TextView  Info;
    private Button Login;


    Button btn ;
    TextView txt;


    private int counter=3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name =(EditText) findViewById(R.id.tc);
        Password=(EditText) findViewById(R.id.şifre);
        Info =(TextView) findViewById(R.id.olustur);
        Login =(Button) findViewById(R.id.giris);

        txt=findViewById(R.id.hesap);




       /*
       Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
*/


        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent olustur=new Intent(MainActivity.this,hesapolustur.class);
                startActivity(olustur);


            }
        });


    }

/*
    private void validate(String userName,String userPassword){

        if ((userName.equals("123")) && (userPassword.equals("123"))){
            Intent intent = new Intent(MainActivity.this,ana.class);
            startActivity(intent);
        }else {
      counter--;

        }
    }
*/
    public void login(View view){


        tc =(EditText) findViewById(R.id.tc);
        tc__ = tc.getText().toString();
        password =(EditText) findViewById(R.id.şifre);
        password__ = password.getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot i : snapshot.getChildren()) {
                    var tc_ = i.child("TC");
                    var password_ = i.child("Password");

                    if (tc_.getValue().equals(tc__) && password_.getValue().equals(password__)) {
                        Intent intent = new Intent(MainActivity.this, ana.class);
                        startActivity(intent);

                        EditText edit1=(EditText) findViewById(R.id.ad);
                        Intent ıntent=new Intent(MainActivity.this,ana.class);
                        ıntent.putExtra("değer",edit1.getText().toString());
                        startActivity(ıntent);

                    } else {
                        counter--;


                        Info.setText("Kalan Deneme Hakkınız : "+String.valueOf(counter));

                        if (counter == 0 ){
                            Login.setEnabled(false);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The read failed: " + error.getCode());
            }
        });
    }

}