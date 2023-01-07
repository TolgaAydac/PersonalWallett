package com.example.mymoney;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.widget.TextViewKt;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ana extends AppCompatActivity {

    private TextView text,copyBtn,Ekle,gonder;

    DrawerLayout cekmece;

     TextView mevcutpara;

    ImageView image1,image2,image3;
    Button button1,button2;
    TextView Doviz;

    public void init(){

        image1 =(ImageView) findViewById(R.id.img1);
        image2 =(ImageView) findViewById(R.id.img2);
        button1 =(Button) findViewById(R.id.buton1);
        button2 =(Button) findViewById(R.id.buton2);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana);


        init();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image1.setVisibility(view.VISIBLE);
                image2.setVisibility(View.INVISIBLE);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image1.setVisibility(view.INVISIBLE);
                image2.setVisibility(View.VISIBLE);

            }
        });





        TextView ad=(TextView) findViewById(R.id.ad);
        String vol1=getIntent().getStringExtra("değer");
        ad.setText(vol1.toString());

        mevcutpara=(TextView)findViewById(R.id.mevcutpara);

        Doviz=findViewById(R.id.doviz);
        gonder=findViewById(R.id.gonder);
        Ekle=findViewById(R.id.paraekle);
        cekmece=findViewById(R.id.cekmece_arkaplan);
        text = (TextView) findViewById(R.id.iban);
        copyBtn = (TextView) findViewById(R.id.ibankopya);



        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView edit1=(TextView) findViewById(R.id.mevcutpara);
                Intent ıntent=new Intent(ana.this,paragonder.class);
                ıntent.putExtra("değer",edit1.getText().toString());
                startActivity(ıntent);


            }
        });

        Ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView edit1=(TextView) findViewById(R.id.mevcutpara);
                Intent ıntent=new Intent(ana.this,paraekle.class);
                ıntent.putExtra("değer",edit1.getText().toString());
                startActivity(ıntent);

            }
        });


        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData  clip = ClipData.newPlainText("TextView",text.getText().toString());
                clipboardManager.setPrimaryClip(clip);
                clip.getDescription();

               // Toast.makeText(ana.this,"",Toast.LENGTH_SHORT).show();
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

        recreate();
    }
    public void YonetimTiklama(View view){

        Intent intent=new Intent(ana.this,Admin.class);
        startActivity(intent);
    }

    public void Iletisim(View view){

        Intent intent=new Intent(ana.this,Admin2.class);
        startActivity(intent);
    }
    public void doviztiklama(View view){

        Intent intent=new Intent(ana.this,Doviz.class);
        startActivity(intent);
    }
    public void CikisTiklama(View view){

        AlertDialog.Builder uyariPenceresi=new AlertDialog.Builder(ana.this);
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