package com.example.mymoney;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin2 extends AppCompatActivity {

    DrawerLayout cekmece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);

        cekmece=findViewById(R.id.cekmece_arkaplan);


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

        Intent intent=new Intent(Admin2.this,ana.class);
        startActivity(intent);
    }
    public void YonetimTiklama(View view){

        Intent intent=new Intent(Admin2.this,Admin.class);
        startActivity(intent);
    }

    public void Iletisim(View view){

        Intent intent=new Intent(Admin2.this,Admin2.class);
        startActivity(intent);
    }
    public void CikisTiklama(View view){

        AlertDialog.Builder uyariPenceresi=new AlertDialog.Builder(Admin2.this);
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