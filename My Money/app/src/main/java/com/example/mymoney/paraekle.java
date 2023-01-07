package com.example.mymoney;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class paraekle extends AppCompatActivity {

    DrawerLayout cekmece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paraekle);

        cekmece=findViewById(R.id.cekmece_arkaplan);

        TextView ad=(TextView) findViewById(R.id.guncel);
        String vol1=getIntent().getStringExtra("değer");
        ad.setText(vol1.toString());

        int sayi1=8586;
        final EditText sayi2 = (EditText) findViewById(R.id.tutar);
        Button toplaBtn = (Button)findViewById(R.id.eklee);
        final TextView sonuc = (TextView) findViewById(R.id.guncel);

        toplaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float sayi01 = sayi1;
                float sayi02 = Float.parseFloat(sayi2.getText().toString());
                sonuc.setText(String.valueOf(sayi01+sayi02+ "TL"));
            }
        });


    }




    public void MenuyeTiklama(View view){

        cekmeceyiAc(cekmece);

    }

    public void cekmeceyiAc(DrawerLayout cekmece) {

        cekmece.openDrawer(GravityCompat.START);
    }

    public void LogoyaTiklama(View view){

        cekmeceyiKapat(cekmece);

    }

    public void cekmeceyiKapat(DrawerLayout cekmece) {

        if (cekmece.isDrawerOpen(GravityCompat.START)){
            cekmece.closeDrawer(GravityCompat.START);
        }
    }
    public void AnaSayfaTiklama(View view){

        Intent intent=new Intent(paraekle.this,ana.class);
        startActivity(intent);
    }
    public void YonetimTiklama(View view){

        Intent intent=new Intent(paraekle.this,Admin.class);
        startActivity(intent);
    }

    public void Iletisim(View view){

        Intent intent=new Intent(paraekle.this,Admin2.class);
        startActivity(intent);
    }
    public void CikisTiklama(View view){

        AlertDialog.Builder uyariPenceresi=new AlertDialog.Builder(paraekle.this);
        uyariPenceresi.setTitle("Çıkış");
        uyariPenceresi.setMessage("Çıkış Yapılsınmı ?");
        uyariPenceresi.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                finishAffinity();

                System.exit(0);
            }
        });

        uyariPenceresi.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {


            }
        });

        uyariPenceresi.show();
    }

    protected void onPause() {

        super.onPause();

        cekmeceyiKapat(cekmece);
        super.onPause();
    }
}