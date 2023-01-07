package com.example.mymoney;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class Doviz extends AppCompatActivity {

    DrawerLayout cekmece;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doviz);

        WebView wv=new WebView(context);
        WebSettings ws = wv.getSettings();
        ws.setBuiltInZoomControls(true);
        ws.setJavaScriptEnabled(true);
        wv.loadUrl("https://paracevirici.com/");
        setContentView(wv);



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

        Intent intent=new Intent(Doviz.this,ana.class);
        startActivity(intent);
    }
    public void YonetimTiklama(View view){

        Intent intent=new Intent(Doviz.this,Admin.class);
        startActivity(intent);
    }

    public void Iletisim(View view){

        Intent intent=new Intent(Doviz.this,Admin2.class);
        startActivity(intent);
    }
    public void CikisTiklama(View view){

        AlertDialog.Builder uyariPenceresi=new AlertDialog.Builder(Doviz.this);
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